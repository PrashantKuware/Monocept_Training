package com.monocept.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.monocept.demo.dto.DepartmentRequestDto;
import com.monocept.demo.dto.DepartmentResponseDto;
import com.monocept.demo.dto.EmployeeRequestDto;
import com.monocept.demo.dto.PageResponseDto;
import com.monocept.demo.exception.DuplicateResourceException;
import com.monocept.demo.exception.ResourceNotFoundException;
import com.monocept.demo.model.Department;
import com.monocept.demo.model.Employee;
import com.monocept.demo.repository.DepartmentRepository;
import com.monocept.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    private static final Logger logger =
            LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Override
    public DepartmentResponseDto createDepartment(
            DepartmentRequestDto requestDto) {

        logger.info("Creating department: {}",
                requestDto.getDepartmentName());

        if (departmentRepository.existsByDepartmentName(
                requestDto.getDepartmentName())) {

            throw new DuplicateResourceException(
                    "Department name already exists");
        }

        validateEmployeeEmailsForCreate(
                requestDto.getEmployees());

        Department department =
                modelMapper.map(requestDto,
                        Department.class);

        attachEmployeesToDepartment(department);

        Department savedDepartment =
                departmentRepository.save(department);

        logger.info("Department saved successfully");

        return modelMapper.map(
                savedDepartment,
                DepartmentResponseDto.class);
    }

    @Override
    public List<DepartmentResponseDto> getAllDepartments() {

        logger.info("Fetching all departments");

        return departmentRepository.findAll()
                .stream()
                .map(dept ->
                        modelMapper.map(
                                dept,
                                DepartmentResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PageResponseDto<DepartmentResponseDto>
            getAllDepartmentsWithPagination(
                    int pageNumber,
                    int pageSize) {

        validatePagination(pageNumber, pageSize);

        Pageable pageable =
                PageRequest.of(pageNumber, pageSize);

        Page<Department> page =
                departmentRepository.findAll(pageable);

        List<DepartmentResponseDto> content =
                page.getContent()
                .stream()
                .map(dept ->
                        modelMapper.map(
                                dept,
                                DepartmentResponseDto.class))
                .toList();

        return new PageResponseDto<>(
                content,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isLast());
    }

    @Override
    public DepartmentResponseDto getDepartmentById(
            Long id) {

        logger.info("Fetching department id {}", id);

        Department department =
                findDepartmentById(id);

        return modelMapper.map(
                department,
                DepartmentResponseDto.class);
    }

    @Override
    public DepartmentResponseDto updateDepartment(
            Long id,
            DepartmentRequestDto requestDto) {

        logger.info("Updating department id {}", id);

        Department department =
                findDepartmentById(id);

        if (departmentRepository
                .existsByDepartmentNameAndIdNot(
                        requestDto.getDepartmentName(),
                        id)) {

            throw new DuplicateResourceException(
                    "Department name already exists");
        }

        validateEmployeeEmailsForUpdate(
                requestDto.getEmployees());

        department.setDepartmentName(
                requestDto.getDepartmentName());

        department.setLocation(
                requestDto.getLocation());

        department.getEmployees().clear();

        List<Employee> updatedEmployees =
                requestDto.getEmployees()
                        .stream()
                        .map(empDto ->
                                modelMapper.map(
                                        empDto,
                                        Employee.class))
                        .toList();

        department.getEmployees()
                .addAll(updatedEmployees);

        attachEmployeesToDepartment(department);

        Department updated =
                departmentRepository.save(department);

        logger.info("Department updated");

        return modelMapper.map(
                updated,
                DepartmentResponseDto.class);
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department =
                findDepartmentById(id);

        logger.info("Deleting department {}", id);

        departmentRepository.delete(department);
    }

    // ==========================
    // PRIVATE METHODS
    // ==========================

    private Department findDepartmentById(Long id) {

        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found with id "
                                        + id));
    }

    private void attachEmployeesToDepartment(
            Department department) {

        for (Employee employee :
                department.getEmployees()) {

            employee.setDepartment(department);
        }
    }

    private void validateEmployeeEmailsForCreate(
            List<EmployeeRequestDto> employees) {

        for (EmployeeRequestDto employee : employees) {

            if (employeeRepository
                    .existsByEmail(employee.getEmail())) {

                throw new DuplicateResourceException(
                        "Employee email already exists : "
                                + employee.getEmail());
            }
        }
    }

    private void validateEmployeeEmailsForUpdate(
            List<EmployeeRequestDto> employees) {

        for (EmployeeRequestDto employee : employees) {

            if (employeeRepository
                    .existsByEmail(employee.getEmail())) {

                logger.warn(
                        "Possible duplicate email found {}",
                        employee.getEmail());
            }
        }
    }

    private void validatePagination(
            int pageNumber,
            int pageSize) {

        if (pageNumber < 0) {
            throw new IllegalArgumentException(
                    "Page number cannot be negative");
        }

        if (pageSize <= 0) {
            throw new IllegalArgumentException(
                    "Page size must be greater than 0");
        }

        if (pageSize > 100) {
            throw new IllegalArgumentException(
                    "Page size cannot exceed 100");
        }
    }
}
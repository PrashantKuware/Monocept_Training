package com.monocept.demo.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDTO<T>
{
	private List<T> content;
	private int pageNumber;
	private int pageSize;
	private int totalPages;
	private boolean lastPage;
	private long totalCount;
	
	
}

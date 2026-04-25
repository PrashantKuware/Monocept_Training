package assignment.user_class.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assignment.user_class.model.User;

class UserTest 
{

	User user;

    
    @BeforeEach
    void setup() {
        System.out.println("Setting up User object...");
        user = new User("Prashant", 25);
    }

    
    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
        user = null;
    }

   
    @Test
    void testValidUser() {
    	 System.out.println("testValidUser");
        assertNotNull(user);
        assertEquals("Prashant", user.getName());
        assertEquals(25, user.getAge());
    }

   
    @Test
    void testNullName() {
    	 System.out.println("testNullName");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new User(null, 25);
        });

        assertEquals("Name cannot be null", ex.getMessage());
    }

    
    @Test
    void testInvalidAge() {
    	 System.out.println("testInvalidAge");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new User("John", -5);
        });

        assertEquals("Invalid age", ex.getMessage());
    }

}

package com.example;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PasswordValidatorTest {

    @Test
    public void testPasswordValidator() {
        // Arrange
        //Create mock notification service
        NotificationService mockNotificationService = mock(NotificationService.class);
        //Inject mock to PasswordValidator
        PasswordValidator validator = new PasswordValidator(mockNotificationService);


        // Condition 1: 8 or more characters
        // Condition 2: 1 or more uppercase letters

        // Test case 1: meets condition 1 and 2 (valid)
        assertTrue(validator.isValidPassword("Mypassword1234"));
        verify(mockNotificationService).sendNotification("Password is valid");
        // Test case 2: meets condition 1 (invalid)
        assertFalse(validator.isValidPassword("mypassword1234"));

        // Test case 3: meets condition 2 (invalid)
        assertFalse(validator.isValidPassword("MyPass"));

        // Test case 4: meets no condition (invalid)
        assertFalse(validator.isValidPassword("mypass"));

        // Test case 5: null password (invalid)
        assertFalse(validator.isValidPassword(null));
    }
}
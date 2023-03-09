package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    public static final String EMPTY_LOGIN = "";
    public static final String EMPTY_PASSWORD = "";
    public static final String CORRECT_LOGIN = "anna@gmail.com";
    public static final String CORRECT_PASSWORD = "qwerty123";
    public static final String PASSWORD_EQUALS_LOGIN = "anna@gmail.com";
    public static final String NOT_CORRECT_LOGIN = "annagmailcom";
    public static final String NOT_CORRECT_LOGIN_MESSAGE = "Login is not correct";
    public static final String NOT_CORRECT_PASSWORD_MESSAGE = "Password and Login must be different";
    public static final String CORRECT_CREDENTIALS = "Credentials are correct!";
    public static final String NOT_CORRECT_MESSAGE = "Mandatory fields!";


    @Test
    void shouldReturnDefaultMessageWhenEmailAndPasswordIsNotEmpty() {
        User out = new User(CORRECT_LOGIN, CORRECT_PASSWORD);
        String result = out.getCredentials("email", "pwd");
        assertTrue(result.equals(CORRECT_CREDENTIALS), result);
    }

    @Test
    void shouldReturnDefaultMessageWhenEmailOrLoginIsNull() {
        User out = new User(CORRECT_LOGIN, CORRECT_PASSWORD);
        String result = out.getCredentials(null, null);
        assertTrue(result.equals(NOT_CORRECT_MESSAGE), result);
    }

    @Test
    void shouldReturnDefaultMessageWhenEmailOrLoginIsEmpty() {
        User out = new User(CORRECT_LOGIN, CORRECT_PASSWORD);
        String result = out.getCredentials(EMPTY_LOGIN, EMPTY_PASSWORD);
        assertTrue(result.equals(NOT_CORRECT_MESSAGE), result);
    }

    @Test
    void shouldReturnCorrectLogin() {
        User out1 = new User(CORRECT_LOGIN);
        String result = out1.getLogin();
        assertTrue(result.equals(CORRECT_LOGIN));
    }

    @Test
    void shouldReturnExceptionMessageNotCorrectLogin() {
        Throwable exception = assertThrows(RuntimeException.class, () -> {
                    User out = new User(NOT_CORRECT_LOGIN);
                    out.getLogin();
                }
        );
        assertEquals(NOT_CORRECT_LOGIN_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldReturnExceptionMessagePasswordIsEqualLogin() {
        Throwable exception = assertThrows(RuntimeException.class, () -> {
                    User out = new User(CORRECT_LOGIN, PASSWORD_EQUALS_LOGIN);
                    out.getPassword();
                }
        );
        assertEquals(NOT_CORRECT_PASSWORD_MESSAGE, exception.getMessage());
    }
}
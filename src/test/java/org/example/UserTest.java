package org.example;

import org.junit.jupiter.api.Assertions;
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

    private final User out = new User();

    @Test
    void shouldReturnCorrectLogin() {
        String result = out.getLogin(CORRECT_LOGIN);
        Assertions.assertTrue(result.contains(CORRECT_LOGIN), result);
    }

    @Test
    void shouldReturnDefaultMessageNotCorrectLogin() {
        String result = out.getLogin(NOT_CORRECT_LOGIN);
        Assertions.assertTrue(result.contains(NOT_CORRECT_LOGIN_MESSAGE), result);
    }


    @Test
    void shouldReturnDefaultMessageWhenEmailAndPasswordIsNotEmpty() {
        String result = out.getCredentials("email", "pwd");
        Assertions.assertTrue(result.equals(CORRECT_CREDENTIALS), result);
    }

    @Test
    void shouldReturnDefaultMessageWhenEmailOeLoginIsNull() {
        String result = out.getCredentials(null, null);
        Assertions.assertTrue(result.equals(NOT_CORRECT_MESSAGE), result);
    }

    @Test
    void shouldReturnDefaultMessageWhenEmailOeLoginIsEmpty() {
        String result = out.getCredentials(EMPTY_LOGIN, EMPTY_PASSWORD);
        Assertions.assertTrue(result.equals(NOT_CORRECT_MESSAGE), result);
    }

    @Test
    void shouldReturnPasswordNotEqualsLogin() {
        String result = out.getPassword(CORRECT_PASSWORD, CORRECT_LOGIN);
        Assertions.assertTrue(result.equals(CORRECT_PASSWORD));
    }

    @Test
    void shouldReturnDefaultMessagePasswordAndLoginAreEquals() {
        String result = out.getPassword(PASSWORD_EQUALS_LOGIN, CORRECT_LOGIN);
        Assertions.assertTrue(result.equals(NOT_CORRECT_PASSWORD_MESSAGE));
    }
}
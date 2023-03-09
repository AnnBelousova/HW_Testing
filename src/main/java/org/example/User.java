package org.example;

public class User {
    private String login;
    private String password;


    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }

    public User(String login, String password) {
        if (password.equals(login)) {
            throw new RuntimeException("Password and Login must be different");
        } else {
            this.login = login;
        }
    }

    public User(String login) {
        if (!login.contains("@") || !login.contains(".")) {
            throw new RuntimeException("Login is not correct");
        } else {
            this.login = login;
        }
    }

    public String getCredentials(String login, String password) {
        if (login == null || password == null || login.isBlank() || password.isBlank()) {
            return "Mandatory fields!";
        }
        return "Credentials are correct!";
    }
}

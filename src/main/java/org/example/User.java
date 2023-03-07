package org.example;

public class User {
    String login;
    String password;

    public String getLogin(String login) {
        if (!login.contains("@") || !login.contains(".")) {
            return "Login is not correct";
        }
        return login;
    }

    public String getPassword(String password, String login) {
        if (password.equals(login)) {
            return "Password and Login must be different";
        }
        return password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public String getCredentials(String login, String password) {
        if (login == null || password == null || login.isBlank() || password.isBlank()) {
            return "Mandatory fields!";
        }
        return "Credentials are correct!";
    }
}

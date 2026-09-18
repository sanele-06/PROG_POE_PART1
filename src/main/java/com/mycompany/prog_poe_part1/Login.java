package com.mycompany.prog_poe_part1;

public class Login {
    private String myUsername;
    private String myPassword;
    private String myCellNumber;
    private String firstName;
    private String lastName;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*].*");
    }

    public boolean checkCellPhoneNumber(String cell) {
        return cell.matches("\\+27[0-9]{8,9}");
    }

    public String registerUser(String username, String password, String cell) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        if (!checkCellPhoneNumber(cell)) {
            return "Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }
        this.myUsername = username;
        this.myPassword = password;
        this.myCellNumber = cell;
        return "User registered successfully.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(myUsername) && password.equals(myPassword);
    }

    public String returnLoginStatus(boolean isLogged, String fName, String lName) {
        if (isLogged) {
            return "Welcome " + fName + " " + lName + ", it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // These fix your error!
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}
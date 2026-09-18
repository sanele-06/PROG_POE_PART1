package com.mycompany.prog_poe_part1;
import java.util.Scanner;

public class PROG_POE_PART1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== Registration ===");
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter Username (must have _ and <=5 chars): ");
        String username = sc.nextLine();
        System.out.print("Enter Password (8 chars, Capital, Number, Special): ");
        String password = sc.nextLine();
        System.out.print("Enter Cell Number (must start with +27): ");
        String cell = sc.nextLine();

        String regMessage = login.registerUser(username, password, cell);
        System.out.println(regMessage);

        // if registration failed, stop
        if (!regMessage.equals("User registered successfully.")) {
            System.out.println("Registration failed, please try again.");
            return;
        }

        System.out.println("\n=== Login ===");
        System.out.print("Enter Username to login: ");
        String loginUsername = sc.nextLine();
        System.out.print("Enter Password to login: ");
        String loginPassword = sc.nextLine();

        Boolean logged = login.loginUser(loginUsername, loginPassword);
        String loginMessage = login.returnLoginStatus(logged, firstName, lastName);
        System.out.println(loginMessage);
    }
}
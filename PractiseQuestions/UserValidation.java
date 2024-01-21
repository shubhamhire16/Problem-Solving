package PractiseQuestions;

import java.util.Scanner;



public class UserValidation {

    static String[][] users = {{"user1", "pass1"}, {"user2", "pass2"}};



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        System.out.print("Enter user id: ");

        String userId = scanner.nextLine();

        System.out.print("Enter password: ");

        String password = scanner.nextLine();

        System.out.print("Enter the number of digits for the token: ");

        int numDigits = scanner.nextInt();



        login(numDigits, userId, password);

    }



    static void login(int numDigits, String userId, String password) {

        if (isValidInput(userId, password, numDigits)) {

            if (isValidUser(userId, password)) {

                String token = generateToken(numDigits);

                System.out.println("Welcome " + userId + " and the generated token is: " + token);

            } else {

                System.out.println("UserId or password is not valid, please try again.");

            }

        } else {

            System.out.println("Invalid input. Please check the constraints.");

        }

    }



    static boolean isValidInput(String userId, String password, int numDigits) {

        // Check if userId is alphanumeric and not empty

        if (!userId.matches("^[a-zA-Z0-9]+$")) {

            return false;

        }



        // Check if password is alphanumeric and not empty

        if (!password.matches("^[a-zA-Z0-9]+$")) {

            return false;

        }



        // Check if numDigits is a positive whole number greater than 0

        return numDigits > 0;

    }



    static boolean isValidUser(String userId, String password) {

        for (String[] user : users) {

            if (user[0].equals(userId) && user[1].equals(password)) {

                return true;

            }

        }

        return false;

    }



    static String generateToken(int numDigits) {

        // Generate the first N-digit palindrome number

        int palindrome = generatePalindrome(numDigits);

        return "token-" + palindrome;

    }



    static int generatePalindrome(int numDigits) {

        int palindrome = 0;

        for (int i = 0; i < numDigits; i++) {

            int digit = (palindrome / (int) Math.pow(10, i)) % 10;

            palindrome += digit * Math.pow(10, numDigits + i);

        }

        return palindrome;

}

}
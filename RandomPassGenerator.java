package com.javaintern;
import java.util.Random;
import java.util.Scanner;

    public class RandomPassGenerator {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // taking user input for length of the password
            System.out.print("Enter the length of the password: ");
            int length = sc.nextInt();

           //checkig whether the password specify all characters
            System.out.print("Are numbers include ? (yes/no): ");
            boolean includeNumbers = sc.next().equalsIgnoreCase("yes");

            System.out.print("Are lowercase letters include? (yes/no): ");
            boolean includeLowercase = sc.next().equalsIgnoreCase("yes");

            System.out.print("Are uppercase letters include? (yes/no): ");
            boolean includeUppercase = sc.next().equalsIgnoreCase("yes");

            System.out.print("Are special characters includes? (yes/no): ");
            boolean includeSpecial = sc.next().equalsIgnoreCase("yes");

            // Generating the password
            String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecial);

            // Displaying the generated password
            System.out.println("Generated Password: " + password);

            sc.close();
        }

        private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase,
                                               boolean includeUppercase, boolean includeSpecial) {
            String numbers = "0123456789";
            String lowercase = "abcdefghijklmnopqrstuvwxyz";
            String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String special = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/~`";

            StringBuilder sb = new StringBuilder();

            if (includeNumbers) {
                sb.append(numbers);
            }
            if (includeLowercase) {
                sb.append(lowercase);
            }
            if (includeUppercase) {
                sb.append(uppercase);
            }
            if (includeSpecial) {
                sb.append(special);
            }

            if (sb.length() == 0) {
                throw new IllegalArgumentException("At least one character type must be included");
            }

            Random random = new Random();
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(sb.length());
                password.append(sb.charAt(index));
            }

            return password.toString();
        }
    }



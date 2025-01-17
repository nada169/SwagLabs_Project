// Specify UTF-8 encoding
//-*- coding: utf-8 -*-
package util;

import java.util.Random;

public class UtilityCodes {

    // Method to generate a random number between 1 and the specified max (inclusive)
    public static int generateRandomInt(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("Max must be greater than 0");
        }
        Random rand = new Random();
        return rand.nextInt(max) + 1; // Generate a random number between 1 and max (inclusive)
    }

    // Method to generate a random number between 0 and max-1 (exclusive)
    public static int generateRandomIndex(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("Max must be greater than 0");
        }
        Random rand = new Random();
        return rand.nextInt(max); // Generates a random number between 0 and max-1 (exclusive)
    }


    private static final String VOWELS = "aeiou";
    private static final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";

    public static String generateRandomFirstName() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Generate a random length between 3 and 8 characters
        int length = random.nextInt(6) + 3;

        // Start with a consonant
        sb.append(CONSONANTS.charAt(random.nextInt(CONSONANTS.length())));

        for (int i = 1; i < length; i++) {
            if (i % 2 == 0) { // Even index, likely a consonant
                sb.append(CONSONANTS.charAt(random.nextInt(CONSONANTS.length())));
            } else { // Odd index, likely a vowel
                sb.append(VOWELS.charAt(random.nextInt(VOWELS.length())));
            }
        }

        // Capitalize the first letter
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

        return sb.toString();
    }


    public static String generateRandomLasttName() {

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Generate a random length between 5 and 8 characters
        int length = random.nextInt(4) + 5;

        // Start with a consonant
        sb.append(CONSONANTS.charAt(random.nextInt(CONSONANTS.length())));

        for (int i = 1; i < length; i++) {
            if (i % 2 == 0) { // Even index, likely a consonant
                sb.append(CONSONANTS.charAt(random.nextInt(CONSONANTS.length())));
            } else { // Odd index, likely a vowel
                sb.append(VOWELS.charAt(random.nextInt(VOWELS.length())));
            }
        }

        // Capitalize the first letter
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

        return sb.toString();
    }


    public static String generateRandomPostalCode(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10)); // Generate a random digit (0-9)
        }

        return sb.toString();
    }

}








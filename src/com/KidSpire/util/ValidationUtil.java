/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kidspire.util;

import java.util.regex.Pattern;

/**
 *
 * @author kiransaud
 */
public class ValidationUtil {

    //Regular experssion patterns
    private static final Pattern ID_PATTERN = Pattern.compile("^\\d{5}$");//Pattern for Id
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\\\s]+$");//Pattern for name
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("^[a-zA-Z,]+$");//Pattern for address
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^98\\d{8}$");//Pattern for contact number
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    /**
     * Checks if a given string is null or empty after trimming white space.
     *
     * @param value the string to check
     * @return true if the string is null or empty (after trimming), false
     * otherwise
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Validates the babysitter ID based on predefined rules. A babysitter ID is
     * considered valid if it is not null or empty and matches the ID pattern.
     *
     * @param babysitterId the babysitter ID to validate
     * @return true if the babysitter ID is valid else false
     */

    public static boolean isValidBabysitterId(String babysitterId) {
        return !isNullOrEmpty(babysitterId) && ID_PATTERN.matcher(babysitterId).matches();
    }

    /**
     * Validate babysitter name based to name pattern
     *
     * @param name the name of babysitter to validate
     * @return true if the name of babysitter is valid else false
     */
    public static boolean isValidName(String name) {
        return !isNullOrEmpty(name) && NAME_PATTERN.matcher(name).matches();
    }

    /**
     * Validates the babysitter's experience. The experience is considered valid
     * if it is an integer between 1 and 20 (inclusive).
     *
     * @param experience the number of years of experience to validate
     * @return true if the experience is between 1 and 20 (inclusive), false
     * otherwise
     */

    public static boolean isValidExperience(int experience) {
        return experience >= 1 && experience <= 20;
    }

    /**
     * Validate babysitter address based on address pattern
     *
     * @param address the address of babysitter to validate
     * @return true if the address of babysitter is valid else false
     */

    public static boolean isValidAddress(String address) {
        return !isNullOrEmpty(address) && ADDRESS_PATTERN.matcher(address).matches();
    }

    /**
     * Validate babysitter contact based on address pattern
     *
     * @param contact the address of babysitter to validate
     * @return true if the contact of babysitter is valid else false
     */
    public static boolean isValidContact(String contact) {
        return !isNullOrEmpty(contact) && CONTACT_PATTERN.matcher(contact).matches();
    }

    /**
     * Validate babysitter email based on address pattern
     *
     * @param email the address of babysitter to validate
     * @return true if the email of babysitter is valid else false
     */

    public static boolean isVaildEmail(String email) {
        return !isNullOrEmpty(email) && EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates the babysitter's age. The age is considered valid if it falls
     * within the inclusive range of 21 to 45.
     *
     * @param age the age of the babysitter to validate
     * @return true if the age is between 21 and 45 (inclusive), false otherwise
     */

    public static boolean isValidAge(short age) {
        return age >= 21 && age <= 45;

    }

    /**
     * Utility to parse and validate an age value.
     *
     * @param ageText the text representing age
     * @return true if valid, otherwise false
     */
    public static boolean validateAgeInput(String ageText) {
        try {
            short age = Short.parseShort(ageText.trim());
            return isValidAge(age);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates the experience input provided as a string. The method attempts
     * to parse the input into an integer, trims any leading or trailing white
     * space, and then checks if it is a valid experience value using the
     * isValidExperience method. If the input is not a valid integer, the method
     * returns false.
     *
     * @param experienceTxt the experience input as a string
     * @return true if the input is a valid integer and represents a valid
     * experience, false otherwise
     */
    public static boolean validateExperienceInput(String experienceTxt) {
        try {
            int experience = Integer.parseInt(experienceTxt.trim());
            return isValidExperience(experience);

        } catch (NumberFormatException e) {
            return false;
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KidSpire.util;

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
     *
     * @param value
     * @return
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidBabysitterId(String babysitterId) {
        return !isNullOrEmpty(babysitterId) && ID_PATTERN.matcher(babysitterId).matches();
    }

    //check for name validation
    public static boolean isValidName(String name) {
        return !isNullOrEmpty(name) && NAME_PATTERN.matcher(name).matches();
    }

    public static boolean isValidExperience(int experience) {
        return experience >= 1 && experience<=20;
    }

    public static boolean isValidAddress(String address) {
        return !isNullOrEmpty(address) && ADDRESS_PATTERN.matcher(address).matches();
    }

    public static boolean isValidContact(String contact) {
        return !isNullOrEmpty(contact) && CONTACT_PATTERN.matcher(contact).matches();
    }

    public static boolean isVaildEmail(String email) {
        return !isNullOrEmpty(email) && EMAIL_PATTERN.matcher(email).matches();
    }

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
     *
     * @param experienceTxt
     * @return
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

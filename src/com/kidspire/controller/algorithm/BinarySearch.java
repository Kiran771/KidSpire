/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kidspire.controller.algorithm;

import com.kidspire.model.BabysitterModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Performs binary search on BabysitterModel objects by name or experience. Ensures data
 * is sorted before searching using Sorting class methods. Handles null/empty
 * data and returns matching results.
 *
 * @author kiransaud 23048603
 */
public class BinarySearch {

    private Sorting sortedForm;

    /**
     * Searches for babysitters by name or experience using binary search on a sorted list
     * Determines whether to search by name or experience based on the
     * the basis of method isInteger
     * @param searchValue The name to search for
     * @param searchData The list of babysitters to search through
     * @return A list of matching babysitters
     */
    public List<BabysitterModel> search(String searchValue, LinkedList<BabysitterModel> searchData) {
        if (searchData == null || searchData.isEmpty()) {
            return new ArrayList<>();
        }
        sortedForm = new Sorting();

        boolean isNumeric = isInteger(searchValue);
        if (isNumeric) {

            int searchId = Integer.parseInt(searchValue);
            List<BabysitterModel> sortedData = sortedForm.InsertionSortByExperience(searchData, true);

            searchData = new LinkedList<>(sortedData);

            List<BabysitterModel> matchFound = new ArrayList();

            int startIndex = 0;
            int endIndex = searchData.size() - 1;

            while (startIndex <= endIndex) {
                int midIndex = (startIndex + endIndex) / 2;

                if (searchId == searchData.get(midIndex).getExperience()) {
                    matchFound.add(searchData.get(midIndex));

                }
                if (searchId < searchData.get(midIndex).getExperience()) {
                    endIndex = midIndex - 1;

                } else {
                    startIndex = midIndex + 1;
                }

            }
            return matchFound;

        } else {

            List<BabysitterModel> sortedData = sortedForm.selectionSortByName(searchData, true);

            searchData = new LinkedList<>(sortedData);

            List<BabysitterModel> matchFound = new ArrayList<>();

            int startIndex = 0;
            int endIndex = searchData.size() - 1;

            while (startIndex <= endIndex) {
                int midIndex = (startIndex + endIndex) / 2;

                if (searchValue.compareToIgnoreCase(searchData.get(midIndex).getName()) == 0) {
                    matchFound.add(searchData.get(midIndex));
                }

                if (searchValue.compareToIgnoreCase(searchData.get(midIndex).getName()) < 0) {
                    endIndex = midIndex - 1;
                } else {
                    startIndex = midIndex + 1;
                }

            }
            return matchFound;
        }

    }

    /**
     *
     * Check if the given string is valid integer This method ensures that the
     * input string is not null or empty,
     *
     * @param searchValue The string to check
     * @return return true if if the string is a valid integer or false
     */
    public boolean isInteger(String searchValue) {
        if (searchValue == null || searchValue.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(searchValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

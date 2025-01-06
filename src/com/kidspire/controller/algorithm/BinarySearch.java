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
 * Performs binary search on BabysitterModel objects by name or ID. Ensures data
 * is sorted before searching using Sorting class methods. Handles null/empty
 * data and returns matching results.
 *
 * @author kiransaud 23048603
 */
public class BinarySearch {

    private Sorting sort;

    /**
     * Searches for babysitters by name using binary search on a sorted list
     *
     * @param searchValue The name to search for
     * @param searchData The list of babysitters to search through
     * @return A list of matching babysitters
     */
    public List<BabysitterModel> searchByName(String searchValue, LinkedList<BabysitterModel> searchData) {
        if (searchData == null || searchData.isEmpty()) {
            return new ArrayList<>();
        }
        sort = new Sorting();

        //Get sorted data as arrayList
        List<BabysitterModel> sortedData = sort.selectionSortByName(searchData, true);

        //convert the sorted arraylist to LinkedList
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

    /**
     * Searches for babysitters by id using binary search on a sorted list.
     *
     * @param searchValue The name to search for
     * @param searchData The list of babysitters to search through
     * @return A list of matching babysitters
     */
    public List<BabysitterModel> searchById(int searchValue, LinkedList<BabysitterModel> searchData) {
        if (searchData == null || searchData.isEmpty()) {
            return new ArrayList<>();
        }
        sort = new Sorting();

        List<BabysitterModel> sortedData = sort.mergeSortById(searchData, true);

        searchData = new LinkedList<>(sortedData);

        List<BabysitterModel> matchFound = new ArrayList();

        int startIndex = 0;
        int endIndex = searchData.size() - 1;

        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;

            if (searchValue == searchData.get(midIndex).getBabysitterId()) {
                matchFound.add(searchData.get(midIndex));

            }
            if (searchValue < searchData.get(midIndex).getBabysitterId()) {
                endIndex = midIndex - 1;

            } else {
                startIndex = midIndex + 1;
            }

        }
        return matchFound;

    }

}

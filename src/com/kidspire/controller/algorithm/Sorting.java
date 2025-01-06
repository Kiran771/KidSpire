/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kidspire.controller.algorithm;

import com.kidspire.model.BabysitterModel;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class provides sorting algorithms for sorting babysitter data based on
 * ID, name, and experience using techniques such as Insertion Sort, Selection
 * Sort, and Merge Sort. It supports both ascending and descending order and
 * includes validation for the input data before sorting. babysitter
 *
 * @author kiransaud 23048603
 */
public class Sorting {

    private ArrayList<BabysitterModel> dataToSort;

    /**
     * Sorts the babysitter data by experience using the insertion sort
     * algorithm in ascending or descending order
     *
     * @param unsortedData The LinkedList of BabysitterModel objects to be
     * sorted.
     * @param isAsc A Boolean flag indicating the sorting order; true for
     * ascending, false for descending.
     *
     */
    public List<BabysitterModel> InsertionSortByExperience(LinkedList<BabysitterModel> unsortedData, boolean isAsc) {

        List<BabysitterModel> dataToSort = new ArrayList<>();
        //convert linked list to arraylist
        dataToSort.addAll(unsortedData);

        for (int i = 1; i < dataToSort.size(); i++) {
            BabysitterModel currentValue = dataToSort.get(i);
            int sortedIndex = i - 1;
            while (sortedIndex >= 0) {
                boolean shouldSwap = false;
                if (isAsc) {

                    if (currentValue.getExperience() < dataToSort.get(sortedIndex).getExperience()) {
                        shouldSwap = true;
                    }
                } else {
                    if (currentValue.getExperience() > dataToSort.get(sortedIndex).getExperience()) {
                        shouldSwap = true;
                    }
                }

                //break the loop when no further swap is needed 
                if (!shouldSwap) {
                    break;
                }

                dataToSort.set(sortedIndex + 1, dataToSort.get(sortedIndex));
                sortedIndex--;

            }
            // Insert the current value in the correct position
            dataToSort.set(sortedIndex + 1, currentValue);
        }
        // Update the LinkedList with sorted elements
        unsortedData.clear();
        unsortedData.addAll(dataToSort);

        return dataToSort;

    }

    /**
     * Sorts the given LinkedList of BabysitterModel objects by name using
     * Selection Sort in ascending or descending order.
     *
     * @param unsortedData The LinkedList to be sorted.
     * @param isAsc True for ascending order, false for descending order.
     *
     */
    public List<BabysitterModel> selectionSortByName(LinkedList<BabysitterModel> unsortedData, boolean isAsc) {

        //convert linked list to arraylist
        List<BabysitterModel> dataToSort = new ArrayList<>();
        dataToSort.addAll(unsortedData);
        for (int i = 0; i < dataToSort.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < dataToSort.size(); j++) {

                if (isAsc) {
                    if (dataToSort.get(j).getName()
                            .compareToIgnoreCase(dataToSort.get(minIndex).getName()) < 0) {
                        minIndex = j;
                    }
                } else {
                    if (dataToSort.get(j).getName()
                            .compareToIgnoreCase(dataToSort.get(minIndex).getName()) > 0) {
                        minIndex = j;
                    }
                }

            }
            // Swapping elements
            if (minIndex != i) {
                BabysitterModel temp = dataToSort.get(i);
                dataToSort.set(i, dataToSort.get(minIndex));
                dataToSort.set(minIndex, temp);
            }

        }
        unsortedData.clear();
        unsortedData.addAll(dataToSort);

        return dataToSort;

    }

    public List<BabysitterModel> mergeSortById(LinkedList<BabysitterModel> unsortedData, boolean isAsc) {

        List<BabysitterModel> dataToSort = new ArrayList<>(unsortedData);
        List<BabysitterModel> sortedData = mergeSortRecursive(dataToSort, isAsc);

        unsortedData.clear();
        unsortedData.addAll(sortedData);

        return sortedData;
    }

    /**
     * Sorts a list using the recursive merge sort algorithm
     *
     * @param dataToSort The list to be sorted
     * @param isAsc Specifies whether the sorting should be in ascending (true)
     * or descending (false) order
     * @return The sorted list
     */
    public List<BabysitterModel> mergeSortRecursive(List<BabysitterModel> dataToSort, boolean isAsc) {

        if (dataToSort.size() <= 1) {
            return dataToSort;

        }

        int mid = dataToSort.size() / 2;

        //create new list leftPart and RightPart
        List<BabysitterModel> leftPart = new ArrayList<>(dataToSort.subList(0, mid));
        List<BabysitterModel> rightPart = new ArrayList<>(dataToSort.subList(mid, dataToSort.size()));

        //recurcively  sort the halves
        leftPart = mergeSortRecursive(leftPart, isAsc);
        rightPart = mergeSortRecursive(rightPart, isAsc);

        //merge the sorted halves 
        return merge(leftPart, rightPart, isAsc);

    }

    /**
     * Merges two sorted lists into a single sorted list using merge sort logic.
     *
     * @param leftPart The left half of the list
     * @param rightPart The right half of the list
     * @param isAsc Specifies whether the sorting should be in ascending i.e.
     * true or descending i.e. false
     * @return The merged and sorted list
     */
    private List<BabysitterModel> merge(List<BabysitterModel> leftPart, List<BabysitterModel> rightPart, boolean isAsc) {

        List<BabysitterModel> mergedResult = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftPart.size() && rightIndex < rightPart.size()) {
            if (isAsc) {
                if (leftPart.get(leftIndex).getBabysitterId() < rightPart.get(rightIndex).getBabysitterId()) {
                    mergedResult.add(leftPart.get(leftIndex));
                    leftIndex++;
                } else {
                    mergedResult.add(rightPart.get(rightIndex));
                    rightIndex++;
                }
            } else {
                if (leftPart.get(leftIndex).getBabysitterId() > rightPart.get(rightIndex).getBabysitterId()) {
                    mergedResult.add(leftPart.get(leftIndex));
                    leftIndex++;
                } else {
                    mergedResult.add(rightPart.get(rightIndex));
                    rightIndex++;
                }

            }

        }
        while (leftIndex < leftPart.size()) {
            mergedResult.add(leftPart.get(leftIndex));
            leftIndex++;
        }
        while (rightIndex < rightPart.size()) {
            mergedResult.add(rightPart.get(rightIndex));
            rightIndex++;
        }
        return mergedResult;
    }

}

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
 * Class is used to sort the data according to id , name and experience of the
 * babysitter 23048603
 *
 * @author kiransaud
 */
public class Sorting {

    private List<BabysitterModel> dataToSort;

    public Sorting() {
        dataToSort = new ArrayList<>();

    }

    /**
     *
     * @param unsortedData
     * @param parentFrame
     */
    public void InsertionSortByExperience(LinkedList<BabysitterModel> unsortedData, boolean isAsc, JFrame parentFrame) {
        if (!validateListForSorting(unsortedData, parentFrame)) {
            return;
        }

        //convert linked list to arraylist
        dataToSort = new ArrayList<>(unsortedData);

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

    }

    /**
     * Sorts the given LinkedList of BabysitterModel objects by name using
     * Selection Sort in ascending or descending order.
     *
     * @param unsortedData The LinkedList to be sorted.
     * @param isAsc True for ascending order, false for descending order.
     * @param parentFrame The parent frame for error messages if the list is
     * invalid.
     */
    public void selectionSortByName(LinkedList<BabysitterModel> unsortedData, boolean isAsc, JFrame parentFrame) {
        if (!validateListForSorting(unsortedData, parentFrame)) {
            return;
        }
        //convert linked list to arraylist
        dataToSort = new ArrayList<>(unsortedData);
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
        // Update the original LinkedList with sorted values
        unsortedData.clear();
        unsortedData.addAll(dataToSort);
    }

    /**
     * Validates if the list has more than one element for sorting. Displays an
     * error if the list is empty or contains only one item.
     *
     * @param unsortedData The list of BabysitterModel objects to be sorted.
     * @param parentFrame The parent frame for displaying messages.
     * @return true if the list is valid for sorting, false otherwise.
     */
    private boolean validateListForSorting(LinkedList<BabysitterModel> unsortedData, JFrame parentFrame) {
        if (unsortedData.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "No elements to sort.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (unsortedData.size() == 1) {
            JOptionPane.showMessageDialog(parentFrame, "Only one item in the list. Sorting is not necessary.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        System.out.println("List is valid for sorting.");
        return true;
    }
}

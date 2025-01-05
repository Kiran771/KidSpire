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

    private List<BabysitterModel> babysitterArrayList;

    public Sorting() {
        babysitterArrayList = new ArrayList<>();

    }

    /**
     *
     * @param babysitterList
     * @param selectedSortOption
     * @param parentFrame
     */
    public void InsertionSortByExperience(LinkedList<BabysitterModel> babysitterList, JFrame parentFrame) {
        if (!validateListForSorting(babysitterList, parentFrame)) {
            return;
        }

        //convert linked list to arraylist
        babysitterArrayList = new ArrayList<>(babysitterList);

        for (int i = 1; i < babysitterArrayList.size(); i++) {
            BabysitterModel currentValue = babysitterArrayList.get(i);
            int sortedIndex = i - 1;
            while (sortedIndex >= 0) {
                boolean shouldSwap = false;

                if (currentValue.getExperience() > babysitterArrayList.get(sortedIndex).getExperience()) {
                    shouldSwap = true;
                } else if (currentValue.getExperience() == babysitterArrayList.get(sortedIndex).getExperience()) {

                    shouldSwap = false;
                }

                //break the loop when no further swap is needed 
                if (!shouldSwap) {
                    break;
                }

                babysitterArrayList.set(sortedIndex + 1, babysitterArrayList.get(sortedIndex));
                sortedIndex--;

            }
            // Insert the current value in the correct position
            babysitterArrayList.set(sortedIndex + 1, currentValue);
        }
        // Update the LinkedList with sorted elements
        babysitterList.clear();
        babysitterList.addAll(babysitterArrayList);

    }

    public void selectionSortByName(LinkedList<BabysitterModel> babysitterList, JFrame parentFrame) {
        if (!validateListForSorting(babysitterList, parentFrame)) {
            return;
        }
        //convert linked list to arraylist
        babysitterArrayList = new ArrayList<>(babysitterList);
        for (int i = 0; i < babysitterArrayList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < babysitterArrayList.size(); j++) {
                if (babysitterArrayList.get(j).getName()
                        .compareToIgnoreCase(babysitterArrayList.get(minIndex).getName()) < 0) {
                    minIndex = j;
                }

            }
            // Swapping elements
            if (minIndex != i) {
                BabysitterModel temp = babysitterArrayList.get(i);
                babysitterArrayList.set(i, babysitterArrayList.get(minIndex));
                babysitterArrayList.set(minIndex, temp);
            }

        }
        // Update the original LinkedList with sorted values
        babysitterList.clear();
        babysitterList.addAll(babysitterArrayList);
    }

    /**
     * Validates if the list has more than one element for sorting. Displays an
     * error if the list is empty or contains only one item.
     * @param babysitterList The list of BabysitterModel objects to be sorted.
     * @param parentFrame The parent frame for displaying messages.
     * @return true if the list is valid for sorting, false otherwise.
     */
    private boolean validateListForSorting(LinkedList<BabysitterModel> babysitterList, JFrame parentFrame) {
        if (babysitterList.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "No elements to sort.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (babysitterList.size() == 1) {
            JOptionPane.showMessageDialog(parentFrame, "Only one item in the list. Sorting is not necessary.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
}

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
     * Sorts the provided list of babysitter objects based on the specified
     * criteria. Displays an error message if the list is empty or if an invalid
     * sorting criterion is provided.
     *The comparison return integer value i.e. +ve value when sorted value is greater than currentValue ,
     * -ve when sorted value is already in sorted position and 0 when both values are equal
     * @param babysitterList The list of BabysitterModel objects that need to be
     * sorted.
     * @param selectedSortOption The sorting criteria selected by the user.
     * Valid options include "ID", "Name", and "Experience".
     * @param parentFrame The parent frame used for displaying a message dialog
     * in case of errors.
     */
    public void InsertionSortBy(LinkedList<BabysitterModel> babysitterList, String selectedSortOption, JFrame parentFrame) {
        //Display a message if the list to be sorted is empty
        if (babysitterList.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "No elements to sort.", "Error", JOptionPane.ERROR_MESSAGE);
            return;

        }

        // Display a message if there is only one element
        if (babysitterList.size() == 1) {
            JOptionPane.showMessageDialog(parentFrame, "Only one item in the list. Sorting is not necessary.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //convert linked list to arraylist
        babysitterArrayList = new ArrayList<>(babysitterList);
        System.out.println("Before sorting: " + babysitterArrayList);

        for (int i = 1; i < babysitterArrayList.size(); i++) {
            BabysitterModel currentValue = babysitterArrayList.get(i);
            int sortedIndex = i - 1;
            while (sortedIndex >= 0) {
                boolean shouldSwap = false;
                if ("id".equalsIgnoreCase(selectedSortOption)) {
                    shouldSwap = currentValue.getBabysitterId() < babysitterArrayList.get(sortedIndex).getBabysitterId();
                    
                } else if ("Name".equalsIgnoreCase(selectedSortOption)) {
                    
                    int nameComparison = currentValue.getName()
                            .compareToIgnoreCase(babysitterArrayList.get(sortedIndex).getName());

                    if (nameComparison < 0) {
                        shouldSwap = true;
                    } else if (nameComparison == 0) {

                        shouldSwap = currentValue.getBabysitterId() < babysitterArrayList.get(sortedIndex).getBabysitterId();
                    }
                } else if ("Experience".equalsIgnoreCase(selectedSortOption)) {
                    if (currentValue.getExperience() > babysitterArrayList.get(sortedIndex).getExperience()) {
                        shouldSwap = true; 
                    } else if (currentValue.getExperience() == babysitterArrayList.get(sortedIndex).getExperience()) {
                        
                        shouldSwap = currentValue.getBabysitterId() < babysitterArrayList.get(sortedIndex).getBabysitterId();
                    }
                }
                //break the loop when no further swap is needed 
                if (!shouldSwap) {
                    break;
                }

                babysitterArrayList.set(sortedIndex + 1, babysitterArrayList.get(sortedIndex));
                sortedIndex--;

            }
            babysitterArrayList.set(sortedIndex + 1, currentValue);

        }
        // Update the LinkedList with sorted elements
        babysitterList.clear();
        babysitterList.addAll(babysitterArrayList);
        System.out.println("After sorting: " + babysitterArrayList);

    }
    
}

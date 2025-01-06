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

    private ArrayList<BabysitterModel> dataToSort;

    /**
     * Sorts the babysitter data by experience using the insertion sort
     * algorithm in ascending or descending order.
     *
     * @param unsortedData The LinkedList of BabysitterModel objects to be
     * sorted.
     * @param isAsc A Boolean flag indicating the sorting order; true for
     * ascending, false for descending.
     *
     */
    public List<BabysitterModel> InsertionSortByExperience(LinkedList<BabysitterModel> unsortedData, boolean isAsc) {
        
        List<BabysitterModel> dataToSort=new ArrayList<>();
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
        List <BabysitterModel>dataToSort = new ArrayList<>();
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

    public void mergeSortById(LinkedList<BabysitterModel> unsortedData, boolean isAsc) {

        dataToSort = new ArrayList<>(unsortedData);
        ArrayList<BabysitterModel> sortedData = mergeSortRecursive(dataToSort, isAsc);

        unsortedData.clear();
        unsortedData.addAll(sortedData);
    }

    public ArrayList<BabysitterModel> mergeSortRecursive(ArrayList<BabysitterModel> dataToSort, boolean isAsc) {

        if (dataToSort.size() <= 1) {
            return dataToSort;

        }

        int mid = dataToSort.size() / 2;

        //create new arraylist leftPart and RightPart
        ArrayList<BabysitterModel> leftPart = new ArrayList<>(dataToSort.subList(0, mid));
        ArrayList<BabysitterModel> rightPart = new ArrayList<>(dataToSort.subList(mid, dataToSort.size()));

        //recurcively  sort the halves
        leftPart = mergeSortRecursive(leftPart, isAsc);
        rightPart = mergeSortRecursive(rightPart, isAsc);

        //merge the sorted halves
        return merge(leftPart, rightPart, isAsc);

    }

    private ArrayList<BabysitterModel> merge(ArrayList<BabysitterModel> leftPart, ArrayList<BabysitterModel> rightPart, boolean isAsc) {
        ArrayList<BabysitterModel> mergedResult = new ArrayList<>();
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

        return true;
    }
}

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
 *
 * @author kiransaud 23048603
 */
public class BinarySearch {

    public List<BabysitterModel> SearchByName(String searchValue, LinkedList<BabysitterModel> searchData) {
        if (searchData == null || searchData.isEmpty()) {
            return new ArrayList<>();
        }
        Sorting sorting = new Sorting();
        //Get sorted data as arrayList
        List<BabysitterModel>sortedData=sorting.selectionSortByName(searchData, true);
       
        //convert the sorted arraylist to LinkedList
        searchData=new LinkedList<>(sortedData);
        
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

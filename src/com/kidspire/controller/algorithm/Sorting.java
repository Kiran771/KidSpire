/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kidspire.controller.algorithm;
import com.kidspire.model.BabysitterModel;
import java.util.List;
import java.util.ArrayList;

/**
 * Class is used to sort the data according to id , name and 
 *23048603
 * @author kiransaud
 */
public class Sorting {
    
    private List<BabysitterModel> babysitterId;
    
    public Sorting(){
       babysitterId=new ArrayList<>();
    }
    public void sortById(List<BabysitterModel> babysitterList){
        for(int i=0;i<babysitterList.size()-1;i++ ){
            int minIndex=i;
            for(int j=i+1;j<babysitterList.size();j++){
                if(babysitterList.get(j).getBabysitterId()<babysitterList.get(minIndex).getBabysitterId()){
                    minIndex=j;
                }
            
            }
            //swaping 
            if(minIndex!=i){
                BabysitterModel temp=babysitterList.get(i);
                
            }
            
        }
    }
    
}

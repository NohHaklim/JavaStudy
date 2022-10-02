package part3.java.util;

import java.util.*;

public class ListTest{
    public List<String> addArray(String[]arr1, String[]arr2){
        List<String> list = new ArrayList<String>();
        
        for(String str : arr1){
            System.out.println(str);     
        }
        
        for(String str : arr2){
            System.out.println(str);
        }
        
        for (int i = 0; i < arr1.length; i++) {
        	list.add(arr1[i]);
        }
        
        for (String str : arr2) {
        	list.add(str);
        }
        
        return list;
    }
    
    public static void main(String[] args){
    }
}
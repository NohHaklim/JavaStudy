package part3.java.util;

import java.util.*;

public class HashSetTest{
    public static void main(String[] args){
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("a");
        set.add("b");
        
        System.out.println("set의 내용을 출력합니다.");
        for(String str : set){
            System.out.println(str);
        }
    }
}
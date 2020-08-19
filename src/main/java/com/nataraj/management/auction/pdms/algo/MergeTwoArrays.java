package com.nataraj.management.auction.pdms.algo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MergeTwoArrays {

    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {

        // Write your code here
        List<Integer> resultList = new LinkedList<>();
        Integer[] aArray = a.toArray(new Integer[a.size()]);
        Integer[] bArray = b.toArray(new Integer[b.size()]);

        int aIndex = 0;
        int bIndex = 0;


        while(aIndex < aArray.length && bIndex < bArray.length){

            int move = compare(aArray[aIndex], bArray[bIndex]);
            if (move == 0){
                resultList.add(aArray[aIndex]);
                resultList.add(bArray[bIndex]);
                aIndex ++;
                bIndex++;
            }
            else if(move == -1){
                resultList.add(aArray[aIndex]);
                aIndex ++;
            }
            else{
                resultList.add(bArray[bIndex]);
                bIndex++;
            }
        }
        if(aIndex == aArray.length){
            copyFromArray(bArray,bIndex,resultList);
        }
        if(bIndex == bArray.length){
            copyFromArray(aArray,aIndex,resultList);
        }
        resultList.stream().forEach(System.out::println);
        return resultList;
    }

    public static void copyFromArray(Integer[] array, int start, List<Integer> resultList){
        for(int index = start; index < array.length; index++){
            resultList.add(array[index]);
        }
    }

    public static Integer compare(Integer a, Integer b){
        return a.compareTo(b);
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,4,5};
        Integer[] b = {0,3,4,5,9,11};
        mergeArrays(Arrays.asList(a), Arrays.asList(b));
    }

}



package com.testetokenservicejava.controller;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ArrayService {



    //exercise 1
    public  <T> T[] reverseArray(T[] inputArray) {
        // Create a new array with the same length as the input array
        T[] reversedArray = Arrays.copyOf(inputArray, inputArray.length);

        // Reverse the elements in the new array
        for (int i = 0, j = reversedArray.length - 1; i < j; i++, j--) {
            T temp = reversedArray[i];
            reversedArray[i] = reversedArray[j];
            reversedArray[j] = temp;
        }

        return reversedArray;
    }
    //exercise 2

    public  <T> void reverseArrayInPlace(T[] inputArray) {
        // Reverse the elements in the input array
        for (int i = 0, j = inputArray.length - 1; i < j; i++, j--) {
            T temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;
        }
    }
    //exercise 3

    public <T> void reverseListInPlaceList(List<T> inputList) {
        // Reverse the elements in the input list
        int i = 0;
        int j = inputList.size() - 1;

        while (i < j) {
            Collections.swap(inputList, i, j);
            i++;
            j--;
        }
    }
    //exercise 4

    public  String[] readCSVFields(BufferedReader reader) throws IOException {
        List<String> fieldValues = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(";");
            fieldValues.addAll(Arrays.asList(fields));
        }

        return fieldValues.toArray(new String[0]);
    }
}

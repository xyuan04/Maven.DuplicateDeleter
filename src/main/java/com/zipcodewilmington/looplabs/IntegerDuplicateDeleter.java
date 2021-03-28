package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    public Integer[] addItem(Integer[] intArray, int index, Integer integer){
        Integer[] newArray = new Integer[intArray.length + 1];

        for (int i = 0; i < newArray.length; i++) {
            if (i == index) {
                newArray[i]  = integer;
            } else if ( i < index) {
                newArray[i] = intArray[i];
            } else if (i > index) {
                newArray[i+1] = intArray[i];
            }
        }
        return newArray;
    }

    public Integer[] addToEnd(Integer[] intArray, Integer integer){
        return addItem(intArray, intArray.length, integer);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] newArray = new Integer[0];

        for(int i = 0; i < array.length; i++) {
            int counter = 0;
            for(int j = 0; j < array.length; j++) {
                if(array[i] == array[j]) {
                    counter++;
                }
            }
            if(counter < maxNumberOfDuplications) {
                newArray = addToEnd(newArray, array[i]);
            }
        }
        return newArray;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] newArray = new Integer[0];

        for(int i = 0; i < array.length; i++) {
            int counter = 0;
            for(int j = 0; j < array.length; j++) {
                if(array[i] == array[j]) {
                    counter++;
                }
            }
            if(counter != exactNumberOfDuplications) {
                newArray = addToEnd(newArray, array[i]);
            }
        }
        return newArray;
    }
}

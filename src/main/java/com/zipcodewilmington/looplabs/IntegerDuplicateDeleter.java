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

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Arrays.sort(array);
        int counter;

        if(maxNumberOfDuplications == 0) {
            return new Integer[0];
        }

        for(int i = 0; i < array.length; i++) {
            counter = 0;
            if(array[i] != null) {
                for (int j = 0; j < array.length; j++) {
                    Integer currentValue = array[i];
                    if (array[i] == array[j]) {
                        counter++;
                        if(counter == maxNumberOfDuplications) {
                            for(int k = 0; k < array.length; k++) {
                                if(array[k] == currentValue) {
                                    array[k] = null;
                                    counter = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        int newCounter = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == null) {
                newCounter++;
            }
        }

        Integer[] newArray = new Integer[array.length - newCounter];

        int newIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null) {
                newArray[newIndex] = array[i];
                newIndex++;
            }
        }
        return newArray;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        return new Integer[0];
    }
}

package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        Arrays.sort(array);
        int counter;

        if(maxNumberOfDuplications == 0) {
            return new String[0];
        }

        for(int i = 0; i < array.length; i++) {
            counter = 0;
            if(array[i] != null) {
                for (int j = 0; j < array.length; j++) {
                    String currentValue = array[i];
                    if (array[i] != null && array[i].equals(array[j])) {
                        counter++;
                        if (counter == maxNumberOfDuplications) {
                            for (int k = 0; k < array.length; k++) {
                                if (array[k] != null && array[k].equals(currentValue)) {
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

        String[] newArray = new String[array.length - newCounter];

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
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        return new String[0];
    }
}

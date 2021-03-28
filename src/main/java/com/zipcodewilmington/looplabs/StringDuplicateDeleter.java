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

    public String[] addItem(String[] stringArray, int index, String string){
        String[] newArray = new String[stringArray.length + 1];

        for(int i = 0; i < newArray.length; i++) {
            if(i == index) {
                newArray[i]  = string;
            } else if( i < index) {
                newArray[i] = stringArray[i];
            } else if(i > index) {
                newArray[i+1] = stringArray[i];
            }
        }
        return newArray;
    }

    public String[] addToEnd(String[] array, String item){
        return addItem(array, array.length, item);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] newArray = new String[0];

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
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] newArray = new String[0];

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

package com.company;

import java.util.Random;

public class BigONotation {

    public void constantTime(){
        //O(1)
        int i = 0;

        while (i < 11){
            i += 1;
            System.out.println(i);
        }
    }

    public void linearTime() {
        //O(n)
        int[] intArray = new int[]{4,5,6,7,8,9,5,4};

        for (int value: intArray) {
            System.out.println(value* 3);
        }
    }

    public void quadraticTime() {
        int[] intArray = new int[]{4,5,6,7,8,9,5,4};

        for (int i = 0; i < intArray.length; i++) {
            for(int j = i + 1; j < intArray.length; j++) {
                int sum = intArray[i] + intArray[j];
                System.out.println(sum);

            }

        }


    }

    public static void main(String[] args) {
        BigONotation bigONotation = new BigONotation();
//        bigONotation.constantTime();
//        bigONotation.linearTime();
        bigONotation.quadraticTime();
    }
}

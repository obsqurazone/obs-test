package com.obsqura.utilities;

import java.util.Random;

public class GenericUtil {

    public static int getRandomNumberForDatePicker(){
        Random randomGenerator = new Random();
        int low = 10;
        int high = 29;
        int randomInt = randomGenerator.nextInt(high-low)+ low;
        return randomInt;
    }


}

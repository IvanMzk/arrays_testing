package arrays.utils;

/**
 * Created by ivann on 06.04.15.
 */

import java.util.Arrays;
import java.util.Comparator;

public class ArrayUnion {

    /**
     *
     * @param lArray array
     * @param rArray array
     * @return array that is result of merging without duplicates of lArray and rArray
     */


    public static PojoNumber[] arraysMerge(PojoNumber[] lArray, PojoNumber[] rArray){

        int lLenght = lArray.length;
        int rLenght = rArray.length;
        int rIndex = lLenght;
        Comparator<PojoNumber> numberComparator = new NumberComparator();
        PojoNumber[] resultArray = null;
        PojoNumber[] tmpArray = Arrays.copyOf(lArray, lLenght+rLenght);
        PojoNumber[] lArraySorted =  Arrays.copyOf(lArray, lLenght);


        Arrays.sort(lArraySorted,numberComparator);

        for (PojoNumber rItem : rArray)
        {
            if (Arrays.binarySearch(lArraySorted, rItem, numberComparator) < 0){
                tmpArray[rIndex] = rItem;
                rIndex++;
            }
        }

        resultArray = new PojoNumber[rIndex];
        for (int i = 0; i<rIndex; i++)
        {
            resultArray[i] = tmpArray[i];
        }

        return resultArray;
    }


}

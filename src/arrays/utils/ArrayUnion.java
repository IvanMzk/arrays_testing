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

    /**
     *
     * @param lArray array
     * @param rArray array
     * @return array that is result of union of elements that present in both lArray and rArray arrays
     */


    public static PojoNumber[] arraysInnerUnion(PojoNumber[] lArray, PojoNumber[] rArray){

        int lLenght = lArray.length;
        int rLenght = rArray.length;
        int index = 0;
        Comparator<PojoNumber> numberComparator = new NumberComparator();
        PojoNumber[] resultArray = null;
        PojoNumber[] tmpArray = new PojoNumber[(lLenght > rLenght)?rLenght:lLenght];
        PojoNumber[] lArraySorted =  Arrays.copyOf(lArray, lLenght);
        PojoNumber[] rArraySorted =  Arrays.copyOf(rArray, rLenght);

        Arrays.sort(lArraySorted,numberComparator);
        Arrays.sort(rArraySorted,numberComparator);

        for (PojoNumber rItem : rArray)
        {
            if (Arrays.binarySearch(lArraySorted, rItem, numberComparator) >= 0){
                tmpArray[index] = rItem;
                index++;
            }
        }

        resultArray = new PojoNumber[index];
        for (int i = 0; i<index; i++)
        {
            resultArray[i] = tmpArray[i];
        }

        return resultArray;



    }



    public static boolean testResult(PojoNumber[] result, PojoNumber[] etalon)
    {
        return Arrays.equals(result, etalon);

    }


}

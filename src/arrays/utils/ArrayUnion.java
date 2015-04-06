package arrays.utils;

/**
 * Created by ivann on 06.04.15.
 */

import java.util.Arrays;
import java.util.Comparator;

//local code review (vtegza): make method non static @ 06.04.15
public class ArrayUnion {

    /**
     *
     * @param lArray array
     * @param rArray array
     * @return array that is result of merging without duplicates of lArray and rArray
     */


    public static PojoNumber[] arraysMerge(PojoNumber[] lArray, PojoNumber[] rArray){

        final int lLenght = lArray.length;
        final int rLenght = rArray.length;
        int rIndex = lLenght;
        Comparator<PojoNumber> numberComparator = new NumberComparator();
        //local code review (vtegza): move variables to the place where they should be used @ 06.04.15
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

        resultArray = Arrays.copyOfRange(tmpArray, 0, rIndex);

        Arrays.sort(resultArray, numberComparator);
        return deleteDublicates(resultArray);
        //return resultArray;
    }

    /**
     *
     * @param lArray array
     * @param rArray array
     * @return array that is result of union of elements that present in both lArray and rArray arrays
     */


    public static PojoNumber[] arraysInnerUnion(PojoNumber[] lArray, PojoNumber[] rArray){

        final int lLenght = lArray.length;
        final int rLenght = rArray.length;
        int index = 0;
        Comparator<PojoNumber> numberComparator = new NumberComparator();
        //local code review (vtegza): move variables to the place where they should be used @ 06.04.15
        PojoNumber[] resultArray = null;
        PojoNumber[] tmpArray = new PojoNumber[(lLenght > rLenght)?rLenght:lLenght];
        PojoNumber[] lArraySorted =  Arrays.copyOf(lArray, lLenght);

        Arrays.sort(lArraySorted,numberComparator);

        for (PojoNumber rItem : rArray)
        {
            if (Arrays.binarySearch(lArraySorted, rItem, numberComparator) >= 0){
                tmpArray[index] = rItem;
                index++;
            }
        }

        resultArray = Arrays.copyOfRange(tmpArray, 0, index);

        Arrays.sort(resultArray, numberComparator);
        return deleteDublicates(resultArray);
        //return resultArray;

    }


    /**
     *
     * @param lArray array
     * @param rArray array
     * @return array that is result of union of elements that not present in both lArray and rArray arrays
     */


    public static PojoNumber[] arraysOuterUnion(PojoNumber[] lArray, PojoNumber[] rArray){

        final int lLenght = lArray.length;
        final int rLenght = rArray.length;
        int index = 0;
        Comparator<PojoNumber> numberComparator = new NumberComparator();
        //local code review (vtegza): move variables to the place where they should be used @ 06.04.15
        PojoNumber[] resultArray = null;
        PojoNumber[] tmpArray = new PojoNumber[rLenght+lLenght];
        PojoNumber[] lArraySorted =  Arrays.copyOf(lArray, lLenght);
        PojoNumber[] rArraySorted =  Arrays.copyOf(rArray, rLenght);


        Arrays.sort(lArraySorted,numberComparator);
        Arrays.sort(rArraySorted,numberComparator);

        for (PojoNumber rItem : rArray)
        {
            if (Arrays.binarySearch(lArraySorted, rItem, numberComparator) < 0){
                tmpArray[index] = rItem;
                index++;
            }
        }

        for (PojoNumber lItem : lArray)
        {
            if (Arrays.binarySearch(rArraySorted, lItem, numberComparator) < 0){
                tmpArray[index] = lItem;
                index++;
            }
        }

        resultArray = Arrays.copyOfRange(tmpArray, 0, index);

        Arrays.sort(resultArray, numberComparator);
        return deleteDublicates(resultArray);
        //return resultArray;

    }


    /**
     *
     * @param array should be sorted
     * @return input array without dublicates
     */


    public static PojoNumber[] deleteDublicates(PojoNumber[] array)
    {
        final int length = array.length;

        if (length >= 2)
        {
            int tmpIndex = 0;
            boolean isEqualsSequence = false;
            PojoNumber[] tmpArray = new PojoNumber[length];
            PojoNumber[] resultArray;

            for (int i = 0; i < length-1; i++) {
                if (array[i].equals(array[i+1]))
                {
                    if (!isEqualsSequence)
                    {
                        tmpArray[tmpIndex] = array[i];
                        tmpIndex++;
                        isEqualsSequence = true;
                    }
                }
                else
                {
                    if (isEqualsSequence) {
                        isEqualsSequence = false;
                        if (length-2 == i)
                        {
                            tmpArray[tmpIndex] = array[length-1];
                            tmpIndex++;
                        }
                    }
                    else {
                        tmpArray[tmpIndex] = array[i];
                        tmpIndex++;
                        if (length-2 == i)
                        {
                            tmpArray[tmpIndex] = array[length-1];
                            tmpIndex++;
                        }
                    }
                }
            }

            resultArray = new PojoNumber[tmpIndex];
            //local code review (vtegza): use array copy here @ 06.04.15
            for (int i = 0; i<tmpIndex; i++)
            {
                resultArray[i] = tmpArray[i];
            }

            return resultArray;
        }
        else {return array;}
    }


    public static boolean testResult(PojoNumber[] result, PojoNumber[] etalon)
    {
        PojoNumber[] resultSorted = Arrays.copyOf(result, result.length);
        PojoNumber[] etalonSorted = Arrays.copyOf(etalon, etalon.length);
        Comparator<PojoNumber> numberComparator = new NumberComparator();

        Arrays.sort(resultSorted, numberComparator);
        Arrays.sort(etalonSorted, numberComparator);

        return Arrays.equals(resultSorted, etalonSorted);
    }


}

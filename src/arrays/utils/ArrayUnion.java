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
     *
     */

    private static final String NULL_ARRAY_REF_ECODE_EXCEPTION = "Wrong parameter";
    private static final String NULL_ARRAY_LREF_MES_EXCEPTION = "Input param lArray reference is null";
    private static final String NULL_ARRAY_RREF_MES_EXCEPTION = "Input param rArray reference is null";
    private static final String NULL_ARRAY_REF_MES_EXCEPTION = "Input params lArray and rArray references are nulls";

    //local code review (vtegza): use automatic formatter @ 21.04.15
    public PojoNumber[] arraysMerge(PojoNumber[] lArray, PojoNumber[] rArray) throws NullArrayRefException
    {

        if (null == lArray && null == rArray)
        {throw new NullArrayRefException(NULL_ARRAY_REF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == lArray)
        {throw new NullArrayRefException(NULL_ARRAY_LREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == rArray)
        {throw new NullArrayRefException(NULL_ARRAY_RREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}


        final int lLenght = lArray.length;
        final int rLenght = rArray.length;

        int rIndex = lLenght;
        PojoNumber[] tmpArray = Arrays.copyOf(lArray, lLenght+rLenght);
        PojoNumber[] lArraySorted =  Arrays.copyOf(lArray, lLenght);
        Comparator<PojoNumber> numberComparator = new NumberComparator();
        Arrays.sort(lArraySorted,numberComparator);

        for (PojoNumber rItem : rArray)
        {
            if (Arrays.binarySearch(lArraySorted, rItem, numberComparator) < 0){
                tmpArray[rIndex] = rItem;
                rIndex++;
            }
        }

        PojoNumber[] resultArray = null;
        resultArray = Arrays.copyOfRange(tmpArray, 0, rIndex);

        Arrays.sort(resultArray, numberComparator);
        return deleteDublicates(resultArray);
    }

    /**
     *
     * @param lArray array
     * @param rArray array
     * @return array that is result of union of elements that present in both lArray and rArray arrays
     */


    public PojoNumber[] arraysInnerUnion(PojoNumber[] lArray, PojoNumber[] rArray) throws NullArrayRefException
    {
        if (null == lArray && null == rArray)
        {throw new NullArrayRefException(NULL_ARRAY_REF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == lArray)
        {throw new NullArrayRefException(NULL_ARRAY_LREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == rArray)
        {throw new NullArrayRefException(NULL_ARRAY_RREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}

        final int lLenght = lArray.length;
        final int rLenght = rArray.length;

        int index = 0;
        PojoNumber[] tmpArray = new PojoNumber[(lLenght > rLenght)?rLenght:lLenght];
        PojoNumber[] lArraySorted =  Arrays.copyOf(lArray, lLenght);
        Comparator<PojoNumber> numberComparator = new NumberComparator();
        Arrays.sort(lArraySorted,numberComparator);

        for (PojoNumber rItem : rArray)
        {
            if (Arrays.binarySearch(lArraySorted, rItem, numberComparator) >= 0){
                tmpArray[index] = rItem;
                index++;
            }
        }

        PojoNumber[] resultArray = null;
        resultArray = Arrays.copyOfRange(tmpArray, 0, index);

        Arrays.sort(resultArray, numberComparator);
        return deleteDublicates(resultArray);

    }


    /**
     *
     * @param lArray array
     * @param rArray array
     * @return array that is result of union of elements that not present in both lArray and rArray arrays
     */


    public PojoNumber[] arraysOuterUnion(PojoNumber[] lArray, PojoNumber[] rArray) throws NullArrayRefException
    {
        if (null == lArray && null == rArray)
        {throw new NullArrayRefException(NULL_ARRAY_REF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == lArray)
        {throw new NullArrayRefException(NULL_ARRAY_LREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}
        if (null == rArray)
        {throw new NullArrayRefException(NULL_ARRAY_RREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}

        final int lLenght = lArray.length;
        final int rLenght = rArray.length;

        int index = 0;
        PojoNumber[] tmpArray = new PojoNumber[rLenght+lLenght];
        PojoNumber[] lArraySorted =  Arrays.copyOf(lArray, lLenght);
        PojoNumber[] rArraySorted =  Arrays.copyOf(rArray, rLenght);
        Comparator<PojoNumber> numberComparator = new NumberComparator();

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

        PojoNumber[] resultArray = null;
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


    public PojoNumber[] deleteDublicates(PojoNumber[] array) throws NullArrayRefException
    {

        if (null == array)
        {throw new NullArrayRefException(NULL_ARRAY_LREF_MES_EXCEPTION,NULL_ARRAY_REF_ECODE_EXCEPTION);}

        final int length = array.length;

        if (length >= 2)
        {
            int tmpIndex = 0;
            boolean isEqualsSequence = false;
            PojoNumber[] tmpArray = new PojoNumber[length];

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


            PojoNumber[] resultArray = null;
            resultArray = Arrays.copyOfRange(tmpArray, 0, tmpIndex);

            return resultArray;
        }
        else {return array;}
    }



}

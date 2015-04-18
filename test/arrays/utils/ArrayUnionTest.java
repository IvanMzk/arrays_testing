package arrays.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Comparator;

public class ArrayUnionTest {

    protected PojoNumber[] GetTestArray(int[] array){

        if (null != array) {
            int i = 0;
            PojoNumber[] resultArray = new PojoNumber[array.length];
            for (int item : array) {
                resultArray[i] = new PojoNumber(item);
                i++;
            }
            return resultArray;
        }
        else
            return null;

    }

     boolean CompareTestArrays(PojoNumber[] test, PojoNumber[] etalon){

        Comparator<PojoNumber> comparator = new NumberComparator();
        Arrays.sort(test, comparator);
        Arrays.sort(etalon, comparator);

        return Arrays.equals(test, etalon);

    }

//=============Normal input data testing===========================

    @Test
    public void testArraysMerge() throws Exception {

        //init input variables
        //int[] lArray = {1, 5, 4, 23, 65, 32, 78};
        //int[] rArray = {3, 5, 24, 54, 1, 2, 34, 45, 32};
        PojoNumber[] lArray = GetTestArray(new int[] {1, 5, 4, 23, 65, 32, 78});
        PojoNumber[] rArray = GetTestArray(new int[] {3, 5, 24, 54, 1, 2, 34, 45, 32, 24});


        //init expected value
        // int[] expectedValue = {1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45};
        PojoNumber[] expectedValue = GetTestArray(new int[] {1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45});


        //init class to test
        ArrayUnion testClass = new ArrayUnion();


        //ivoke method on class to test
        PojoNumber[] returnedValue = testClass.arraysMerge(lArray, rArray);


        //assert returned value
        Assert.assertTrue(CompareTestArrays(returnedValue, expectedValue));

    }

    @Test
    public void testArraysInnerUnion() throws Exception {

        //init input variables
        //int[] lArray = {1,5,4,23,65,32,78};
        //int[] rArray = {3,5,24,4,1,2,34,45,32,5};
        PojoNumber[] lArray = GetTestArray(new int[] {1,5,4,23,65,32,78,1});
        PojoNumber[] rArray = GetTestArray(new int[] {3,5,24,4,1,2,34,45,32,5,32});


        //init expected value
        // int[] expectedValue = {5,4,32,1};
        PojoNumber[] expectedValue = GetTestArray(new int[] {5,4,32,1});


        //init class to test
        ArrayUnion testClass = new ArrayUnion();


        //ivoke method on class to test
        PojoNumber[] returnedValue = testClass.arraysInnerUnion(lArray, rArray);


        //assert returned value
        Assert.assertTrue(CompareTestArrays(returnedValue, expectedValue));

    }

    @Test
    public void testArraysOuterUnion() throws Exception {

        //init input variables
        //int[] lArray = {1,5,4,23,65,32,78};
        //int[] rArray = {3,5,24,4,1,2,34,45,32,5};
        PojoNumber[] lArray = GetTestArray(new int[] {1,5,4,23,65,32,78});
        PojoNumber[] rArray = GetTestArray(new int[] {3,5,24,4,1,2,34,45,32,5});


        //init expected value
        // int[] expectedValue = {23,65,78,3,24,2,34,45};
        PojoNumber[] expectedValue = GetTestArray(new int[] {23,65,78,3,24,2,34,45});


        //init class to test
        ArrayUnion testClass = new ArrayUnion();


        //ivoke method on class to test
        PojoNumber[] returnedValue = testClass.arraysOuterUnion(lArray, rArray);


        //assert returned value
        Assert.assertTrue(CompareTestArrays(returnedValue, expectedValue));

    }

    @Test
    public void testDeleteDublicates() throws Exception {

        //init input variables
        //int[] array = {1, 1, 5, 4, 23, 65, 23, 23, 23, 1, 32, 78, 32, 78, 78};
        PojoNumber[] array = GetTestArray(new int[] {1, 1, 5, 4, 23, 65, 23, 23, 23, 1, 32, 78, 32, 78, 78});
        Comparator<PojoNumber> comparator = new NumberComparator();
        Arrays.sort(array, comparator);



        //init expected value
        // int[] expectedValue = {1, 5, 4, 23, 65, 32, 78};
        PojoNumber[] expectedValue = GetTestArray(new int[] {1, 5, 4, 23, 65, 32, 78});

        //init class to test
        ArrayUnion testClass = new ArrayUnion();


        //ivoke method on class to test
        PojoNumber[] returnedValue = testClass.deleteDublicates(array);


        //assert returned value
        Assert.assertTrue(CompareTestArrays(returnedValue, expectedValue));

    }


    //abnormal input data testing





}
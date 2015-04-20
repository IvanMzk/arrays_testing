package arrays.utils;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
import static org.junit.Assert.*;

public class ArrayUnionTest {


    private PojoNumber[] populateTestArray(int[] array){
        PojoNumber[] testArray = new PojoNumber[array.length];
        int i = 0;
        for (int item : array){
            testArray[i] = new PojoNumber(item);
            i++;
        }
        return testArray;
    }

    private boolean testResult(PojoNumber[] result, PojoNumber[] etalon)
    {
        PojoNumber[] resultSorted = Arrays.copyOf(result, result.length);
        PojoNumber[] etalonSorted = Arrays.copyOf(etalon, etalon.length);
        Comparator<PojoNumber> numberComparator = new NumberComparator();

        Arrays.sort(resultSorted, numberComparator);
        Arrays.sort(etalonSorted, numberComparator);

        return Arrays.equals(resultSorted, etalonSorted);
    }




    @Test
    public void testArraysMerge() throws Exception {

        //Init variable input
        //int[] lArray = {1, 5, 4, 23, 65, 32, 78};
        //int[] rArray = {3, 5, 24, 54, 1, 2, 34, 45, 32};
        PojoNumber[] lArray = populateTestArray(new int[] {1, 5, 4, 23, 65, 32, 78});
        PojoNumber[] rArray = populateTestArray(new int[] {3, 5, 24, 24, 54, 1, 2, 34, 45, 32, 32, 2});


        //Init expected results
        //int[]  expectedArray = {1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45};
        PojoNumber[] expectedValue = populateTestArray(new int[] {1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45});


        //Init class to test
        ArrayUnion testClass = new ArrayUnion();

        //Invoke method on class to test
        PojoNumber[] returnedValue = testClass.arraysMerge(lArray, rArray);


        //Assert returned values
        Assert.assertTrue(testResult(returnedValue, expectedValue));




    }

    @Test
    public void testArraysInnerUnion() throws Exception {

        //Init variable input
        //int[] lArray = {1,5,4,23,65,32,78};
        //int[] rArray = {3,5,24,4,1,2,34,45,32,5};
        PojoNumber[] lArray = populateTestArray(new int[] {1,5,4,23,65,32,78,32,5,4});
        PojoNumber[] rArray = populateTestArray(new int[] {3,5,24,4,1,2,34,45,32,5,5,32});


        //Init expected results
        //int[] expectedArray = {5,4,32,1};
        PojoNumber[] expectedValue = populateTestArray(new int[] {5,4,32,1});


        //Init class to test
        ArrayUnion testClass = new ArrayUnion();

        //Invoke method on class to test
        PojoNumber[] returnedValue = testClass.arraysInnerUnion(lArray, rArray);


        //Assert returned values
        Assert.assertTrue(testResult(returnedValue, expectedValue));

    }

    @Test
    public void testArraysOuterUnion() throws Exception {

        //Init variable input
        //int[] lArray = {1,5,4,23,65,32,78};
        //int[] rArray = {3,5,24,4,1,2,34,45,32,5};
        PojoNumber[] lArray = populateTestArray(new int[] {1,5,4,23,65,32,78});
        PojoNumber[] rArray = populateTestArray(new int[] {3,5,24,4,1,2,34,45,32,5});

        //Init expected results
        //int[] expectedArray = {23,65,78,3,24,2,34,45};
        PojoNumber[] expectedValue = populateTestArray(new int[] {23,65,78,3,24,2,34,45});


        //Init class to test
        ArrayUnion testClass = new ArrayUnion();

        //Invoke method on class to test
        PojoNumber[] returnedValue = testClass.arraysOuterUnion(lArray, rArray);


        //Assert returned values
        Assert.assertTrue(testResult(returnedValue, expectedValue));

    }

    @Test
    public void testDeleteDublicates() throws Exception {

    }




}
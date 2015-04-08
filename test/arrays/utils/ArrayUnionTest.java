package arrays.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;


public class ArrayUnionTest {

    @Test
    public void testArraysMerge() throws Exception {
        //init variable input
        int[] leftArray = {1,2,3};
        int[] rightArray = {1,2,3};

        //int[] expectedValue = {1,2,3};
        String expectedValue = "Wrong Values";


        //init class to test
        ArrayHelperToTest testClass = new ArrayHelperToTest();


        //invoke method on class to test
        try {
            int[] returnedValue = testClass.leftUnion(leftArray, rightArray);
            fail("exception should be thrown");
        }
        catch (MyEception exception)
        {
            Assert.assertEquals(expectedValue, exception.getErrorCode());
        }


        //assert ret val

        //Assert.assertArrayEquals(expectedValue, returnedValue);



    }

    @org.junit.Test
    public void testArraysMerge1() throws Exception {

    }

    @org.junit.Test
    public void testArraysInnerUnion() throws Exception {

    }

    @org.junit.Test
    public void testArraysOuterUnion() throws Exception {

    }

    @org.junit.Test
    public void testDeleteDublicates() throws Exception {

    }

    @org.junit.Test
    public void testTestResult() throws Exception {

    }
}
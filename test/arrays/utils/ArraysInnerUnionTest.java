package arrays.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ArraysInnerUnionTest extends ArrayUnionTest {

    private int[] lArray;
    private int[] rArray;
    private int[] expectedValue;
    private String expectedErrorCode;


    public ArraysInnerUnionTest(int[] lArray, int[] rArray, int[] expectedValue, String expectedErrorCode) {
        this.lArray = lArray;
        this.rArray = rArray;
        this.expectedValue = expectedValue;
        this.expectedErrorCode = expectedErrorCode;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data(){

        Object[][] data = new Object[][]{
                {new int[]{1,5,4,23,65,32,78,1}, new int[]{3,5,24,4,1,2,34,45,32,5,32}, new int[]{5,4,32,1}, null},
                {new int[]{}, new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24}, new int[]{}, null},
                {new int[]{1, 5, 4, 23, 65, 32, 78}, new int[]{}, new int[]{}, null},
                {null, new int[]{3, 5, 24, 54, 1, 2, 34, 45, 32, 24}, null, "Wrong parameter"},
                {new int[]{1, 5, 4, 23, 65, 32, 78}, null,  null, "Wrong parameter"}
        };

        return Arrays.asList(data);
    }



    @Test
    public void testArraysInnerUnion() throws Exception {


        //init input variables
        PojoNumber[] lArray = GetTestArray(this.lArray);
        PojoNumber[] rArray = GetTestArray(this.rArray);

        //init class to test
        ArrayUnion testClass = new ArrayUnion();

        if (null != lArray && null != rArray) {
            //init expected value
            PojoNumber[] expectedValue = GetTestArray(this.expectedValue);

            //ivoke method on class to test
            PojoNumber[] returnedValue = testClass.arraysInnerUnion(lArray, rArray);

            //assert returned value
            Assert.assertTrue(CompareTestArrays(returnedValue, expectedValue));
        }
        else
        {
            String expectedValue = this.expectedErrorCode;
            try{
                PojoNumber[] returnedValue = testClass.arraysInnerUnion(lArray, rArray);
                fail("Exception should be thrown");
            }
            catch(NullArrayRefException e){
                Assert.assertEquals(e.getErrorCode(), expectedValue);
            }

        }

    }
}
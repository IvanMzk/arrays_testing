package arrays.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class deleteDublicatesTest extends ArrayUnionTest {

    private int[] lArray;
    private int[] expectedValue;
    private String expectedErrorCode;

    public deleteDublicatesTest(int[] lArray, int[] expectedValue, String expectedErrorCode) {
        this.lArray = lArray;
        this.expectedValue = expectedValue;
        this.expectedErrorCode = expectedErrorCode;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data(){

        Object[][] data = new Object[][]{
                {new int[]{1, 1, 5, 4, 23, 65, 23, 23, 23, 1, 32, 78, 32, 78, 78},  new int[]{1, 5, 4, 23, 65, 32, 78}, null},
                {new int[]{1},  new int[]{1}, null},
                {new int[]{3,0},  new int[]{0,3}, null},
                {new int[]{},  new int[]{}, null},
                {null,  null, "Wrong parameter"}
        };

        return Arrays.asList(data);
    }



    @Test
    public void testDeleteDublicates() throws Exception {

        //init input variables
        PojoNumber[] lArray = GetTestArray(this.lArray);
        
        //init class to test
        ArrayUnion testClass = new ArrayUnion();

        if (null != lArray) {
            //init expected value
            PojoNumber[] expectedValue = GetTestArray(this.expectedValue);

            //ivoke method on class to test
            Comparator<PojoNumber> comparator = new NumberComparator();
            Arrays.sort(lArray, comparator);
            PojoNumber[] returnedValue = testClass.deleteDublicates(lArray);

            //assert returned value
            Assert.assertTrue(CompareTestArrays(returnedValue, expectedValue));
        }
        else
        {
            String expectedValue = this.expectedErrorCode;
            try{
                PojoNumber[] returnedValue = testClass.deleteDublicates(lArray);
                fail("Exception should be thrown");
            }
            catch(NullArrayRefException e){
                Assert.assertEquals(e.getErrorCode(), expectedValue);
            }

        }

    }
}
package arrays.utils;

/**
 * Created by ivann on 06.04.15.
 */

import sun.org.mozilla.javascript.internal.ast.CatchClause;

import java.util.Arrays;

public class MainApp {

    private static final int[] mergeLArray = {1, 5, 4, 23, 65, 32, 78};
    private static final int[] mergeRArray = {3, 5, 24, 54, 1, 2, 34, 45, 32};
    private static final int[] mergeResultArray = {1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45};

    private static final int[] iUnionLArray = {1,5,4,23,65,32,78};
    private static final int[] iUnionRArray = {3,5,24,4,1,2,34,45,32,5};
    private static final int[] iUnionResultArray = {5,4,32,1};

    private static final int[] oUnionLArray = {1,5,4,23,65,32,78};
    private static final int[] oUnionRArray = {3,5,24,4,1,2,34,45,32,5};
    private static final int[] oUnionResultArray = {23,65,78,3,24,2,34,45};



    public static void main(String[] args) {

        try {
            PojoNumber[] mergeResult = null;
            PojoNumber[] innerUnionResult = null;
            PojoNumber[] outerUnionResult = null;


            Data mergeData = new Data(MainApp.mergeLArray, MainApp.mergeRArray, MainApp.mergeResultArray);
            Data innerUnionData = new Data(MainApp.iUnionLArray, MainApp.iUnionRArray, MainApp.iUnionResultArray);
            Data outerUnionData = new Data(MainApp.oUnionLArray, MainApp.oUnionRArray, MainApp.oUnionResultArray);
            //local code review (vtegza): extract separated calls to the separated method, keep all needed data inside of those test methods @ 06.04.15

            ArrayUnion arrayUnion = new ArrayUnion();

            mergeResult = arrayUnion.arraysMerge(mergeData.getLArray(), mergeData.getRArray());
            System.out.println("Merging result array:");
            System.out.println(Arrays.toString(mergeResult));
            System.out.println("Etalon array:");
            System.out.println(Arrays.toString(mergeData.getResultArray()));
            if (arrayUnion.testResult(mergeResult, mergeData.getResultArray())) {
                System.out.println("OK. Merging result matches etalon");
            } else {
                System.out.println("ERROR. Merging result doesnt match etalon");
            }

            innerUnionResult = arrayUnion.arraysInnerUnion(innerUnionData.getLArray(), innerUnionData.getRArray());
            System.out.println("Inner union result array:");
            System.out.println(Arrays.toString(innerUnionResult));
            System.out.println("Etalon array:");
            System.out.println(Arrays.toString(innerUnionData.getResultArray()));
            if (arrayUnion.testResult(innerUnionResult, innerUnionData.getResultArray())) {
                System.out.println("OK. Inner union result matches etalon");
            } else {
                System.out.println("ERROR. Inner union result doesnt match etalon");
            }

            //outerUnionResult = arrayUnion.arraysOuterUnion(outerUnionData.getLArray(), outerUnionData.getRArray());
            outerUnionResult = arrayUnion.arraysOuterUnion(null, outerUnionData.getRArray());
            System.out.println("Outer union result array:");
            System.out.println(Arrays.toString(outerUnionResult));
            System.out.println("Etalon array:");
            System.out.println(Arrays.toString(outerUnionData.getResultArray()));
            if (arrayUnion.testResult(outerUnionResult, outerUnionData.getResultArray())) {
                System.out.println("OK. Outer union result matches etalon");
            } else {
                System.out.println("ERROR. Outer union result doesnt match etalon");
            }

        }
        catch (NullArrayRefException e)
        {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }

}

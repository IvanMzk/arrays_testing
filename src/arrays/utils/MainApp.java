package arrays.utils;

/**
 * Created by ivann on 06.04.15.
 */

import java.util.Arrays;

public class MainApp {

    private static final int[] mergeLArray = {1, 5, 4, 23, 65, 32, 78};
    private static final int[] mergeRArray = {3, 5, 24, 54, 1, 2, 34, 45, 32};
    private static final int[] mergeResultArray = {1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45};

    private static final int[] iUnionLArray = {1,5,4,23,65,32,78};
    private static final int[] iUnionRArray = {3,5,24,4,1,2,34,45,32,5};
    private static final int[] iUnionResultArray = {5,4,32,1};

    private static final int[] uUnionLArray = {1,5,4,23,65,32,78};
    private static final int[] uUnionRArray = {3,5,24,4,1,2,34,45,32,5};
    private static final int[] uUnionResultArray = {23,65,78,3,24,2,34,45};



    public static void main(String[] args) {

        PojoNumber[] mergeResult = null;

        Data mergeData = new Data(MainApp.mergeLArray, MainApp.mergeRArray, MainApp.mergeResultArray);
        mergeResult = ArrayUnion.arraysMerge(mergeData.getLArray(), mergeData.getRArray());
        System.out.println(Arrays.toString(mergeResult));



    }



}

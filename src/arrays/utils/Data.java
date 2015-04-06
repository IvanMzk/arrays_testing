package arrays.utils;

/**
 * Created by ivann on 06.04.15.
 */

public class  Data{

    private final PojoNumber[] pojoLArray;
    private final PojoNumber[] pojoRArray;
    private final PojoNumber[] pojoResultArray;

    //local code review (vtegza): should be public @ 06.04.15
    Data(int[] lArray, int[] rArray, int[] resultArray) {
        //local code review (vtegza): keep appl calculation in methods not in data some creator data style @ 06.04.15
        pojoLArray = new PojoNumber[lArray.length];
        pojoRArray = new PojoNumber[rArray.length];
        pojoResultArray = new PojoNumber[resultArray.length];
        int i = 0;
        for (int item : lArray){
            pojoLArray[i] = new PojoNumber(item);
            i++;
        }
        i = 0;
        for (int item : rArray){
            pojoRArray[i] = new PojoNumber(item);
            i++;
        }
        i = 0;
        for (int item : resultArray){
            pojoResultArray[i] = new PojoNumber(item);
            i++;
        }
    }

    public PojoNumber[] getLArray() {
        return pojoLArray;
    }

    public PojoNumber[] getRArray() {
        return pojoRArray;
    }

    public PojoNumber[] getResultArray() {
        return pojoResultArray;
    }
}

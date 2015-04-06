package arrays.utils;

import java.util.Comparator;

/**
 * Created by ivann on 06.04.15.
 */
final public class PojoNumber implements Comparable<PojoNumber> {

    private final int number;

    public PojoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PojoNumber)) return false;

        PojoNumber that = (PojoNumber) o;

        if (number != that.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int compareTo(PojoNumber o){

        if (equals(o)){return 0;}
        if (number > o.getNumber()){return 1;}

        return -1;
    }


}

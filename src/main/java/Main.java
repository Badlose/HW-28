import StringListService.StringList;
import StringListService.StringListImpl.StringListImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl();


        String stringToAdd = "string to add";
        String stringToAdd2 = "string to add2";
        String stringToAdd3 = "string to add3";
        String stringToAdd4 = "string to add4";
        String stringToAdd5 = "string to add5";
        String stringToAdd6 = "string to add6";

        System.out.println(stringList.add(stringToAdd));
        System.out.println(stringList.add(2, stringToAdd4));
        System.out.println(stringList.add(2, stringToAdd3));
        System.out.println(stringList.add(1, stringToAdd4));

//        stringList.add(11, stringToAdd);

        System.out.println(stringList.set(1, stringToAdd2));

        System.out.println(stringList.add(4, stringToAdd5));

        System.out.println(stringList.remove(stringToAdd5));
        System.out.println(stringList);

        System.out.println(stringList.remove(3));


        System.out.println(stringList);

        System.out.println(stringList.contains(stringToAdd6));
        System.out.println(stringList.contains(stringToAdd3));

        System.out.println(stringList.indexOf(stringToAdd3));
        System.out.println(stringList.indexOf(stringToAdd6));

        System.out.println(stringList.lastIndexOf(stringToAdd3));
        System.out.println(stringList.lastIndexOf(stringToAdd6));

        System.out.println(stringList.get(2));
//        System.out.println(stringList.get(3));

        StringList stringListForEquals = new StringListImpl(6);
        stringListForEquals.add(stringToAdd);
        stringListForEquals.add(stringToAdd2);
        stringListForEquals.add(stringToAdd3);

        System.out.println(stringList.equals(stringListForEquals));

        stringListForEquals.remove(2);

        System.out.println(stringList.equals(stringListForEquals));
//        System.out.println(stringList.equals(null));


        System.out.println(stringList.size());

//        stringList.clear();                           //если раскомментировать, то следующий метод будет с null-ами.
//        System.out.println(stringList);


        System.out.println(Arrays.toString(stringList.toArray()));

    }
}

package StringListService.StringListImpl;

import Exceptions.ItemNotFoundException;
import Exceptions.OtherListIsNullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private StringListImpl stringList;

    @BeforeEach
    public void clearAll() {
        stringList = new StringListImpl();
    }

    @Test
    public void shouldAddNewString() {
        String expectedString = "string to add";
        String actualString = stringList.add(expectedString);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenAddString() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity - 1; i++) {
            stringList.add("string to add " + i);
        }
        String string = null;
        assertThrows(IllegalArgumentException.class, () -> stringList.add(string));
    }

    @Test
    public void shouldEnlargeStringList() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        int expectedSize = stringList.size();

        for (int i = 6; i < defaultCapacity * 2; i++) {
            stringList.add("string to add " + i);
        }
        int actualSize = stringList.size();

        assertEquals(expectedSize, defaultCapacity);
        assertEquals(actualSize, defaultCapacity * 2);
    }

    @Test
    public void shouldAddStringByIndexIfArrayIndexIsNotNull() {
        String expectedString = "string to add";
        String actualString = stringList.add(0, expectedString);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldAddStringByIndexIfArrayIndexIsNul() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String expectedString = "new string";
        String actualString = stringList.add(0, expectedString);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenAddStringByIndex() {
        String stringToAdd = "exception string";
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                stringList.add(6, stringToAdd));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenIndexWasGiven() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String string = null;

        assertThrows(IllegalArgumentException.class, () -> stringList.add(0, string));
    }

    @Test
    public void shouldSetStringByIndex() {
        String stringToSet = "new string";
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String actualString = stringList.set(0, stringToSet);
        assertEquals(stringToSet, actualString);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSetString() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String string = null;

        assertThrows(IllegalArgumentException.class, () -> stringList.set(0, string));
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenSetString() {
        String stringToAdd = "exception string";
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                stringList.add(6, stringToAdd));
    }

    @Test
    public void shouldRemoveStringWhenStringGiven() {
        String expectedString = "string to add";
        int expectedSize = 0;
        String actualString = stringList.add(expectedString);
        stringList.remove(expectedString);
        int actualSize = stringList.size();

        assertEquals(expectedSize, actualSize);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenRemoveString() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String string = null;

        assertThrows(IllegalArgumentException.class, () -> stringList.remove(string));
    }

    @Test
    public void shouldThrowItemNotFoundExceptionWhenRemoveStringNotInArray() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String exceptionString = "exception string";
        assertThrows(ItemNotFoundException.class, () -> stringList.remove(exceptionString));
    }

    @Test
    public void shouldRemoveStringWhenStringIndexGiven() {
        String expectedString = "string to add";
        int expectedSize = 0;
        String actualString = stringList.add(0, expectedString);
        stringList.remove(0);
        int actualSize = stringList.size();

        assertEquals(expectedSize, actualSize);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenRemoveStringByIndex() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringList.remove(7));
    }

    @Test
    public void shouldReturnTrueWhenArrayContainsString() {
        String expectedString = "string to add 5";
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }

        assertTrue(stringList.contains(expectedString));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTryArrayContainsNull() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String string = null;

        assertThrows(IllegalArgumentException.class, () -> stringList.contains(string));
    }

    @Test
    public void shouldReturnIndexOfString() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String string = "string to add 2";
        int expectedInt = 2;
        int actualInt = stringList.indexOf(string);

        assertEquals(expectedInt, actualInt);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTryToFindIndexOfString() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String string = null;

        assertThrows(IllegalArgumentException.class, () -> stringList.indexOf(string));
    }

    @Test
    public void shouldReturnLastIndexOfString() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String string = "string to add 2";
        int expectedInt = 2;
        int actualInt = stringList.lastIndexOf(string);

        assertEquals(expectedInt, actualInt);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTryToFindLastIndexOfString() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String string = null;

        assertThrows(IllegalArgumentException.class, () -> stringList.lastIndexOf(string));
    }

    @Test
    public void shouldGetStringByIndex() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        String expectedString = "string to add 2";
        String actualString = stringList.get(2);

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenGetStringByIndex() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        int exceptionInt = 7;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringList.get(exceptionInt));
    }

    @Test
    public void shouldReturnTrueWhenComparingArrays() {
        int defaultCapacity = 6;
        StringListImpl stringListToCompare = new StringListImpl();

        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }

        for (int i = 0; i < defaultCapacity; i++) {
            stringListToCompare.add("string to add " + i);
        }
        System.out.println(stringList.toString());
        System.out.println(stringListToCompare.toString());
        assertTrue(stringList.equals(stringListToCompare));
    }

    @Test
    public void shouldThrowOtherListIsNullException() {
        int defaultCapacity = 6;
        StringListImpl stringListToCompare = null;

        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }

        assertThrows(OtherListIsNullException.class, () -> stringList.equals(stringListToCompare));
    }

    @Test
    public void shouldReturnArraySize() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        int expectedInt = 6;
        int actualInt = stringList.size();

        assertEquals(expectedInt, actualInt);
    }

    @Test
    public void shouldReturnTrueWhenArrayIsEmpty() {
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void shouldClearArray() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity; i++) {
            stringList.add("string to add " + i);
        }
        int expectedSize = 0;
        stringList.clear();
        int actualSize = stringList.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void toArray() {
        int defaultCapacity = 6;
        for (int i = 0; i < defaultCapacity - 1; i++) {
            stringList.add("string to add " + i);
        }
        String[] expectedArray = new String[5];
        for (int i = 0; i < expectedArray.length; i++) {
            expectedArray[i] = "string to add " + i;
        }
        String[] actualArray = stringList.toArray();

        assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
    }
}
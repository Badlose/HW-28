package StringListService.StringListImpl;

import Exceptions.ItemNotFoundException;
import Exceptions.OtherListIsNullException;
import StringListService.StringList;

import java.util.Arrays;
import java.util.Objects;


public class StringListImpl implements StringList {
    private int defaultCapacity = 6;
    private int currentIndex = 0;
    String[] stringArray = new String[defaultCapacity];

    public StringListImpl() {
    }

    public StringListImpl(int defaultCapacity) {
        this.defaultCapacity = defaultCapacity;
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (currentIndex == stringArray.length) {
            this.enlarge();
        }

        stringArray[currentIndex] = item;
        currentIndex++;

        return item;
    }

    private void enlarge() {
        int newCapacity = defaultCapacity * 2;
        String[] newStringArray = new String[newCapacity];

        System.arraycopy(stringArray, 0, newStringArray, 0, stringArray.length);
        stringArray = newStringArray;
        defaultCapacity = newCapacity;
    }


    @Override
    public String add(int index, String item) {
        if (index >= stringArray.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (stringArray[index] != null) {
            System.arraycopy(stringArray, index, stringArray, index + 1, stringArray.length - index - 1 - 1);
            stringArray[index] = item;
            currentIndex++;
            return item;
        } else if (stringArray[index] == null) {
            stringArray[index] = item;
            currentIndex++;
            return item;
        }

        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index >= stringArray.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }
        stringArray[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        String resultString = "";

        for (int i = 0; i < stringArray.length; i++) {
            if (Objects.equals(stringArray[i], item)) {
                System.arraycopy(stringArray, i + 1, stringArray, i, stringArray.length - i - 1);
                currentIndex--;
                resultString = item;
            }
        }
        if (resultString.isBlank()) {
            throw new ItemNotFoundException();
        }

        return resultString;
    }

    @Override
    public String remove(int index) {
        if (index >= stringArray.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String item = stringArray[index];

        System.arraycopy(stringArray, index + 1, stringArray, index, stringArray.length - index - 1);
        currentIndex--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < stringArray.length; i++) {
            if (Objects.equals(stringArray[i], item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < stringArray.length; i++) {
            if (Objects.equals(stringArray[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        for (int i = stringArray.length - 1; i > 0; i--) {
            if (Objects.equals(stringArray[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= stringArray.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return stringArray[index];
    }

    @Override
    public boolean equals(StringListImpl otherList) {
        if (otherList == null) {
            throw new OtherListIsNullException();
        }
        for (int i = 0; i < stringArray.length; i++) {
            if (!Objects.equals(stringArray[i], otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return this.currentIndex;
    }

    @Override
    public boolean isEmpty() {
        return this.currentIndex == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = null;
            currentIndex = 0;
        }
    }

    @Override
    public String[] toArray() {
        int count = 0;
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] != null) {
                count++;
            }
        }
        String[] newStringArray = new String[count];
        System.arraycopy(stringArray, 0, newStringArray, 0, newStringArray.length);
        return newStringArray;
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "defaultCapacity=" + defaultCapacity +
                ", currentIndex=" + currentIndex +
                ", stringArray=" + Arrays.toString(stringArray) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringListImpl that = (StringListImpl) o;
        return defaultCapacity == that.defaultCapacity && currentIndex == that.currentIndex && Objects.deepEquals(stringArray, that.stringArray);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultCapacity, currentIndex, Arrays.hashCode(stringArray));
    }
}

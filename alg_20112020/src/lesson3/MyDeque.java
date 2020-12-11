package lesson3;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyDeque<T> {
    private T[] arr;
    private int begin = 0;
    private int end = 0;
    private int size = 0;
    private double loadFactor = 0.75;

    public MyDeque() {
        this(10);
    }

    public MyDeque(int num) {
        this(num, 0.75);
    }

    public MyDeque(int num, double loadFactor) {
        setLoadFactor(loadFactor);
        if (num > 0) {
            arr = (T[]) new Object[num];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addRight(T value) {
        size++;
        expand();
        arr[end] = value;
        end = nextIndex(end);
    }

    public void addLeft(T value) {
        size++;
        expand();
        begin = lastIndex(begin);
        arr[begin] = value;
    }

    public T peekRight() {
        if (size <= 0) {
            throw new EmptyStackException();
        }
        return arr[begin];
    }

    public T peekLeft() {
        if (size <= 0) {
            throw new EmptyStackException();
        }
        return arr[lastIndex(end)];
    }

    public T removeRight() {
        T value = peekRight();
        size--;
        arr[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    public T removeLeft() {
        T value = peekLeft();
        size--;
        end = lastIndex(end);
        arr[end] = null;
        return value;
    }

    private int nextIndex(int index) {
        return (index + 1) % arr.length;
    }

    private int lastIndex(int index) {
        return (arr.length + index - 1) % arr.length;
    }

    public void info() {
        System.out.print(Arrays.toString(arr));
        System.out.printf("begin: %d end: %d size %d \n", begin, end, size);
    }

    private final void setLoadFactor(double loadFactor) {
        if (loadFactor > 0 && loadFactor < 1) {
            this.loadFactor = loadFactor;
        }
    }

    private void expand() {
        if ((double) size / arr.length > loadFactor) {
            T[] tempArr = (T[]) new Object[arr.length * 2];
            if (begin <= end) {
                System.arraycopy(arr, 0, tempArr, 0, arr.length);
            } else {
                System.arraycopy(arr, 0, tempArr, 0, end);
                int newBegin = tempArr.length - arr.length + begin;
                System.arraycopy(arr, begin, tempArr, newBegin, arr.length - begin);
                begin = newBegin;
            }
            arr = tempArr;
        }
    }
}
package lesson2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
//        MyArrayList<Integer> mal = new MyArrayList<>();
//        mal.add(5);
//        mal.add(2);
//        mal.add(1);
//        mal.add(3);
//        mal.add(4);
//        System.out.println(mal);


//
//        mal.add(3, 99);
//        System.out.println(mal);
//
////        mal.remove((Integer) 1);
////        System.out.println(mal);
//
//        System.out.println(mal.indexOf(44));


//        MySortedArraylist<Integer> msal = new MySortedArraylist<>();
//        msal.add(5);
//        msal.add(2);
//        msal.add(1);
//        msal.add(3);
//        msal.add(4);
//        System.out.println(msal);
//        System.out.println(msal.binaryFind(3));


//        for (int i = 0; i < 10; i++) {
//            msal.add(random.nextInt(100) );
//        }
//        System.out.println(msal);
//        System.out.println(msal.recBinaryF(19));


        MyArrayList<Integer> mal = new MyArrayList<>(1000000);
        for (int i = 0; i < 1000000; i++) {
            mal.add(random.nextInt(1000));
        }
//
////        System.out.println(mal);
//
        long begin = System.currentTimeMillis();
//        mal.selectionSort(Comparator.naturalOrder());  //O(n*n)
//        mal.selectionSort(Comparator.reverseOrder());
//        mal.selectionSort((a,b)->{return a%10 - b %10;});

//        mal.insertionSort();  //O(n*n)
//        mal.bubbleSort(); // O(n*n)
//        mal.qSort();  // O(log(n)*n)
        mal.timSort();// O(log(n)*n)

        long end = System.currentTimeMillis();
        System.out.printf("time: %d ms", end - begin);
//        System.out.println(mal);
    }
}

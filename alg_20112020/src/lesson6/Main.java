package lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//        MyTreeMap<Integer, String> map = new MyTreeMap<>();
//
//        map.put(6,"six");
//        map.put(5,"five");
//        map.put(4,"four");
//        map.put(3,"three");
//        map.put(2,"two");
//        map.put(1,"one");
//        map.put(7,"seven");
//
//
////        System.out.println(map);
////        System.out.println(map.get(2));
//
////        map.deleteMin();
//        System.out.println(map);
//        System.out.println(map.size());
//
////        map.delete(5);
//        System.out.println(map);
//        System.out.println(map.size());
//        System.out.println(map.height());
//        System.out.println(map.isBalanced());

//        Random random = new Random();
//
//        MyTreeMap<Integer, Integer>[] integerMyTreeMaps = new MyTreeMap[20];
//
//       for(int i = 0; i < integerMyTreeMaps.length; i++){
//
//           integerMyTreeMaps[i] = new MyTreeMap<>();
//           while (integerMyTreeMaps[i].height() <= 6){
//
//               int element = random.nextInt(200) - 100;
//               integerMyTreeMaps[i].put(element, element);
//           }
//           System.out.println(integerMyTreeMaps[i] + "  is  " + integerMyTreeMaps[i].isBalanced() );
//
//       }


        makeNumber(20);

        
    }

    public static void makeNumber(int number){
        Random random = new Random();

        MyTreeMap<Integer, Integer>[] integerMyTreeMaps = new MyTreeMap[number];

        int sunOfBalance = 0;

        for(int i = 0; i < integerMyTreeMaps.length; i++){

            integerMyTreeMaps[i] = new MyTreeMap<>();
            while (integerMyTreeMaps[i].height() <= 6){

                int element = random.nextInt(200) - 100;
                integerMyTreeMaps[i].put(element, element);
            }
            System.out.println(integerMyTreeMaps[i] + "  is  " + integerMyTreeMaps[i].isBalanced() );
            if(integerMyTreeMaps[i].isBalanced() == false){
                sunOfBalance++ ;
            }

        }

        System.out.println("Процент несбалансированных деревьев " +  sunOfBalance * 100 /number + "%");
    }
}

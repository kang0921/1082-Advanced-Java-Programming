package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static List<Integer> isFactor(Integer n){
        List<Integer> arr = new ArrayList<>();
        IntStream.rangeClosed(1, n).forEach( i -> {if(n%i==0) arr.add(i);});
        return arr;
    }

    public static List<Integer> isMultiple(Integer n1, Integer n2){
        return Stream.iterate(n1, i -> i + n1)
                    .limit(n2)
                    .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            Integer n1 = input.nextInt();
            Integer n2 = input.nextInt();

            List<Integer> n1Factor = isFactor(n1);
            List<Integer> n2Factor = isFactor(n2);
            Collection<Integer> n1CollectionOfFactor = new ArrayList<Integer>(n1Factor);
            Collection<Integer> n2CollectionOfFactor = new ArrayList<Integer>(n2Factor);
            n1CollectionOfFactor.retainAll(n2CollectionOfFactor);
            System.out.print( Collections.max( n1CollectionOfFactor ) + " ");

            List<Integer> n1Multiple = isMultiple(n1, n2);
            List<Integer> n2Multiple = isMultiple(n2, n1);
            Collection<Integer> n1CollectionOfMultiple = new ArrayList<Integer>(n1Multiple);
            Collection<Integer> n2CollectionOfMultiple = new ArrayList<Integer>(n2Multiple);
            n1CollectionOfMultiple.retainAll(n2CollectionOfMultiple);
            System.out.println( Collections.min( n1CollectionOfMultiple) );
        }

    }

}

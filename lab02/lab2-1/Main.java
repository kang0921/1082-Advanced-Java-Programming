package com.company;

import javax.swing.*;

import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class map{
    private Integer key;
    private Integer value;
    map(Integer k, Integer v){
        key = k;
        value = v;
    }
    public Integer getKey(){return this.key;}
    public Integer getValue(){return this.value;}
}
public class Main {

    public static boolean isPrime(int candidate){
        int candidateRoot = (int)Math.sqrt((double)candidate);
        if(candidate < 2)return false;
        return IntStream.rangeClosed(2, candidateRoot)
                        .noneMatch( i -> candidate % i == 0 );
    }

    public static List<Integer> isFactor(int n){
        List<Integer> arr = new ArrayList<>();
        IntStream.rangeClosed(1, n).forEach( i -> {if(n%i==0) arr.add(i);});
        return arr;
    }

    public static List<Integer> primePower(Integer i, int num){
        return Stream.iterate( i, j -> j*i)
                .limit(num)
                .filter( k -> { if(k!=0)
                                    return (num % k == 0);
                                return false; } )
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        while(input.hasNext()){
            if(flag)System.out.println();
            flag = true;

            int num = input.nextInt();
            // Q1: For each integer N, generate a list of all factors of N print out all factors of N in ascending order.
            String factorStr = isFactor(num).stream()
                                .map( n -> n.toString() )
                                .collect(joining(" "));
            System.out.println(factorStr);

            // Q2: For each integer N, generate a list of all prime factors of N and print them out in ascending order.
            String primeOfFactorStr = isFactor(num).stream()
                                        .filter(Main::isPrime)
                                        .map( n -> n.toString() )
                                        .collect(joining(" "));
            System.out.println(primeOfFactorStr);

            /*Q3: For each integer N, generate a map of all (key, value) pairs, where key and value are the prime factor of N and its maximal power of key,
			 i.e., N is dividable to key_value. Print out all pairs in the ascending order of keys.*/
            Map<Integer, Integer> mapPrimeOfPower = isFactor(num).stream()
                                    .filter(Main::isPrime)
                                    .map( x -> Main.primePower( x, num))
                                    .map( y -> new map(y.get(0), y.size()))
                                    .collect(Collectors.toMap(map::getKey , map::getValue));
            mapPrimeOfPower.forEach( ( i, j ) ->{
                System.out.print("(" + i + ", " + j + ")");
            });
            System.out.println();
        }
    }
}

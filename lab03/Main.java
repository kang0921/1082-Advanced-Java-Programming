package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int num = input.nextInt();
            ArrayDeque<Integer> L = new ArrayDeque<>();
            L.add(1);
            System.out.println("N = " + num );

            Stream.iterate(L,
                    i -> {
                        ArrayDeque<Integer> L1 = i.clone();
                        ArrayDeque<Integer> L2 = i.clone();
                        L1.addFirst(0);
                        L2.addLast(0);
                        ArrayDeque<Integer> ans = new ArrayDeque<>();
                        int L1Size = L1.size();

                        Stream.iterate(0, j -> j < L1Size , j -> j + 1 )
                              .forEach( k -> ans.add( L1.pop() + L2.pop() ) );
                        return ans;
                    })
                    .limit( num + 1 )
                    .forEach(
                            arr ->{
                                if(arr.size() != (num+1) )
                                    Stream.iterate( 0, n -> n < num - ( arr.size() - 1 ), n -> n + 1 )
                                          .forEach( i -> System.out.print(" ") );
                                String str = arr.stream()
                                                .map( n -> n.toString() )
                                                .collect( Collectors.joining(" ") );
                                System.out.println(str);
                            }
                    );
        }
    }
}

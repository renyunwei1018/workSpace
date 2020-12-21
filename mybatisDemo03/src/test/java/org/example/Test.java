package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {


        public static void main(String[] args) {

            Integer[] a = {1,2,3,3,4,2,3,4,5,6,1};

            Set<Integer> set = new HashSet(Arrays.asList(a));
            for (int n: set) {
                System.out.println(n);
            }
        }
    }


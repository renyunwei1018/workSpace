package com.test.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int le = sc.nextInt();
            int[] arr = new int[le];
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            for (int i = 0;i<le;i++){
                arr[i]= Integer.parseInt(s1[i]);
            }

            Arrays.sort(arr);

           List lis = new ArrayList();

         for (int j = le-1;j>=0;j--){
             int n = arr[j] - arr[j - 1];
             if (n>0){
                 arr[j-1]=n;
                 arr[j] =0;
                 Arrays.sort(arr);
             }
             if (n==0){
                 j=j-1;
             }

         }

        }
    }
}

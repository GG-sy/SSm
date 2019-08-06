package com;

import java.util.concurrent.ForkJoinPool;

public class xulie {
    private static int arr[]={1,5,8,6,3,4,7,9};
    public static void main(String[] args) {

        System.out.println("排序前");
        show();
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]) {//">"表示从小到大的顺序"<"表示从大到小
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后");
        show();
    }

    private static void show() {
        for (int i : arr) {
            System.out.print("["+i+"]");
        }
        System.out.println();
    }



}


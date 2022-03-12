package com.javaBook.ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest {
    public static void main(String[] args) {
        ArrayList al = new ArrayList(200000);
        LinkedList ll = new LinkedList();


        System.out.println("=순차적으로 추가하기=");
        System.out.println("Array List : " + add1(al));
        System.out.println("LinkedList : " + add1(ll));
        System.out.println();
        System.out.println("=중간에 추가하기=");
        System.out.println("Array List : "+ add2(al));
        System.out.println("Linked List : "+ add2(ll));
        System.out.println();
        System.out.println("=중간에서 삭제하기=");
        System.out.println("ArrayList : " + remove2(al));
        System.out.println("LinkedList :" + remove2(ll));
        System.out.println();
        System.out.println("=순차적으로 삭제하기=");
        System.out.println("ArrayList : " + remove1(al));
        System.out.println("LinkedList :" + remove1(ll));

    }
    private static long add1(List list) {
        long start = System.currentTimeMillis();
        for(int i =0 ;i<100000;i++) list.add(i+"");
        long end = System.currentTimeMillis();
        return end - start;
    }
    private static long remove2(List list) {
        long start = System.currentTimeMillis();
        for(int i =0 ;i<100000;i++) list.remove(i);
        long end = System.currentTimeMillis();
        return end - start;
    }
    private static long add2(List list) {
        long start = System.currentTimeMillis();
        for(int i =0 ;i<100000;i++) list.add(500,"X");
        long end = System.currentTimeMillis();
        return end - start;
    }
    private static long remove1(List list) {
        long start = System.currentTimeMillis();
        for(int i = list.size()-1;i>=0;i--) list.remove(i);
        long end = System.currentTimeMillis();
        return end - start;
    }
}

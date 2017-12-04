package com.softserve.edu;

public class Appl3 {

    public int m1() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    public static void main(String[] args) {
        Appl3 a = new Appl3();
        System.out.println("Return: " + a.m1());
    }
}

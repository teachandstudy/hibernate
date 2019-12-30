package com.venia.persist.main;


public class SimpleMain {
    class A {
        String str = "ab";

        A() {
            printLength();
        }

        void printLength() {
            System.out.println(str.length());
        }
    }

    class B extends A {
        String str = "abc";

        void printLength() {
            System.out.println(str.length());
        }
    }

//    public static void main(String[] args) {
//        new SimpleMain().new B();
//    }
    public static void main(String[] args) {
        SimpleMain nullReferenceTest = null;
//        System.out.println(nullReferenceTest./*<some descriptor>*/);
    }
}
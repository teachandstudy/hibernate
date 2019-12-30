package com.venia.persist.main;

public class YieldExample {
    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

class Producer extends Thread {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("I am Producer item = " + i);
            Thread.yield();
        }
    }
}
class Consumer extends Thread {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("I am Consumer item = " + i);
            Thread.yield();
        }
    }
}
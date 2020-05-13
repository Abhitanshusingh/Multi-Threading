package com.bridgelabz.stack;

public class StackMultiThreading {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Thread thread1 = new Thread(myStack);
        thread1.run();
    }
}

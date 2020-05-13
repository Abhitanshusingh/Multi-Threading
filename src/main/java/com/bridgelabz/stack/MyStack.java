package com.bridgelabz.stack;

import com.bridgelabz.exception.MyStackException;

public class MyStack extends StackMultiThreading implements Runnable {
    private Object elements[];
    private int capacity;
    private int top;

    public MyStack(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
        this.top = -1;
    }

    public MyStack() {
    }

    //This method is used to insert value into stack
    public boolean push(int element) throws MyStackException {
        if (capacity - 1 == top) {
            throw new MyStackException(MyStackException.ExceptionType.STACK_OVER_FLOW, "Stack is full");
        }
        elements[++top] = element;
        return true;
    }

    //This method is used to remove value from stack
    public Object pop() throws MyStackException {
        if (top == -1) {
            throw new MyStackException(MyStackException.ExceptionType.STACK_UNDER_FLOW, "Stack is empty");
        }
        capacity--;
        return elements[top--];
    }

    public String toString() {
        String str = "[";
        for (int index = 0; index <= top; index++) {
            str += elements[index];
            if (index < top)
                str = str + ",";
        }
        return str + "]";
    }

    @Override
    public void run() {
        try {
            MyStack myStack = new MyStack(5);
            myStack.push(2);
            myStack.push(4);
            myStack.push(6);
            myStack.pop();
            System.out.println(myStack);
        } catch (MyStackException e) {
            e.printStackTrace();
        }
    }
}

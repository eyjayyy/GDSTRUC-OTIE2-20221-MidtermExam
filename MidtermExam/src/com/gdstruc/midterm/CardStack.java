package com.gdstruc.midterm;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.ListIterator;

public class CardStack {
    private LinkedList<Card> stack;

    public CardStack() {
        stack = new LinkedList<>();
    }

    public void push(Card card) {
        stack.push(card);
    }

    public Card pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.pop();
    }

    public Card peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Card> iterator = stack.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public int size() {
        return stack.size();
    }
}
package com.example.tp.verification.tp6.model;

import com.example.tp.verification.tp6.exceptions.ElementIsNull;
import com.example.tp.verification.tp6.exceptions.QueueIsEmpty;
import com.example.tp.verification.tp6.exceptions.TailIsNull;

import java.util.ArrayList;

public class Queue<E> {
    ArrayList<E> list = new ArrayList<>();

    E tail = null;

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E elem) {
        if (elem == null) {
            throw new ElementIsNull("Element is null");
        }
        if (list.isEmpty()) {
            tail = elem;
        }
        list.add(elem);
    }

    public E pop() {
        if (isEmpty()) {
            throw new QueueIsEmpty("Queue is empty");
        }
        if (list.size() == 1) {
            tail = null;
        }
        return list.remove(list.size() - 1);
    }

    public int size() {
        if(isEmpty()) {
            throw new QueueIsEmpty("Queue is empty");
		}
        return list.size();
    }

    public E front() {
        if (tail == null) {
            throw new TailIsNull("Tail is null");
        }
        return tail;
    }
}
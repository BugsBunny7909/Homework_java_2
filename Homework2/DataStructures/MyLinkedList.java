package Homework2.DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

//Односвязный
public class MyLinkedList<E> implements Iterable<E> {

    private Node top, end;
    private int length = 0;

    MyLinkedList() {
        end = new Node(null, null);
        top = new Node(null, end);
    }


    public int length() {
        return length;
    }


    //Добавление в конец
    public void add(E element) {
        //если список пустой
        if (length == 0) {
            top.next = new Node(element, end);
            length++;
            return;
        }

        //Не пустой
        Node last = getLast().next = new Node(element, end);

        length++;
    }

    public Node getLast() {
        Node current = top;
        while (current.next != end) {
            current = current.next;
        }
        return current;
    }

    //Удаление элемента (true - успех, false - неуспех)
    public boolean remove(E element) {
        Node previous = top;
        while (previous.next != end) {
            //Нашли элемент
            if (previous.next.value == element) {
                //Удаляем
                previous.next = previous.next.next;
                length--;
                return true;
            }
            previous = previous.next;
        }
        //Если не нашли
        return false;
    }

    public boolean contains(E element) {
        Node current = top.next;
        while (current != end) {
            if (current.value == element) return true;

            current = current.next;
        }
        return false;
    }

    public E get(int index) throws Exception {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();//кидаем исключение
        Node current = top.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void addAll(E... elems) throws Exception {
        if (elems == null) throw new NullPointerException();
        for (E elem : elems) {
            add(elem);
        }
    }

    //"красивый" вывод
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = top.next;
        sb.append('[');
        while (current != end) {
            sb.append(current.value);
            current = current.next;
            if (current != end) {
                sb.append(" -> ");
            }
        }
        sb.append(']');
        sb.append(" Длина списка: " + length);

        return sb.toString();
    }


    class Node {
        E value;
        Node next;

        Node(E element, Node next) {
            value = element;
            this.next = next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node current = top.next; // Текущий узел

        @Override
        public boolean hasNext() {
            return current != end;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E value = current.value;
            current = current.next;
            return value;
        }
    }

}
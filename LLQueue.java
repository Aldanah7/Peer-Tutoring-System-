
import java.util.function.Predicate;

public class LLQueue<E> {

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> front, rear;
    private int size;

    public LLQueue() {
        front = rear = null;
        size = 0;
    }

    public void add(E elem) {
        Node<E> newNode = new Node<>(elem, null);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    public E remove() {
        if (isEmpty()) {
            return null;
        }
        E value = front.getData();
        front = front.getNext();
        size--;
        if (size == 0) {
            rear = null;
        }
        return value;
    }

    public E peek() {
        return isEmpty() ? null : front.getData();

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Node<E> current = front;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public E find(Predicate<E> condition) {
        Node<E> current = front;
        while (current != null) {
            if (condition.test(current.getData())) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public int count(Predicate<E> condition) {
        int c = 0;
        Node<E> current = front;
        while (current != null) {
            if (condition.test(current.getData())) {
                c++;
            }
            current = current.getNext();
        }
        return c;
    }

}

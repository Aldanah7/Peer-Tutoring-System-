
public class SinglyLinkedList<E> {

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

    private Node<E> head, tail;
    private int size;

    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void addLast(E elem) {
        Node<E> node = new Node<>(elem, null);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public boolean remove(E elem) {
        if (isEmpty()) {
            return false;
        }
        Node<E> current = head, prev = null;
        while (current != null) {
            if (current.getData().equals(elem)) {
                if (prev == null) {
                    head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                if (current == tail) {
                    tail = prev;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.getNext();
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public Tutor searchTutorById(int id) {
        Node<E> current = head;
        while (current != null) {
            if (current.getData() instanceof Tutor) {
                Tutor t = (Tutor) current.getData();
                if (t.getId() == id) {
                    return t;
                }
            }
            current = current.getNext();
        }
        return null;
    }

    public Tutor searchTutorByName(String name) {
        Node<E> current = head;
        while (current != null) {
            if (current.getData() instanceof Tutor) {
                Tutor t = (Tutor) current.getData();
                if (t.nameMatches(name)) {
                    return t;
                }
            }
            current = current.getNext();
        }
        return null;
    }
}

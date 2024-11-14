package cmpe_211_ex01;

public class LinkedList<T> {
    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    // Add an element to the end of the list
    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(data);
        }
    }

    // Custom iterator method to return an instance of the iterator
    public LinkedListIterator iterator() {
        return new LinkedListIterator();
    }

    // Inner class for manually implementing the iterator
    public class LinkedListIterator {
        private Node<T> current = head;

        // Check if there's a next element
        public boolean hasNext() {
            return current != null;
        }

        // Get the next element
        public T next() {
            if (current == null) {
                throw new IllegalStateException("No more elements");
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
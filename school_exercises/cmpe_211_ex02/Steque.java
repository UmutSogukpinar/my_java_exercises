package cmpe_211_ex02;

class Node<T>
{
    T data;
    Node<T> next;

    public Node(T data)
    {
        this.data = data;
        this.next = null;
    }
}

public class Steque<T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Node<T> getHead() {
        return head;
    }

    public Steque()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public void push(T data)
    {
        Node<T> newNode = new Node<>(data);
        if (size == 0)
        {
            head = newNode;
            tail = newNode;
        } else
        {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public T pop()
    {
        if (head == null || head.data == null)
            throw new IllegalStateException("Stack is empty");
        else if (size == 1)
        {
            head = null;
            tail = null;
        }
        else
            head = head.next;
        size--;
        return (head.data);
    }

    public void enqueue(T data)
    {
        Node<T> newNode = new Node<>(data);
        if (size == 0)
            head = newNode;
         else
            tail.next = newNode;
        tail = newNode;
        size++;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Steque<Integer> steque = new Steque<>();

        System.out.println("Addition with the push function:");
        steque.push(10);
        steque.push(20);
        steque.push(30);
        printSteque(steque);

        System.out.println("\nRemove with the pop function:");
        int poppedValue = steque.pop();
        System.out.println("Removed element: " + poppedValue);
        printSteque(steque);

        System.out.println("\nAddition with enqueue function:");
        steque.enqueue(40);
        steque.enqueue(50);
        printSteque(steque);

        System.out.println("\nAgain additon with the pop function:");
        poppedValue = steque.pop();
        System.out.println("Removed element: " + poppedValue);
        printSteque(steque);
    }

    public static void printSteque(Steque<Integer> steque)
    {
        Node<Integer> current = steque.getHead();
        System.out.print("Steque: ");
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
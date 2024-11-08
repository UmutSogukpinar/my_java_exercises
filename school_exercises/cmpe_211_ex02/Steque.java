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
        T deletedData = head.data;
        if (size <= 0)
            throw new IllegalStateException("Stack is empty");
        else if (size == 1)
        {
            head = null;
            tail = null;
        }
        else
            head = head.next;
        size--;
        return (deletedData);
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
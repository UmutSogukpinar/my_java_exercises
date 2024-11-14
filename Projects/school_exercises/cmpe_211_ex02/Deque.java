package cmpe_211_ex02;

import java.util.Iterator;

public class Deque<T> implements Iterable<T>
{
    private DoubleLinkedList<T> list;

    public Deque()
    {
        list = new DoubleLinkedList<T>();
    }

    public void pushLeft(T data)
    {
        DoubleLinkedList.insertAtStart(list, data);
    }

    public void pushRight(T data)
    {
        DoubleLinkedList.insertAtEnd(list, data);
    }

    public T popLeft()
    {
        if (list.getHead() == null) {
            throw new IllegalStateException("Deque is empty");
        }
        T data = list.getHead().data;
        DoubleLinkedList.removeFromStart(list);
        return (data);
    }

    public T popRight()
    {
        if (list.getHead() == null)
            throw new IllegalStateException("Deque is empty");
        T data = list.getHead().data;
        DoubleLinkedList.removeFromEnd(list);
        return (data);
    }

    public boolean isEmpty()
    {
        return (list.getHead()) == null;
    }

    public int size()
    {
        int len = 0;
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext())
        {
            len++;
            iterator.next();
        }
        return (len);
    }

    @Override
    public Iterator<T> iterator()
    {
        return (new Iterator<T>()
        {
            private DoubleNode<T> current = list.getHead();

            @Override
            public boolean hasNext()
            {
                return (current != null);
            }

            @Override
            public T next()
            {
                if (!hasNext())
                    throw new IllegalStateException("No more elements");

                T data = current.data;
                current = current.next;
                return (data);
            }
        });
    }
}

class Main3
{
    public static void main(String[] args)
    {
        Deque<Integer> deque = new Deque<>();

        System.out.println("Adding elements using pushLeft and pushRight:");
        deque.pushLeft(10);
        deque.pushLeft(20);
        deque.pushRight(30);
        deque.pushRight(40);

        System.out.println("Deque after adding elements:");
        printDeque(deque);

        System.out.println("Size of Deque: " + deque.size());

        System.out.println("\nPopping elements from left and right:");
        System.out.println("Popped from left: " + deque.popLeft());
        System.out.println("Popped from right: " + deque.popRight());

        System.out.println("Deque after popping elements:");
        printDeque(deque);

        System.out.println("Is Deque empty? " + deque.isEmpty());

        deque.pushRight(50);
        deque.pushLeft(60);
        deque.pushLeft(100);

        System.out.println("\nDeque after adding more elements:");
        printDeque(deque);
        System.out.println("Size of Deque: " + deque.size());

        System.out.println();
        System.out.println("Size of Deque after all elements removed: ");
        deque.popLeft();
        deque.popLeft();
        deque.popLeft();
        deque.popLeft();
        deque.popLeft();

        printDeque(deque);
    }

    public static <T> void printDeque(Deque<T> deque)
    {
        if (deque.isEmpty())
        {
            System.out.println("Deque is empty");
            return ;
        }
        System.out.print("Deque: ");
        for (T data : deque) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
}

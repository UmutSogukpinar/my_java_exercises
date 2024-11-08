package cmpe_211_ex02;

class DoubleNode<T>
{
    T data;
    DoubleNode<T> next;
    DoubleNode<T> prev;

    public DoubleNode(T data)
    {
        this.data = data;
        next = null;
        prev = null;
    }
}

public class DoubleLinkedList<T>
{
    DoubleNode<T> head;
    DoubleNode<T> tail;
    int size;

    public DoubleLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public static <T> void insertAtStart(DoubleLinkedList<T> list, T data)
    {
        DoubleNode<T> newNode = new DoubleNode<>(data);
        if (list.size == 0)
        {
            list.head = newNode;
            list.tail = newNode;
        } else
        {
            newNode.next = list.head;
            list.head.prev = newNode;
            list.head = newNode;
        }
        list.size++;
    }

    public static <T> void insertAtEnd(DoubleLinkedList<T> list, T data)
    {
        DoubleNode<T> newNode = new DoubleNode<>(data);
        if (list.size == 0)
        {
            list.head = newNode;
            list.tail = newNode;
        }
        else
        {
            list.tail.next = newNode;
            newNode.prev = list.tail;
            list.tail = newNode;
        }
        list.size++;
    }

    public static <T> void removeFromStart(DoubleLinkedList<T> list)
    {
        if (list.size == 0)
        {
            throw new IllegalStateException("The list is empty");
        }
        else if (list.size == 1)
        {
            list.head = null;
            list.tail = null;
        }
        else
        {
            DoubleNode<T> removedNode = list.head;
            list.head = list.head.next;
            list.head.prev = null;
            removedNode.next = null;
        }
        list.size--;
    }

    public static <T> void removeFromEnd(DoubleLinkedList<T> list)
    {
        if (list.size == 0)
            throw new IllegalStateException("The list is empty");
        else if (list.size == 1)
        {
            list.head = null;
            list.tail = null;
        }
        else
        {
            DoubleNode<T> removedNode = list.tail;
            list.tail = list.tail.prev;
            list.tail.next = null;
            removedNode.prev = null;
        }
        list.size--;
    }

    public static <T> void insertBefore(DoubleLinkedList<T> list, DoubleNode<T> node, T data)
    {
        if (node == null)
        {
            throw new IllegalArgumentException("The provided node cannot be null.");
        }

        DoubleNode<T> temp = list.head;
        DoubleNode<T> newNode = new DoubleNode<>(data);

        if (temp.equals(node))
        {
            newNode.next = list.head;
            list.head.prev = newNode;
            list.head = newNode;
            list.size++;
            return;
        }

        while (temp != null)
        {
            if (temp.equals(node))
            {
                DoubleNode<T> previousNode = temp.prev;
                previousNode.next = newNode;
                newNode.prev = previousNode;
                newNode.next = temp;
                temp.prev = newNode;
                list.size++;
                return ;
            }
            temp = temp.next;
        }
        throw new IllegalArgumentException("Node not found in the list.");
    }

    public static <T> void insertAfter(DoubleLinkedList<T> list, DoubleNode<T> node, T data)
    {
        if (node == null)
            throw new IllegalArgumentException("The provided node cannot be null.");

        DoubleNode<T> temp = list.head;
        DoubleNode<T> newNode = new DoubleNode<>(data);

        while (temp != null)
        {
            if (temp.equals(node))
            {
                if (temp.equals(list.tail))
                {
                    temp.next = newNode;
                    newNode.prev = temp;
                    list.tail = newNode;
                }
                else
                {
                    DoubleNode<T> nextNode = temp.next;
                    temp.next = newNode;
                    newNode.prev = temp;
                    newNode.next = nextNode;
                    nextNode.prev = newNode;
                }
                list.size++;
                return;
            }
            temp = temp.next;
        }
        throw new IllegalArgumentException("Node not found in the list.");
    }

    public static <T> void removeTheNode(DoubleLinkedList<T> list, DoubleNode<T> node)
    {
        if (node == null)
            throw new IllegalArgumentException("The provided node cannot be null.");

        DoubleNode<T> current_node = list.head;
        DoubleNode<T> temp;

        while (current_node != null) {
            if (current_node.equals(node))
            {
                if (current_node.equals(list.head))
                {
                    list.head = list.head.next;
                    if (list.head != null)
                        list.head.prev = null;
                }
                else if (current_node.equals(list.tail))
                {
                    list.tail = list.tail.prev;
                    if (list.tail != null)
                        list.tail.next = null;
                }
                else
                {
                    current_node.prev.next = current_node.next;
                    current_node.next.prev = current_node.prev;
                }

                current_node.next = null;
                current_node.prev = null;
                list.size--;
                return ;
            }
            current_node = current_node.next;
        }
        throw new IllegalArgumentException("Node not found in the list.");
    }

}

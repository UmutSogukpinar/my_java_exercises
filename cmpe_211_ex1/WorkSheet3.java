public class WorkSheet3 {
    public static int max(Node<Integer> node) {
        int max = node.data;
        node = node.next;
        while (node != null) {
            if (max < node.data) {
                max = node.data;
            }
            node = node.next;
        }
        return (max);
    }

    public static int maxRecursive(Node<Integer> node) {

        if (node.next == null) {
            return node.data;
        }
        int maxInRest = maxRecursive(node.next);

        return Math.max(node.data, maxInRest);
    }

    public static void remove(LinkedList<String> list, String key) {
        Node<String> temp = list.getHead();

        if (temp != null && temp.data.equals(key)) {
            list.setHead(temp.next);
            temp = list.getHead();
        }

        Node<String> previous = temp;

        while (temp != null) {
            if (temp.data.equals(key)) {
                previous.next = temp.next;
            } else {
                previous = temp;
            }
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList();
        intList.add(3);
        intList.add(4);
        intList.add(12);
        intList.add(53);
        intList.add(45);

        LinkedList.LinkedListIterator iterator = intList.new LinkedListIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        System.out.printf("Max number in list is: %d\n\n", WorkSheet3.maxRecursive(intList.getHead()));

        LinkedList<String> strList = new LinkedList();
        strList.add("ali");
        strList.add("veli");
        strList.add("cenk");
        strList.add("53");
        strList.add("42");

        LinkedList.LinkedListIterator iterator2 = strList.new LinkedListIterator();

        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        System.out.println();
        System.out.println("After the remove: ");
        WorkSheet3.remove(strList, "cenk");

        LinkedList.LinkedListIterator iterator3 = strList.new LinkedListIterator();

        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }
    }
}

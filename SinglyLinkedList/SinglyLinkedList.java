public class SinglyLinkedList {
    private Node head;
    private int size;

    public int size() {
        return this.size;
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    // inserting at the begining
    public void prepend(Object data) {
        // create a new node with a data and a null pointer
        Node newNode = new Node(data, null);
        // set the pointer of the new head to be the node that was the old head
        newNode.setNext(this.head);
        // set the node to be the new head
        this.head = newNode;
        // increase the size counter
        this.size++;
    }

    // inserting at the end
    public void addLast(Object data) {
        // create a new node with a data and a null pointer
        Node newNode = new Node(data, null);
        if (this.head == null) {
            this.head = newNode;
            return;
        }

        // Node currNode = new Node(null, this.head);

        Node currNode = new Node(null, null);
        currNode.setNext(this.head);

        System.out.println("currNode" + currNode);
        for (int i = 0; i < this.size; i++) {
            currNode = currNode.getNext();
        }
        currNode.setNext(newNode);
        this.size++;
    }

    public void insertedAt(Object data, int index) {
        // check index is within the current size of the list
        if (index >= 0 && index < this.size) {
            Node header = new Node(null, this.head);
            // copy header into the new node before
            // before will be the node is front of the inserted node
            Node before = header;
            for (int i = 0; i < index; i++) {
                // set before the next node in the list
                before = before.getNext();
            }
            before.setNext(new Node(data, before.getNext()));
            // set the head of the list to be the node after header
            this.head = header.getNext();
            // increase the size counter
            this.size++;
        } else {
            System.out.println("INDEX OUT OF BOUND");
        }
    }

    public Node popFirst() {
        // only do this if the node isn't null
        if (this.head != null) {
            // create a temp node that stores the old head
            Node temp = this.head;
            // Set the new head to be the 2nd node in the list
            this.head = temp.getNext();
            // disjoin the old head from the list
            temp.setNext(null);
            // decrease the size counter
            this.size--;
            return temp;
        } else {
            return new Node(null, null);
        }
    }

    public void popAt(int index) {
        if (index >= 0 && index < this.size) {
            Node header = new Node(null, null);
            Node before = header;

            for (int i = 0; i < index; i++) {
                before = before.getNext();
            }
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.prepend(250);
        singlyLinkedList.traverse();
        singlyLinkedList.prepend(200);
        singlyLinkedList.prepend(300);
        singlyLinkedList.traverse();
        System.out.println("Inserting element at 1");
        singlyLinkedList.insertedAt(100, 1);
        singlyLinkedList.traverse();
        System.out.println("Inserting element at 2");
        singlyLinkedList.insertedAt(110, 2);
        singlyLinkedList.traverse();

        System.out.println("Inserting element at last");
        singlyLinkedList.addLast(455);
        singlyLinkedList.traverse();
    }
}

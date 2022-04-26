class LinkedList{
    class Node{
        int data;
        Node next;

        // Node class constructor
        Node(int data){this.data=data;}
    }
    Node head;

    // inserts node at the beginning of the list
    void push(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }

    // inserts node after a node passed in the method
    void insertAfter(Node prevNode, int data){
        if(prevNode==null){
            System.out.println("Previous node cannot be null!");
            return;
        }
        Node newNode=new Node(data);
        newNode.next=prevNode.next;
        prevNode.next=newNode;
    }

    // inserts node at the end of the list
    void append(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node last=head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=newNode;
        }
    }

    // calculates number of nodes of a linked list
    int lengthList(){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    // prints the linked list
    void printList(){
        Node node=head;
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
}

// main class
class Insertion{
    public static void main(String[] args) {

        // a linked list object "list"
        LinkedList list=new LinkedList();
        list.append(6);
        list.push(7);
        list.push(1);
        list.append(4);
        list.insertAfter(list.head.next, 8);
        System.out.println("Created Linked List is: ");
        list.printList();
        System.out.println();
        System.out.println("Length of the linked list: "+list.lengthList());
    }
}
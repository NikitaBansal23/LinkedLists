class DLL{
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){this.data=data;}
    }
    Node head;

    // Function : 1
    // inserts node at the front of the list
    void push(int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
        }else{
            node.next=head;
            head.prev=node;
            head=node;
        }
        printList();
    }

    // Function : 3
    // inserts a node after a given node
    void insertAfter(Node prevNode, int data){
        if(prevNode==null){
            System.out.println("Previous node after which new node needs to be inserted cannot be null!!");
            return;
        }
        Node node=new Node(data);
        if(prevNode.next==null){
            node.prev=prevNode;
            prevNode.next=node;
        }else{
            Node nextNode=prevNode.next;
            node.prev=prevNode;
            prevNode.next=node;
            node.next=nextNode;
            nextNode.prev=node;
        }
        printList();
    }

    // Function : 4
    // adda a node at the end of the list
    void append(int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
        }else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
        }
        printList();
    }

    // Function : 5
    // inserts a node before a given node
    void insertBefore(Node nextNode, int data){
        if(nextNode==null){
            System.out.println("Previous node after which new node needs to be inserted cannot be null!!");
            return;
        }
        Node node=new Node(data);
        if(nextNode==head){
            node.next=nextNode;
            nextNode.prev=node;
            head=node;
        }else{
            Node prevNode=nextNode.prev;
            prevNode.next=node;
            node.prev=prevNode;
            node.next=nextNode;
            nextNode.prev=node;
        }
        printList();
    }

    // Function : 6
    //deletes the node passed as an argument
    void deleteNode(Node node){
        if(node==null){
            System.out.println("Node to be deleted do not exist!!");
            return;
        }
        if(node.prev==null){
            head=node.next;
            head.prev=null;
            return;
        }
        if(node.next==null){
            node=node.prev;
            node.next=null;
            return;
        }
        if(node.prev!=null && node.next!=null){
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        printList();
    }

    // Function : 7
    void reverse(){
        Node prevNode=null;
        Node nextNode=null;
        Node current=head;
        while(current!=null){
            nextNode=current.next;
            current.next=prevNode;
            current.prev=nextNode;
            prevNode=current;
            current=nextNode;
        }
        head=prevNode;
        printList();
    }
    // Function : 2
    // prints the linked list (doubly)
    void printList(){
        Node node=head;
        System.out.println("\nCurrent Linked List: ");
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
}
public class AllOperationsDLL {
    public static void main(String[] args) {
        DLL list=new DLL();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.insertAfter(list.head.next.next.next, 5);
        list.append(6);
        list.insertBefore(list.head.next, 7);
        list.insertBefore(list.head, 8);
        list.deleteNode(list.head.next);
        list.reverse();
        list.insertAfter(list.head.next.next, 9);
        list.deleteNode(list.head);
    }
}

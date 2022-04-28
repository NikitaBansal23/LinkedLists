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
    
    // helper function of quickSort()
    Node partition(Node start, Node end){
        // will store the pivot node in the end
        Node nodeI=start;
        // for comparing every node with the pivot data
        Node nodeJ=start;
        int pivot=end.data;
        while(nodeJ!=end){
            if(nodeJ.data<pivot){
                int temp=nodeI.data;
                nodeI.data=nodeJ.data;
                nodeJ.data=temp;
                nodeI=nodeI.next;
            }
            nodeJ=nodeJ.next;
        }
        int temp=nodeI.data;
        nodeI.data=pivot;
        end.data=temp;
        return nodeI;
    }

    // Function : 8
    void quickSort(Node start, Node end){
        if(start==end || start==null || start==end.next){
            return;
        }
        Node pivotNode=partition(start, end);
        if(pivotNode.prev==null){
            quickSort(head.next, end);
        }else{
            quickSort(start, pivotNode.prev);
            quickSort(pivotNode.next, end);
        }
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

    // Function : 10
    // returns length(number of nodes that make up a list) of the doubly linked list
    int listLength(){
        int count=0;
        Node node=head;
        while(node!=null){
            count++;
            node=node.next;
        }
        return count;
    }

    // Function : 11
    // returns last node of the linked list
    Node lastNode(){
        Node last=head;
        while(last.next!=null){
            last=last.next;
        }
        return last;
    }

    // Function : 9
    // swap kth node from the beginning with kth node from end in a linked list(doubly)
    void swapKth(int k){
        if(k>listLength()){
            System.out.println("\nValue of k should not be greater than length of the linked list!!");
            return;
        }
        Node node1=head, node2=lastNode();
        for(int i=1;i<k;i++){
            node1=node1.next;
        }
        for(int i=1;i<k;i++){
            node2=node2.prev;
        }
        if(node1==node2){
            System.out.println("\nNodes to be swapped are same, so not swapping is needed!!");
            return;
        }

        // node previous to node1
        Node node1prev=node1.prev;
        // node after node1
        Node node1next=node1.next;
        // node previous to node2
        Node node2prev=node2.prev;
        // node after node2
        Node node2next=node2.next;
        
        node1prev.next=node2;
        node2prev.next=node1;
        node1next.prev=node2;
        node2next.prev=node1;
        node1.next=node2next;
        node1.prev=node2prev;
        node2.next=node1next;
        node2.prev=node1prev;

        // if k is 1, head will be node2 after swapping so correcting its pointer
        if(k==1){
            head=node2;
        }
        // if k is length of the linked list, head will be node1 after swapping so correcting its pointer
        if(k==listLength()){
            head=node1;
        }
        printList();
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
        System.out.println("\nBefore Quick Sort: ");
        list.printList();
        System.out.println("\nAfter Quick Sort: ");
        DLL.Node last=list.head;
        while(last.next!=null){
            last=last.next;
        }
        list.quickSort(list.head, last);
        list.printList();
        System.out.println("\nLength of the linked list: "+list.listLength());
        list.swapKth(4);
        list.swapKth(8);
        list.swapKth(3);
        list.swapKth(5);
    }
}

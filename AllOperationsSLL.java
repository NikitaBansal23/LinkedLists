import java.util.HashSet;
import java.util.Stack;

class SLL{
    class Node{
        int data;
        Node next;
        Node(int data){this.data=data;}
    }
    Node head;

    // inserts an element at the end of the list
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
    }

    // searches an element in iterative manner
    boolean searchIterative(int data){
        Node temp=head;
        while(temp!=null){
            if(temp.data==data){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    // searches an element in recursive manner
    boolean searchRecursive(Node node, int data){
        if(node==null){
            return false;
        }
        if(node.data==data){
            return true;
        }
        return searchRecursive(node.next, data);
    }

    // prints a linked list
    void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    // where n represents index and indexing starts with 0
    int getNthNode(int n){
        int count=0;
        Node node=head;
        while(node!=null){
            if(count==n){
                return node.data;
            }
            count++;
            node=node.next;
        }
        System.out.println("no node with position "+n+"!! Returning -1.");
        return -1;
    }

    // returns length of the linked list
    int lengthList(){
        int len=0;
        Node node=head;
        while(node!=null){
            len++;
            node=node.next;
        }
        return len;
    }

    // pos starts from 1
    // if a number is at x position from starting and length is l, then
    // its position from the end is l-x+1 or vice versa
    int getNthNodeFromLast(int pos){
        // gives position of the node from the beginning
        int posBeginning=lengthList()-pos+1;
        Node node=head;
        for(int i=1;node!=null;i++){
            if(i==posBeginning){
                return node.data;
            }
            node=node.next;
        }
        System.out.println("no node with position "+pos+" from end!! Returning -1.");
        return -1;
    }

    // find middle using length
    int findMiddleUsingLength(){
        int len=lengthList();
        int middle;
        if(len%2==0){
            middle=len/2;
        }else{
            middle=len/2+1;
        }
        Node node=head;
        for(int i=1;i<=middle;i++){
            if(i==middle){
                return node.data;
            }
            node=node.next;
        }
        System.out.println("No linked list exist");
        return -1;
    }

    // find middle using double pointers
    int findMiddleUsingDoublePointers(){
        if(head==null){
            System.out.println("No linked list exist");
        return -1;
        }
        Node slowPtr=head;
        Node fastPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        return slowPtr.data;
    }

    // counts numbers of times a node with a specific data occurs in the linked list
    int count(int num){
        int times=0;
        Node node=head;
        while(node!=null){
            if(node.data==num){
                times++;
            }
            node=node.next;
        }
        return times;
    }

    // counts numbers of times a node with a specific data occurs in the linked list using recursion
    int countRecursive(Node node, int num){
        if(node==null){
            return 0;
        }else{
            if(node.data==num){
                return 1+countRecursive(
                    node.next, num);
            }else{
                return countRecursive(node.next, num);
            }
        }
    }

    // Using hashset class to detect loops
    // This class contains unique elements only and if there is already a node present
    // that corresponds to the current node, then there is a loop, else no, there is not.
    boolean detectLoopUsingHashSet(){
        Node node=head;
        HashSet<Node> set=new HashSet<Node>();
        while(node!=null){
            if(set.contains(node)){
                return true;
            }else{
                set.add(node);
                node=node.next;
            }
        }
        return false;
    }

    // slowPt points to next by moving one address forward
    // while fastPt points to next by moving two addresses forward
    boolean detectLoopUsingFloydAlgo(){
        Node slowPt=head;
        Node fastPt=head;
        while(slowPt!=null && fastPt!=null && fastPt.next!=null){
            slowPt=slowPt.next;
            fastPt=fastPt.next.next;
            if(slowPt==fastPt){
                return true;
            }
        }
        return false;
    }

    int detectAndCountLoopLength(){
        Node slow_pt=head;
        Node fast_pt=head;
        Node node=null;

        // detects loop using Floyd's Cycle-Finding Algorithm
        while(slow_pt!=null && fast_pt!=null && fast_pt.next!=null){
            slow_pt=slow_pt.next;
            fast_pt=fast_pt.next.next;
            if(fast_pt==slow_pt){
                node=slow_pt;
                break;
            }
        }

        // returns count
        if(node==null){
            return 0;
        }else{
            int count=1;
            while(node.next!=node){
                count++;
                node=node.next;
            }
            return count;
        }
    }

    // checking if a linked list is a palindrome using stack and consumes O(n) space
    boolean isPalindromeUsingStack(){
        Node node=head;
        Stack<Integer> stack=new Stack<Integer>();
        while(node!=null){
            stack.push(node.data);
            node=node.next;
        }
        node=head;
        while(node!=null){
            if(stack.pop()!=node.data){
                return false;
            }
            node=node.next;
        }
        return true;
    }

    // removing duplicates from sorted linked list
    void removeDuplicateFromSortedLinkedList(){
        Node before=head;
        Node after=head.next;
        while(after!=null){
            if(before.data==after.data){
                before.next=after.next;
            }
            else{
                before=before.next;
            }
            after=after.next;
        }
    }

    // delete the entire linked list
    void clear(){
        head=null;
    }

    // removing duplicates from unsorted linked list
    void removeDuplicateFromUnsortedLinkedList(){
        Node n1=head;
        Node n2, prev;
        while(n1!=null){
            prev=n1;
            n2=n1.next;
            while(n2!=null){
                if(n1.data==n2.data){
                    prev.next=n2.next;
                }else{
                    prev=prev.next;
                }
                n2=n2.next;
            }
            n1=n1.next;
        }
    }

    // swapping nodes requires changing next pointers of the two nodes as well as their previous nodes' next pointers
    // node1's next points to node2'next
    // node2's next pointd to node1's next
    // therefore swapping of above pointers requires a temporary pointer
    // previous node of node1 points to node2
    // previous node of node2 points to node1
    // if either of the node happen to be head, then next pointer of previous node of other node is only changed
    void swapNodes(int key1, int key2){
        // if keys are same, no need to swap even if there are two nodes with the same keys
        if(key1==key2){
            return;
        }
        Node node1=head;
        Node node2=head;
        Node prev1=null;
        Node prev2=null;
        while(node1!=null){
            if(node1.data==key1){
                break;
            }else{
                prev1=node1;
                node1=node1.next;
            }
        }
        // no node corresponding to key1 exists, then return
        if(node1==null){
            return;
        }
        while(node2!=null){
            if(node2.data==key2){
                break;
            }else{
                prev2=node2;
                node2=node2.next;
            }
        }
        // no node corresponding to key2 exists, then return
        if(node2==null){
            return;
        }

        // if node1 is the head
        if(node1==head){
            Node temp=node1.next;
            node1.next=node2.next;
            node2.next=temp;
            prev2.next=node1;
            head=node2;
            return;
        }
        // if node2 is the head
        if(node2==head){
            Node temp=node2.next;
            node2.next=node1.next;
            node1.next=temp;
            prev1.next=node2;
            head=node1;
            return;
        }
        // if neither nodes are head
        prev1.next=node2;
        prev2.next=node1;
        Node temp=node1.next;
        node1.next=node2.next;
        node2.next=temp;
    }

    // swapping data of nodes pairwise
    void swapPairwise(){
        // internally calls swap() swaps data of every pair in the linked list
       swap(head);
    }
    private void swap(Node node1){
        if(node1==null || node1.next==null){
            return;
        }
        Node node2=node1.next;

        // swap logic without using third variable
        node1.data+=node2.data;
        node2.data=node1.data-node2.data;
        node1.data-=node2.data;
        swap(node2.next);
    }

    // this basically does a rotation from right to left once -> last element is being placed at first placed and becomes the head and previous head becomes the second node
    void lastBecomesFirst(){
        Node last=head;
        Node prev=null;
        if(last.next==null){
            return;
        }
        while(last.next!=null){
            prev=last;
            last=last.next;
        }
        last.next=head;
        head=last;
        prev.next=null;
    }

    SLL intersection(SLL list1, SLL list2){
        SLL list=new SLL();
        Node head1=list1.head;
        Node head2=list2.head;

        while(head1!=null && head2!=null){
            if(head1.data==head2.data){
                list.append(head1.data);
                head1=head1.next;
                head2=head2.next;
            }else if(head1.data>head2.data){
                head2=head2.next;
            }else{
                head1=head1.next;
            }
        }
        return list;
    }

    // reverses a linked list
    void reverse(){
        Node before=null;
        Node after=null;
        Node current=head;
        while(current!=null){
            // stores the element next to the current element
            after=current.next;
            // changing the next pointer of current to point to previous node
            current.next=before;
            // previous now becomes current
            before=current;
            // current now becomes after node
            current=after;
        }
        // after the loop terminates, current becomes null and before becomes the first node and is thus assigned to head node of the linked list
        head=before;
    }

    // places all even nodes in the order in the front of the list and all the other elements 
    // which are odd after them in the order they originally appear
    void segregateEvenOdd(){
        Node startEven=null;
        Node endEven=null;
        Node startOdd=null;
        Node endOdd=null;
        Node current=head;
        while(current!=null){
            if(current.data%2==0){
                if(startEven==null){
                    startEven=current;
                    endEven=current;
                }else{
                    endEven.next=current;
                    endEven=current;
                }
            }else{
                if(startOdd==null){
                    startOdd=current;
                    endOdd=current;
                }else{
                    endOdd.next=current;
                    endOdd=current;
                }
            }
            current=current.next;
        }
        if(startEven==null || startOdd==null){
            return;
        }
        endEven.next=startOdd;
        endOdd.next=null;
        head=startEven;
    }
}

// main class
public class AllOperationsSLL {
    public static void main(String[] args) {
        SLL list=new SLL();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.printList();
        System.out.println("\nReversing the linked list: ");
        list.reverse();
        list.printList();
        System.out.println("\n1 is present: "+list.searchRecursive(list.head,1));
        System.out.println("\n2 is present: "+list.searchRecursive(list.head,2));
        System.out.println("\n5 is present: "+list.searchRecursive(list.head,5));
        System.out.println("\n6 is present: "+list.searchRecursive(list.head,6));
        System.out.println("\nnode at position 4 has data "+list.getNthNode(4));
        System.out.println("\nnode at position 4 has data "+list.getNthNode(5));
        System.out.println("\nnode at position 4 from the end has data "+list.getNthNodeFromLast(4));
        System.out.println("\nmiddle of the linked list: "+list.findMiddleUsingLength());
        System.out.println("\nmiddle of the linked list: "+list.findMiddleUsingDoublePointers());
        System.out.println("\nNumber of times 2 comes in the linked list is: "+list.count(2));
        System.out.println("\nNumber of times 2 comes in the linked list is: "+list.countRecursive(list.head,6));
        System.out.println("\nThe given linked list has loops: "+list.detectLoopUsingHashSet());
        System.out.println("\nThe given linked list has loops: "+list.detectLoopUsingFloydAlgo());
        System.out.println("\nLength of loop if any: "+list.detectAndCountLoopLength());
        list.append(4);
        list.append(3);
        list.append(2);
        list.append(1);
        System.out.println("\nThe given linked list is a palindrome: "+list.isPalindromeUsingStack());
        list.printList();
        System.out.println("\nClearing the linked list");
        list.clear();
        list.append(1);
        list.append(2);
        list.append(2);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(4);
        list.printList();
        System.out.println("\nLinked list after removing duplicates: ");
        list.removeDuplicateFromSortedLinkedList();
        list.printList();
        list.clear();
        System.out.println("\nCreating new linked list after clearing it.");
        list.append(1);
        list.append(2);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(3);
        System.out.println();
        list.printList();
        System.out.println("\nLinked list after removing duplicates: ");
        list.removeDuplicateFromUnsortedLinkedList();
        list.printList();
        list.swapNodes(1, 4);
        System.out.println("\nLinked list after swapping: ");
        list.printList();
        list.swapNodes(1, 4);
        System.out.println("\nLinked list after swapping: ");
        list.printList();
        System.out.println("\nSwapping elements pairwise: ");
        list.swapPairwise();
        list.printList();
        System.out.println("\nSwapping elements pairwise: ");
        list.swapPairwise();
        list.printList();
        System.out.println("\nMoving last element to the first of the given list: ");
        list.lastBecomesFirst();
        list.printList();
        SLL list1=new SLL();
        list1.append(1);
        list1.append(2);
        list1.append(3);
        list1.append(4);
        list1.append(6);
        System.out.println("\nList1: ");
        list1.printList();

        SLL list2=new SLL();
        list2.append(2);
        list2.append(4);
        list2.append(6);
        list2.append(8);
        System.out.println("\nList2: ");
        list2.printList();

        SLL listIntersection;
        listIntersection=list.intersection(list1, list2);
        System.out.println("\nIntersetion of List1 and list2: ");
        listIntersection.printList();

    }
}

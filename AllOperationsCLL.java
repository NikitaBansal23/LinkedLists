class CLL{
    class Node{
        int data;
        Node next;
        Node(int data){this.data=data;}
    }
    // pointer to the end of the linked list which is connected to the first node to make the linked list circular
    Node last;

    // function to add a node at the beginning of the CLL
    void addBegin(int data){
        Node node=new Node(data);
        if(last==null){
            last=node;
            last.next=last;
        }else{
            node.next=last.next;
            last.next=node;
        }
    }

    // function to add a node at the end of the CLL 
    void addEnd(int data){
        Node node=new Node(data);
        if(last==null){
            last=node;
            last.next=last;
        }else{
            node.next=last.next;
            last.next=node;
            last=node;
        }
    }

    // function to add a node after an existing node
    void addAfter(Node prev, int data){
        if(prev==null){
            return;
        }
        Node temp=last;
        do{
            if(temp==prev){
                Node node=new Node(data);
                node.next=temp.next;
                temp.next=node;
                if(temp==last){
                    last=node;
                }
                break;
            }else{
                temp=temp.next;
            }
        }while(temp!=last);
    }

    // function to print the CLL
    void printCLL(){
        // stores address of the first node
        Node temp=last.next;
        do{
            System.out.print(temp.data+" ");
            temp=temp.next;
        }while(temp!=last.next);
    }

    // function to store a given node
    void deleteNode(Node node){
        if(node==null) return;
        Node temp=last;
        do{
            if(temp.next==node){
                temp.next=node.next;
                if(node==last){
                    last=temp;
                }
                break;
            }
            temp=temp.next;
        }while(temp!=last);
    }

    // function to add a node in sorted order in a sorted CLL
    void sortedInsert(int data){
        Node node=new Node(data);
        if(last.next.data>=node.data){
            node.next=last.next;
            last.next=node;
            return;
        }else if(last.data<=node.data){
            node.next=last.next;
            last.next=node;
            last=node;
        }else{
            Node temp=last.next;
            do{
                if(temp.data<=node.data && node.data<=temp.next.data){
                    node.next=temp.next;
                    temp.next=node;
                    return;
                }
                temp=temp.next;
            }while(temp!=last.next);
        }
    }

    // function to check of the list is circular or not
    boolean isCircular(){
        if(last==null) return true;
        // obtaining first node with the help of last node
        Node first=last.next;
        while(first!=null && first!=last) first=first.next;
        // if first(obtained from last itself) becomes last after the above while loop, it means that linked list is circular
        // otherwise not
        return (first==last);
    }

    // function that returns total number of nodes that make up the CLL
    int countNodes(){
        int count=0;
        Node temp=last;
        if(temp==null) return count;
        do{
            count++;
            temp=temp.next;
        }while(temp!=last);
        return count;
    }

    // function to exchange first and last nodes
    void exchangeFirstAndLast(){
        if(last==null) return;
        // storing pointer to previous node to the last
        Node prev=last;
        while(prev.next!=last){
            prev=prev.next;
        }
        // storing pointer to first node
        Node first=last.next;
        // chaning next pointer of last to next pointer of first
        last.next=first.next;
        // changing next pointer of first to point to last, since it will becomes after it.
        first.next=last;
        // chaning next pointer of previous node to last to point to first which is now after prev instead of last
        prev.next=first;
        // first becomes last
        last=first;
    }
}

// driver class
public class AllOperationsCLL {
    public static void main(String[] args) {
        CLL list=new CLL();
        list.addBegin(1);
        list.addBegin(3);
        list.addEnd(4);
        list.addEnd(5);
        list.addAfter(list.last.next, 2);
        list.printCLL();
        list.deleteNode(list.last.next);
        System.out.println();
        list.printCLL();
        list.deleteNode(list.last);
        System.out.println();
        list.printCLL();
        list.deleteNode(list.last.next.next);
        System.out.println();
        list.printCLL();
        list.sortedInsert(1);
        System.out.println();
        list.printCLL();
        System.out.println("\nIs list circular?: "+list.isCircular());
        System.out.println("\nNumber of nodes in the CLL: "+list.countNodes());
        list.exchangeFirstAndLast();
        System.out.println("\nCLL after exchanging first and last nodes: ");
        System.out.println();
        list.printCLL();
    }
}

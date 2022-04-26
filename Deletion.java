class SinglyLinkedList{
    class Node{
        int data;
        Node next;
        Node(int data){this.data=data;}
    }
    Node head;
    void push(int data){
        Node node=new Node(data);
        node.next=head;
        head=node;
    }

    // deletes a node by the data value or the key value
    void deleteByKey(int data){
        Node temp=head;
        if(temp.data==data){
            head=temp.next;
            return;
        }
        Node prev=null;
        while(temp!=null && temp.data!=data){
            prev=temp;
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("No node with the said key!");
            return;
        }
        prev.next=temp.next;
    }

    // deletes node by position( where first node is assumed to be at position 0)
    // not working correctly
    void deleteByPosition(int position){
        if(position==0 && head!=null){
            head=head.next;
            return;
        }
        Node prev=head;
        Node node=prev.next;
        for(int i=1;node!=null;i++){
            if(i==position){
                prev.next=node.next;
                return;
            }
            node=node.next;
            prev=prev.next;
        }
        if(node==null){
            System.out.println("No node with the said key!");
            return;
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

    // deletes entire linked list
    void deleteList(){
        head=null;
    }

    // prints the entire linked list
    void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }
}

// main class
public class Deletion {
    public static void main(String[] args) {
        SinglyLinkedList list=new SinglyLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        
        list.deleteByPosition(1);
        list.printList();
    }
}

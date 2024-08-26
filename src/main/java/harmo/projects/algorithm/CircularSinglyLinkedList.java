package harmo.projects.algorithm;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private static class ListNode{

        private ListNode next;
        private int data;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public CircularSinglyLinkedList(){
        last = null;
        length = 0;
    }
    public int getLength(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }
    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.insertLastInCircularLinkedList(10);
        list.insertLastInCircularLinkedList(20);
        list.insertLastInCircularLinkedList(30);
        list.insertLastInCircularLinkedList(40);
        list.insertLastInCircularLinkedList(50);

        System.out.println("Delete(Last): " + list.deleteLast());
        list.displayCircularLinkedList();
        System.out.println("Delete(Last): " + list.deleteLast());
        list.displayCircularLinkedList();
    }

    private int deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Circular singly linked list is empty");
        }
        ListNode temp = last.next;
        int result = temp.data;
        if(last.next == last){
            last = null;
        }else {
            last.next = temp.next;
//            temp.next = null;
        }
        length --;
        return result;
    }

    private int deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException("Circular singly linked list is empty");
        }
        //Getting the previous element before the last(BeforeLast variable)
        ListNode beforeLast = last.next;
        while(beforeLast.next != last){
            beforeLast = beforeLast.next;
        }
        //Result is the current element to be removed.
        int result = last.data;
        if(last.next == last){
            last = null;
        }else {
            beforeLast.next = last.next;
            //Setting the new last to the element before the removed one
            last = beforeLast;
        }
        length--;
        return result;
    }

    public void insertLastInCircularLinkedList(int data){
        ListNode temp = new ListNode(data);
        if(last == null){
            last = temp;
            //establishing a cyclic behavior to the list.
            last.next = last;
        }else {
            temp.next  = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    public void insertFirstInCircularLinkedList(int data){
        ListNode temp = new ListNode(data);
        if(last == null){
            last = temp;
        }else {
            //last.next is the first node.
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }


    public void displayCircularLinkedList(){
        if(last == null){
            return;
        }
        ListNode first = last.next;
        while(first != last){
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.print(first.data);
        System.out.println();
    }
    public void createCircularLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth; //keeping track of the last.
    }

}

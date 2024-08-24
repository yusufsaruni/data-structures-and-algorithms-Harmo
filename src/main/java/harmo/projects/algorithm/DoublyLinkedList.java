package harmo.projects.algorithm;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;
    private static class ListNode{
        int data;
        ListNode next;
        ListNode prev;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;

    }
    public boolean isEmpty(){
        return  length == 0;
    }
    public int getLength(){
        return length;
    }
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.insertLast(1);
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);

        list.displayForward();
        System.out.println("Deleted(last): " +list.deleteLastNode().data);
        list.displayForward();
        System.out.println("Deleted(last): " +list.deleteLastNode().data);
        System.out.println("New Length: " + list.getLength());
        list.displayForward();


    }
    //deleting a specific element in double linkedList: to be researched.

    private ListNode deleteLastNode(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if(head == tail){
            head = null;
        }else {
            //breaking the pointer to this tail(referencing to the previous node first)
            tail.prev.next = null;
        }
        tail = tail.prev;
        //breaking the reference from this tail( pointing to the previous)
        temp.prev = null;
        length--;
        return temp;
    }

    private ListNode deleteFirstNode(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp   = head;
        if(head == tail){
            tail = null;
        }else {
            //breaking the pointer to this head(referencing the next node first)
            head.next.prev = null;
        }
        head = head.next;
        //breaking the pointer to the next node so that this node can be free.
        temp.next = null;
        length--;
        return temp;
    }

    private void insertFirst(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            tail = newNode;
        }else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }
    private void displayForward(){
        if(head == null){
            return;
        }

        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private void displayBackward(){
        if(tail == null){
            return;
        }

        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    private void insertLast(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            head = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length ++;
    }
}

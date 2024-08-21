package harmo.projects.algorithm;


import java.util.Objects;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private final int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertLast(7);
        list.insertLast(4);
        list.insertLast(9);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertLast(5);
        list2.insertLast(6);

        SinglyLinkedList sum = new SinglyLinkedList();
        sum.head = sum.addLists(list.head, list2.head);
        sum.display();
    }

    private ListNode addLists(ListNode a, ListNode b){

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0; // to store the carried number for addition
        while(a != null || b != null){
            int x = a != null ? a.data : 0;
            int y = b != null ? b.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if(a != null) a = a.next;
            if(b != null) b = b.next;
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }
    private static  ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;//to add the elements;
        while(a != null && b != null) {
            //this if statements is to ensure that we are adding
            // only the smallest  data.
            if(a.data < b.data) {
                tail.next = a;
                a = a.next;
            }else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a == null){
            tail.next = b;
        }else{
            tail.next = a;
        }
        return dummy.next;
    }

    private void removeLoop(){

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                removeLoop(slow);
            }
        }
    }
    private void removeLoop(ListNode slow){
        ListNode temp = head;
        while(temp.next != slow.next){
            temp = temp.next;
            slow = slow.next;
        }
        slow.next = null;
    }

    private void createALoopInLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head = first;
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }

    private boolean containsLoop(){

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
    private ListNode startNodeInALoop(){

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return getStartingNode(slow);
            }
        }
        return null;
    }

    private ListNode getStartingNode(ListNode slow) {

        ListNode temp = head;
        while (slow != temp){
            slow = slow.next;
            temp = temp.next;
        }
        return temp;//starting node of the loop.
    }

    private void deleteNode(int keyValue){

        ListNode current = head;
        ListNode temp = null;
        //in this if condition, the current is still the head
        if(current != null && current.data == keyValue){
            head = current.next;
            return;
        }

        while(current != null && current.data != keyValue){
            temp = current;
            current = current.next;
        }
        if(current == null){
            return;
        }
        temp.next = current.next;
    }

    private ListNode insertInSortedList(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;

        while(current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        assert temp != null;
        temp.next = newNode;
        return head;
    }

    private void removeDuplicates() {
        if(Objects.isNull(head)) {
            return;
        }
        ListNode current = head;
        while(current.next != null) {
            if(current.data == current.next.data) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
    }

    private ListNode getNthFromEnd(int n){
        if(head == null){
            return null;
        }
        if(n <= 0){
            throw new IllegalArgumentException("Invalid value: n ="+
                    n);
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;

        while(count < n){
            if(refPtr == null){
                throw new IllegalArgumentException(n+ " is greater than" +
                        " the number of nodes in the list");
            }
            refPtr = refPtr.next;
            count ++;
        }

        while(refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    private ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private boolean search(ListNode head,int searchKey){
        if(head == null) return false;
        ListNode current = head;
        while(current != null){
            if(current.data == searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    private void deleteAt(int position){
        if(position == 1){
            head = head.next;// if we are deleting the first node
            //we simply assign the head to the next node.
        }else {
            ListNode previous = head;
            int count = 1;
            while(count < position - 1){
                //this while loop iterate to the previous element
                // just before the targeted node.
                previous = previous.next;
                count ++;
            }
            ListNode toBeDeleted = previous.next;
            previous.next = toBeDeleted.next;
        }
    }

    private ListNode deleteLast(){
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;

        while(current.next != null){
            previous = current;
            current = current.next;
        }
        /*
        After the loop, the previous will be second last and the current
        will be the last node.
        To break the chain, we just set , previous(second last).next
        which in this case will be current to null the return.
         */
        previous.next = null;
        return current;



    }
    private ListNode deleteFirst(){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    public void insertAt(int value, int position){
        ListNode node = new ListNode(value);
        if(position == 1){
            node.next = head;
            head = node;
        }else {
            //getting the node just before the expected insertion pos
            ListNode previous = head;
            int count = 1;
            //iterating up to just the position - 1
            while(count < position - 1){
                previous = previous.next;
                count ++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
    private void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
    }
    public int getLength(){
        if(head == null){
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current != null){
            count ++;
            current = current.next;
        }
        return count;
    }
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }
}

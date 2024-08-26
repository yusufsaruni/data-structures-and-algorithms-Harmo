package harmo.projects.linearStructures;

//FIFO(First In First Out)
public class Queue {

    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }
    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("First : "+ q.first());
        System.out.println("Last : "+ q.last());
        q.printQueue();
    }

    public void enqueue(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            front = newNode;
        }else{
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    public int first(){
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return front.data;
    }
    public int last(){
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return rear.data;
    }
    public int dequeue(){
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int data = front.data;
        front = front.next;
        //The if statement handles a case where the removal makes the
        // queue empty.
        if(front == null){
            rear = null;
        }
        length --;
        return data;
    }

    public void printQueue(){
        if (isEmpty()) {
            return;
        }
        ListNode current = front;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

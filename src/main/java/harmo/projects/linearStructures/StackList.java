package harmo.projects.linearStructures;

import java.util.EmptyStackException;

// implementation with a LinkedList.
public class StackList {

    private ListNode top;
    private int length;
    private static class ListNode {

        private final int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public StackList() {
        top = null;
        length = 0;
    }

    public int length() {
        return length;
    }
    public boolean isEmpty() {
        return length == 0;
    }

    public static void main(String[] args) {
        StackList stackList = new StackList();
        stackList.push(1);
        stackList.push(2);
        stackList.push(3);

        System.out.println("Last added: " + stackList.peek());
        System.out.println("Removed: "+stackList.pop());
        System.out.println("Last added: " + stackList.peek());
        System.out.println("New Length: " + stackList.length());
    }

    public void push(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = top;
        top = newNode;
        length++;
    }

    public int peek(){
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return  result;
    }
}

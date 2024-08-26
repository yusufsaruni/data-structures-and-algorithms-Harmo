package harmo.projects.linearStructures;

//LIFO(Last In Last Out)
public class StackArray {

    private int top;
    private int[] array;
    public StackArray(int capacity) {
        top = -1;
        array = new int[capacity];
    }

    public StackArray(){
        this(10);
    }
    public boolean isFull(){
        return size() == array.length;
    }
    public int size(){
        return top + 1;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public static void main(String[] args) {
        StackArray stackArray = new StackArray(10);
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);
        System.out.println("Peek: " + stackArray.peek());
        System.out.println("Pop: " + stackArray.pop());
        System.out.println("Peek: " + stackArray.peek());
    }

    public void push(int value) {
        if(isFull()){
            System.out.println("Stack is full");
            throw new RuntimeException("Stack is full");
        }
        top ++;
        array[top] = value;
    }
    public int pop() {
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        int data = array[top];
        top --;
        return data;
    }
    public int peek() {
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }
}

package stack;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(11);
        System.out.println("Before Pushing: ");
        myStack.printStack();
        myStack.push(7);
        myStack.push(4);
        myStack.push(9);
        myStack.getTop();
        myStack.getHeight();
        System.out.println("After Pushing: ");
        myStack.printStack();
        myStack.pop();
        System.out.println("After Poping: ");
        myStack.printStack();
    }
}

package LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;

        Node(int value){
            this.value=value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList(){
        Node temp = head;
        while(temp!= null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead(){
        System.out.println("Head: "+ head.value);
    }
    public void getTail(){
        System.out.println("Tail: "+ tail.value);
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

    public void append(int value){
        Node appendNode = new Node(value);
        if(length==0){
            head = appendNode;
            tail = appendNode;
        }
        else {
            tail.next = appendNode;
            tail = appendNode;
        }
        length++;
    }
    public Node removeLast(){
        if(length==0){
            return null;
        }
        Node temp = head;
        Node pre = tail;
        while (temp.next!=null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next=null;
        length--;
        if (length==0){
            head=null;
            tail=null;
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if (length==0){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;

        }
        length++;
    }
    public Node removeFirst(){
        if (length==0){
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length==0){
            tail.next=null;
        }
        return temp;
    }
    public Node get(int index){
        if (index<0 || index>=length){
            return null;
        }
        Node temp = head;
        for(int i = 0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }
    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp!=null){
            temp.value=value;
            return true;
        }
        return false;
    }
    public boolean insert(int index, int value){
        if(index<0 || index>length){
            return false;
        }
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }
    public Node remove(int index){
        if(index<0 || index>=length) return null;
        if (index==0) return removeFirst();
        if (index==length-1) return removeLast();
        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    public void partitionList(int x) {
        // Step 1: Check for an empty list.
        // If the list is empty, there is nothing
        // to partition, so we exit the method.
        if (head == null) return;

        // Step 2: Create two dummy nodes.
        // We create dummy nodes to act as the
        // starting points for our two new lists.
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        // Step 3: Initialize list pointers.
        // We'll use 'prev1' and 'prev2' to keep track
        // of the last nodes in our two new lists.
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        // Step 4: Start at the head node.
        // We initialize 'current' to the head of the list.
        // This node will move through each node in the list.
        Node current = head;

        // Step 5: Begin loop to go through list.
        // We'll continue until we reach the end of the list.
        while (current != null) {

            // Step 6: Partition nodes based on value.
            // We have an if-else block to categorize the current
            // node based on its value in comparison to 'x'.

            // Condition: If the value is less than 'x'
            if (current.value < x) {

                // Step 6.1: Add to first list.
                // We set the 'next' pointer of the node
                // referenced by 'prev1' to the current node.
                // This effectively adds 'current' to the end
                // of the first list (list with smaller values).
                prev1.next = current;

                // Step 6.2: Update 'prev1'.
                // We move 'prev1' so that it now points to
                // 'current'. This prepares 'prev1' for the
                // next addition to the first list.
                prev1 = current;

                // Condition: If the value is greater than or equal to 'x'
            } else {

                // Step 6.3: Add to second list.
                // We set the 'next' pointer of the node
                // referenced by 'prev2' to the current node.
                // This effectively adds 'current' to the end
                // of the second list (list with larger values).
                prev2.next = current;

                // Step 6.4: Update 'prev2'.
                // We move 'prev2' so that it now points to
                // 'current'. This prepares 'prev2' for the
                // next addition to the second list.
                prev2 = current;
            }

        }

        // Step 8: Mark end of the second list.
        // We set the next pointer of the last node
        // in the second list to null.
        prev2.next = null;

        // Step 9: Connect the two lists.
        // We connect the end of the first list
        // to the start of the second list.
        prev1.next = dummy2.next;

        // Step 10: Update the head pointer.
        // The head of the list should now point
        // to the start of the first partitioned list.
        head = dummy1.next;
    }
    public void removeDuplicates(){
        Node temp = head;
        Node prev = head.next;
        for (int i = 0; i< length; i++){
            for(int j = 0; j < length-i; j++){
                if(temp==prev){
                    prev.next = prev.next.next;
                }
                prev = prev.next;
            }
            temp = temp.next;
            prev = temp.next;
        }
    }
}

package A4;
class Node
{
    static Node head;
    static Node tail;
    protected int regd_no;
    protected float mark;
    protected Node next;
    Node(int regd_no, float mark){
        this.regd_no = regd_no;
        this.mark = mark;
    }
}


public class LinkedList {
    //Create
    public static void create(Node start){
        Node.head = start;
        Node.tail=start;
        Node.head.next = Node.tail;
        Node.tail.next = null;
    }

    //Insert at Beginning
    public static Node InsBeg(Node start){
        if(Node.head == null){
            create(start);
        }
        else{
            start.next = Node.head;
            Node.head = start;
        }
        return Node.head;
    }
    //Insert at the End
    public static Node InsEnd(Node temp){
        if(Node.head == null){
            Node.head = temp;
        }
        else{
            Node.tail.next = temp;
        }
        Node.tail = temp;
        return Node.tail;
    }
    //Size
    public static int count(Node start){
        int count = 0;
        while(start != null){
            count++;
            start = start.next;
        }
        return count;
    }
    // Insert At Any Index
    public static Node InsAny(int index, Node start, Node add){
        Node temp = Node.head;
        if(index < 0 || index > count(start)) {
            System.out.println("Wrong Input");
        }
        else if(index == count(start)){
            InsEnd(add);
        }
        else if (index == 0) {
            InsBeg(add);
        }
        else {
            for (int i = 1 ; i <= index-1 ;i++){
                temp = temp.next;
            }
            add.next = temp.next;
            temp.next = add;
        }
        return add;
    }
    public static Node DelBeg(){
        Node.head = Node.head.next;
        return Node.head;
    }
//    public static Node DelEnd(Node start){
//
//    }



    //Display
    public static void display(Node Start){
        Node temp = Start;
        while(temp != null){
            System.out.println("Registration Number: " +temp.regd_no);
            System.out.println("Marks: "+ temp.mark);
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node S1 = new Node(221,72.5f);
        Node S2 = new Node(220,75.3f);
        Node S3 = new Node(223, 80);
        Node S4 = new Node(222,96);
        create(S1);
        //display(S1);
        InsBeg(S2);
        //display(S2);
        InsEnd(S3);
        //display(S2);
        InsAny(3,S2,S4);
        DelBeg();
        display(S2);
        System.out.println(count(S2));


    }
}

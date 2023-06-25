import java.util.Scanner;
class Node {
    protected int regd_no;
    protected float mark;
    protected Node next;

    Node(int regd_no, float mark) {
        this.regd_no = regd_no;
        this.mark = mark;
    }

}
class Implement {
    Node head;
    Node tail;
    void create(int regd_no, float mark) {
        Node temp = new Node(regd_no, mark);
        head = temp;
        tail = temp;
        head.next = tail;
        tail.next = null;
    }
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Registration Number: " + temp.regd_no);
            System.out.println("Marks: " + temp.mark);
            temp = temp.next;
        }
        System.out.println();
    }
    int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    void insertAtBeginning(int regd_no, float mark) {
        Node temp = new Node(regd_no, mark);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }
    void insertAtEnd(int regd_no, float mark) {
        Node temp = new Node(regd_no, mark);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
    }
    void insertAt(int index, int regd_no, float mark) {
        Node t = new Node(regd_no, mark);
        Node temp = head;
        if (index < 0 || index > size()) {
            System.out.println("Wrong Input");
        } else if (index == 0) {
            insertAtBeginning(regd_no, mark);
        } else if (index == size()) {
            insertAtEnd(regd_no, mark);
        } else {
            for (int i = 1; i <= index - 1; i++) {
                temp = temp.next;
            }
            t.next = temp.next;
            temp.next = t;
        }
    }
    void search(int index) {
        if (index < 0 || index > size()) {
            System.out.println("Wrong Input");
        } else {
            Node temp = head;
            for (int i = 1; i <= index; i++) {
                temp = temp.next;
            }
            System.out.println("Registration Number: " + temp.regd_no);
            System.out.println("Marks: " + temp.mark);
        }
    }
    void DeleteAtBeginning() {
        if (head == null)
            System.out.println("Linked List is Empty!");
        else {
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
    }
    void DeleteAtEnd() {
        if (head == null)
            System.out.println("LL is Empty!");
        else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;

        }
    }
    void DeleteAtAny(int index) {
        Node temp = head;
        if (head == null)
            System.out.println("LL is Empty!");
        else if (index == 0) {
            DeleteAtBeginning();
        } else if (index == size()) {
            DeleteAtEnd();
        } else {
            for (int i = 1; i <= index - 1; i++) {
                temp = temp.next;
            }
            Node q = temp.next;
            temp.next = q.next;
            q.next = null;
        }
    }
    void reverse() {
        if (head == null || head.next == null)
            return;
        else {
            Node PrevNode = head;
            Node CurrNode = head.next;

            while (CurrNode != null) {
                Node NextNode = CurrNode.next;
                CurrNode.next = PrevNode;
                PrevNode = CurrNode;
                CurrNode = NextNode;
            }
            head.next = null;
            head = PrevNode;
        }
    }
    void sort() {
        Node start = head;
        if (start == null)
            System.out.println("Linked List is empty... ");
        else if (start.next == null)
            System.out.println("Linked list is sorted...");
        else {
            boolean swap;
            Node temp;
            Node lastNode = null;
            do {
                swap = false;
                temp = start;
                while (temp.next != lastNode) {
                    if (temp.mark < temp.next.mark) {
                        int tempRegdNo = temp.regd_no;
                        float tempMark = temp.mark;
                        temp.regd_no = temp.next.regd_no;
                        temp.mark = temp.next.mark;
                        temp.next.regd_no = tempRegdNo;
                        temp.next.mark = tempMark;
                        swap = true;
                    }
                    temp = temp.next;
                }
                lastNode = temp;
            }
            while (swap);
            System.out.println("Linked list sorted according to marks in Ascending order...");
        }
    }
}
public class LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Implement LL=new Implement();
        while (true){
            System.out.println("____MENU____");
            System.out.println("0:Exit");
            System.out.println("1:Creation");
            System.out.println("2:Display");
            System.out.println("3:Insert at beginning");
            System.out.println("4:Insert at end");
            System.out.println("5:Insert at any position");
            System.out.println("6:Delete from beginning");
            System.out.println("7:Delete from end");
            System.out.println("8:Delete from any position");
            System.out.println("9:Count");
            System.out.println("10.Reverse");
            System.out.println("11.Search");
            System.out.println("12.Sort");
            System.out.println("ENTER THE CHOICE----->>>>");
            int choice=sc.nextInt();
            switch (choice){
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Enter Regd No: ");
                    int r=sc.nextInt();
                    System.out.println("Enter marks: ");
                    float m= sc.nextFloat();
                    LL.create(r,m);
                    break;
                case 2:
                    LL.display();
                    break;
                case 3:
                    System.out.println("Enter Regd No: ");
                    int r1=sc.nextInt();
                    System.out.println("Enter marks: ");
                    float m1= sc.nextFloat();
                    LL.insertAtBeginning(r1,m1);
                    break;
                case 4:
                    System.out.println("Enter Regd No: ");
                    int r2=sc.nextInt();
                    System.out.println("Enter marks: ");
                    float m2= sc.nextFloat();
                    LL.insertAtEnd(r2,m2);
                    break;
                case 5:
                    System.out.println("Enter Regd No: ");
                    int r4=sc.nextInt();
                    System.out.println("Enter marks: ");
                    float m4= sc.nextFloat();
                    System.out.println("Which index?? ");
                    int i=sc.nextInt();
                    LL.insertAt(i,r4,m4);
                    break;
                case 6:
                    LL.DeleteAtBeginning();
                    break;
                case 7:
                    LL.DeleteAtEnd();
                    break;
                case 8:
                    System.out.println("Enter the index: ");
                    int ind=sc.nextInt();
                    LL.DeleteAtAny(ind);
                    break;
                case 9:
                    System.out.println("The number of nodes is: "+LL.size());
                    break;
                case 10:
                    LL.reverse();
                    break;
                case 11:
                    System.out.println("Enter the index: ");
                    int inx=sc.nextInt();
                    LL.search(inx);
                    break;
                case 12:
                    LL.sort();
                    LL.display();
                    break;
            }
        }
    }
}
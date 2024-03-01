///single linked list

import java.util.Scanner;

class single {
    int data;
    single next;

    single(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListOperations {
    static single head;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 9) {

            System.out.println("\nChoose one option from the following list ...");

            System.out.println("\n1.Insert in beginning\n2.Insert at last\n3.Insert at any random location" +
                    "\n4.Delete from Beginning\n5.Delete from last\n6.Delete node after specified location" +
                    "\n7.Search for an element\n8.Show\n9.Exit\n");
            System.out.println("Enter your choice?");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    begInsert();
                    break;
                case 2:
                    lastInsert();
                    break;
                case 3:
                    randomInsert();
                    break;
                case 4:
                    beginDelete();
                    break;
                case 5:
                    lastDelete();
                    break;
                case 6:
                    randomDelete();
                    break;
                case 7:
                    search();
                    break;
                case 8:
                    display();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid choice..");
            }
        }
        scanner.close();
    }

    static void begInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value:");
        int item = scanner.nextInt();
        single newNode = new single(item);
        newNode.next = head;
        head = newNode;
        System.out.println("Node inserted");
    }

    static void lastInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value:");
        int item = scanner.nextInt();
        single newNode = new single(item);
        if (head == null) {
            head = newNode;
            System.out.println("Node inserted");
            return;
        }
        single temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Node inserted");
    }

    static void randomInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value:");
        int item = scanner.nextInt();
        single newNode = new single(item);
        System.out.println("Location to insegrt:");
        int loc = scanner.nextInt();
        single temp = head;
        for (int i = 1; i < loc; i++) {
            if (temp == null) {
                System.out.println("Can't insert");
                return;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Node inserted");
    }

    static void beginDelete() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        single temp = head;
        head = temp.next;
        temp = null;
        System.out.println("Node deleted from the beginning");
    }

    static void lastDelete() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            System.out.println("Only node of the list deleted");
            return;
        }
        single temp = head;
        single prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp = null;
        System.out.println("Deleted Node from the last");
    }

    static void randomDelete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the location of the node after which you want to perform deletion:");
        int loc = scanner.nextInt();
        single temp = head;
        single prev = null;
        for (int i = 1; i <= loc; i++) {
            if (temp == null) {
                System.out.println("Can't delete");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        temp = null;
        System.out.println("Deleted node " + loc);
    }

    static void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item to search:");
        int item = scanner.nextInt();
        single temp = head;
        int position = 0;
        boolean found = false;
        while (temp != null) {
            position++;
            if (temp.data == item) {
                System.out.println("Item found at location " + position);
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found");
        }
    }

    static void display() {
        single temp = head;
        if (temp == null) {
            System.out.println("Nothing to print");
            return;
        }
        System.out.println("\nPrinting values:");
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}


//double linked list


class doubly {
    doubly prev;
    doubly next;
    int data;

    doubly(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedListOperations {
    static doubly head;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 9) {

            System.out.println("\nChoose one option from the following list ...");

            System.out.println("\n1.Insert in beginning\n2.Insert at last\n3.Insert at any random location" +
                    "\n4.Delete from Beginning\n5.Delete from last\n6.Delete the node after the given data" +
                    "\n7.Search\n8.Show\n9.Exit\n");
            System.out.println("Enter your choice?");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insertionBeginning();
                    break;
                case 2:
                    insertionLast();
                    break;
                case 3:
                    insertionSpecified();
                    break;
                case 4:
                    deletionBeginning();
                    break;
                case 5:
                    deletionLast();
                    break;
                case 6:
                    deletionSpecified();
                    break;
                case 7:
                    search();
                    break;
                case 8:
                    display();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid choice..");
            }
        }
        scanner.close();
    }

    static void insertionBeginning() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Item value:");
        int item = scanner.nextInt();
        doubly newNode = new doubly(item);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Node inserted");
    }

    static void insertionLast() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value:");
        int item = scanner.nextInt();
        doubly newNode = new doubly(item);
        if (head == null) {
            head = newNode;
        } else {
            doubly temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        System.out.println("Node inserted");
    }

    static void insertionSpecified() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value:");
        int item = scanner.nextInt();
        System.out.println("Enter the location:");
        int loc = scanner.nextInt();
        doubly newNode = new doubly(item);
        if (head == null) {
            head = newNode;
        } else {
            doubly temp = head;
            for (int i = 1; i < loc - 1; i++) {
                temp = temp.next;
                if (temp == null) {
                    System.out.println("Location not found");
                    return;
                }
            }
            newNode.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        System.out.println("Node inserted");
    }

    static void deletionBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Node deleted from the beginning");
    }

    static void deletionLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            System.out.println("Node deleted from the last");
            return;
        }
        doubly temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        System.out.println("Node deleted from the last");
    }

    static void deletionSpecified() {
        Scanner scanner = new Scanner(System.in);
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Enter the data after which the node is to be deleted:");
        int val = scanner.nextInt();
        doubly temp = head;
        while (temp != null && temp.data != val) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Node not found or can't delete");
            return;
        }
        doubly nodeToDelete = temp.next;
        temp.next = nodeToDelete.next;
        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = temp;
        }
        System.out.println("Node deleted");
    }

    static void search() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item to search:");
        int item = scanner.nextInt();
        doubly temp = head;
        int position = 0;
        boolean found = false;
        while (temp != null) {
            position++;
            if (temp.data == item) {
                System.out.println("Item found at location " + position);
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found");
        }
    }

    static void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("\nPrinting values:");
        doubly temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}


//circular linked list
class circular {
    int data;
    circular next;

    circular(int data) {
        this.data = data;
        this.next = null;
    }
}

 class CircularLinkedList {
    static circular head;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 7) {

            System.out.println("\nChoose one option from the following list ...");

            System.out.println("\n1.Insert in beginning\n2.Insert at last\n3.Delete from Beginning" +
                    "\n4.Delete from last\n5.Search for an element\n6.Show\n7.Exit\n");
            System.out.println("Enter your choice?");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insertionBeginning();
                    break;
                case 2:
                    insertionLast();
                    break;
                case 3:
                    beginDelete();
                    break;
                case 4:
                    lastDelete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    display();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid choice..");
            }
        }
        scanner.close();
    }

    static void insertionBeginning() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the node data:");
        int item = scanner.nextInt();
        circular newNode = new circular(item);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            circular temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        System.out.println("Node inserted");
    }

    static void insertionLast() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the node data:");
        int item = scanner.nextInt();
        circular newNode = new circular(item);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            circular temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Node inserted");
    }

    static void beginDelete() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            circular temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
        }
        System.out.println("Node deleted from the beginning");
    }

    static void lastDelete() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            circular temp = head;
            circular prev = null;
            while (temp.next != head) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = head;
        }
        System.out.println("Node deleted from the last");
    }

    static void search() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item to search:");
        int item = scanner.nextInt();
        circular temp = head;
        int position = 0;
        boolean found = false;
        do {
            position++;
            if (temp.data == item) {
                System.out.println("Item found at location " + position);
                found = true;
                break;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("Item not found");
        }
    }

    static void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("\nPrinting values:");
        circular temp = head;
        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (temp != head);
    }
}
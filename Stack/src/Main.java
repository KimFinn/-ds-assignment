import java.util.Scanner;
class Stack {
    int top;
    int maxsize = 10;
    int arr[] = new int[maxsize];

    boolean isempty() {
        return (top == -1);
    }

    boolean topStack() {
      return(  top <= maxsize - 1 );
    }

    boolean push(Scanner scanner) {
        if (top <= maxsize - 1) {
            System.out.println("Stack is overflow!!");
            return false;
        } else {
            System.out.println("Enter value:");
            int value = scanner.nextInt();
            top++;
            arr[top] = value;
            System.out.println("item pushed");
            return true;
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is underflow!!");

        } else {
            System.out.println("Deleted element");
            top--;
            System.out.println("Item popped");

        }
    }

    public void display() {
        if (top == -1)
            System.out.println("Stack is underflow");
        else {
            System.out.println("Display elements");
            for (int i = top; i >= 1; i--) {
                System.out.println(arr[i]);
            }
        }
    }
}
public class Main{
    public static void  main(String[]args){
      Scanner scanner=new Scanner(System.in);
      Stack s = new Stack();
      int choice=0;

      while(choice!=4) {
          System.out.println("Choose one of the option below:");
          System.out.println("\n1.push\n2.pop\n3.Display\n4.Exit");
          System.out.println("\nEnter your choice\n");
          choice = scanner.nextInt();

          switch (choice) {
              case 1: {
                  s.push(scanner);
                  break;
              }
              case 2: {
                  s.pop();
                  break;
              }
              case 3: {
                  s.display();
                  break;
              }
              case 4: {
                  System.out.println("exiting...");
                  System.exit(0);
                  break;
              }
              default: {
                  System.out.println("Enter a valid choice!!!");
              }
          };
      }
      }
    }
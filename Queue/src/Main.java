import java.util .Scanner;
class Queues{
    int front;
    int rear;
    int maxsize=10;
    int[] arr=new int[maxsize];

   void isempty(){
       if (front==-1||front == rear||front>rear)
       System.out.println("its underflow");
    }
    void isfull(){
        if (rear==maxsize-1)
        System.out.println("its overflow");
    }
    boolean Enquing(Scanner scanner){
       if (rear==maxsize-1) {
           System.out.println("Its full");
           return false;
       }else {
           System.out.println("Enter your value:");
           int value=scanner.nextInt();
           rear++;
           arr[rear]=value;
           System.out.println("Value entered");
           return true;
       }
    }
    boolean Dequing(){
       if(front==rear){
           System.out.println("Queue is empty");
           return false;
       }
       else{
           int item;
           item=arr[front];
           front++;
           return true;
       }
    }
    void display(){
       if(front==rear)
           System.out.println("Queue is empty");
       else{
           for(int i=front;i<=rear;i++){
               System.out.println(arr[i]);
           }
       }
    }
}
public class Main {
  public static void main (String[]args){
      Queues q=new Queues();
      Scanner scanner=new Scanner(System.in);
      int choice=0;
      while (choice!=4){
          System.out.println("Choose your action:\n");
          System.out.println("1.Inserting\n2.Deleting\n3.Display\n4.Exit");
          System.out.println("\nEnter your choice:");
          choice= scanner.nextInt();
          switch (choice){
              case 1:
              {
                  q.Enquing(scanner);
                  break;
              }
              case 2:
              {
                  q.Dequing();
                  break;
              }
              case 3:
              {
                  q.display();
                  break;
              }
              case 4:
              {
                  System.out.println("Exiting.....");
                  System.exit(0);
                  break;
              }
              default:{
                  System.out.println("Enter a valid Choice!!!");
              }
          }
      }

    }
}
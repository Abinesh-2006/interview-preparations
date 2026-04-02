import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
          System.out.println("Welcome To our Cab Service");
          User[] users = new User[4];
          int i=0;
          while(true){
              System.out.println("Please enter your choice");
              System.out.println("1. Cab Booking");
              System.out.println("2. Show All Bookings");
              System.out.println("3. Exit");
              int choice = sc.nextInt();
              if(choice == 1) {
                  if (i < users.length) {
                      System.out.println("Please enter your name");
                      String name = sc.next();
                      System.out.println("Please enter your Starting Location");
                      String Slocation = sc.next();
                      System.out.println("Please enter your Ending Location");
                      String Elocation = sc.next();
                      System.out.println("Please enter Distance in Km");
                      int distance = sc.nextInt();
                      sc.nextLine();
                      System.out.println("Please enter your phone number");
                      String phone = sc.next();
                      users[i] = new User(name, Slocation, Elocation,phone);
                      System.out.println("Cab Booked Successful");
                      Cab cab  = new Cab(distance);
                      users[i].setCab(cab);
                      cab.setUser(users[i]);
                      System.out.println("Price :"+cab.getPrice());
                      i++;
                  }else{
                      System.out.println("No Cabs Are Available");
                  }
              }
              else if(choice == 2){
                  for (i = 0; i < users.length; i++) {
                      if(users[i]!=null){
                          users[i].getCab().showDetails();
                      }
                  }
              }
              else if(choice == 3){
                  System.out.println("Thanks for using our Cab Service");
                  break;
              }
              else{
                  System.out.println("Invalid Choice");
              }
        }
        }
    }

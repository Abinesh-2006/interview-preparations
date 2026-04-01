// 3. Long Programming: Build Parking System V1 

// • Requirement (Classes): Vehicle, Slot, ParkingLot. 

// • Requirement (Functions): parkVehicle(), removeVehicle(). 

// • Expected Design Thinking: Slot contains Vehicle reference; ParkingLot 

// manages slots. 

// • Constraints: No global variables. Must use OOPs properly. 

import java.util.*;


public class ParkingSystem  {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Set<Vehicle> vehicles = new HashSet<Vehicle>();
        Slot(10);
        while(true){
        System.out.println("\n1).Park Vehicle\n2).Remove Vehicle\n3)Show All Vehicles\n4)Exit");
        int choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1:
                System.out.println("enter your vehicle type");
                String vehicleType = sc.nextLine();
                System.out.println("enter your vehicle number");
                String vehicleNumber =   sc.nextLine();
                vehicles.add(new Vehicle(vehicleType,vehicleNumber));
                System.out.println("Vehicle Parked successfully");
                break;
            case 2:
                System.out.println("enter your vehicle number");
                String VNumber = sc.nextLine();
                boolean found = false;
                for(Vehicle v : vehicles){
                    if(v.getVehicleNumber().equals(VNumber)){
                        v.setVehicleNumber(null);
                        v.setVehicleType(null);
                      found = true;
                    }
        }
                if(!found){
                    System.out.println("No such vehicle exists");
                }else{
                    System.out.println("Vehicle Removed successfully");
                }
                break;

                case 3:
                    for(Vehicle v : vehicles){
                        if(v.getVehicleNumber()!=null){
                            System.out.println("------------------------------------------");
                            System.out.println("Vehicle Number :"+v.getVehicleNumber());
                            System.out.println("Vehicle  Type :"+v.getVehicleType());
                        }
                    }
                    break;
            default:
                System.out.println("Thank you for Using Our System");
                break;

        }
    }
        }
    }
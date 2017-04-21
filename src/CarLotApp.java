//author: Stephanie Broadwell
//lab# 11

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by broad on 4/20/2017.
 */
public class CarLotApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Car> carList = new ArrayList<>();
        CarLot wheelDeal = new CarLot(carList);
        carList.add(new Car("Ford", "Mustang", 2018, 43000.99));
        carList.add(new Car("Chevy", "Malibu", 2017, 32000.99));
        carList.add(new Car("Dodge", "Ram", 2017, 35500.00));
        carList.add(new UsedCar("Toyota", "Prius", 2009, 22550.99, 25000));
        carList.add(new UsedCar("Ford", "Escape", 2010, 22000.00, 43000));
        carList.add(new UsedCar("Ford", "Edge", 2003, 21250.99, 82500));

        System.out.println("Welcome to Wheel Deal Dealership. We have new and used cars!");
        boolean knowMore = true;
        while (knowMore) {
            System.out.println("What would you like to do? ('list cars', 'add a car', 'remove a car', 'find car', " +
                    "'replace car'): ");
            String userDo = scan.nextLine();

            userDo.toLowerCase();
            if (userDo.contains("list")) {
                wheelDeal.listCars();   //calling on listCars method in CarLot Class
                wheelDeal.numOfCar();   //print out prompt for user to enter number betwn 0 & last index of the ArrayList
                int userCar = scan.nextInt();
                wheelDeal.carInfo(userCar); //prints out the price and/or price with mileage if used car
            }
            else if (userDo.contains("add")) {
                System.out.println("New car or Used car?");
                String carType = scan.nextLine();
                carType = carType.toLowerCase();
                String make, model;
                int year, mileage;
                double price;
                if (carType.contains("new")){
                    System.out.println("Please enter make: ");
                    make = scan.nextLine();
                    System.out.println("Please enter model: ");
                    model = scan.nextLine();
                    System.out.println("Please enter year: ");
                    year = scan.nextInt();
                    System.out.println("Please enter price: ");
                    price = scan.nextDouble();
                    Car userEntry = new Car(make, model, year, price);
                    wheelDeal.addCar(userEntry);
                }
                else if (carType.contains("used")){
                    System.out.println("Please enter make: ");
                    make = scan.nextLine();
                    System.out.println("Please enter model: ");
                    model = scan.nextLine();
                    System.out.println("Please enter year: ");
                    year = scan.nextInt();
                    System.out.println("Please enter price: ");
                    price = scan.nextDouble();
                    System.out.println("Please enter mileage: ");
                    mileage = scan.nextInt();
                    UsedCar userEntry = new UsedCar(make, model, year, price, mileage);
                    wheelDeal.addCar(userEntry);
                }
            }
            else if (userDo.contains("remove")){
                wheelDeal.listCars();
                System.out.println("Which car would you like to remove? (enter number): ");
                int removeNum = scan.nextInt();
                wheelDeal.removeCar(removeNum);
            }
            else if (userDo.contains("find")){
                wheelDeal.numOfCar();
                int findNum = scan.nextInt();
                wheelDeal.findCar(findNum);
                wheelDeal.carInfo(findNum);
            }
            else if (userDo.contains("replace")){
                wheelDeal.numOfCar();
                int findNum = scan.nextInt();
                wheelDeal.findCar(findNum);
                String make1, model;
                int year, mileage;
                double price;
                scan.nextLine();
                System.out.println("Are you replacing a new or used car?");
                String carType = scan.nextLine();
                carType = carType.toLowerCase();
                if (carType.contains("new")) {
                    System.out.println("Please enter make: ");
                    make1 = scan.nextLine();
                    System.out.println("Please enter model: ");
                    model = scan.nextLine();
                    System.out.println("Please enter year: ");
                    year = scan.nextInt();
                    System.out.println("Please enter price: ");
                    price = scan.nextDouble();
                    wheelDeal.replaceCar(findNum, make1, model, year, price);
                }
                else if (carType.contains("used")) {
                    System.out.println("Please enter make: ");
                    make1 = scan.nextLine();
                    System.out.println("Please enter model: ");
                    model = scan.nextLine();
                    System.out.println("Please enter year: ");
                    year = scan.nextInt();
                    System.out.println("Please enter price: ");
                    price = scan.nextDouble();
                    System.out.println("Please enter mileage: ");
                    mileage = scan.nextInt();
                    wheelDeal.replaceCar(findNum, make1, model, year, price, mileage);
                }
            }

            scan.nextLine();
            System.out.println("Would you like to continue? (y/n): ");
            String anotherFunction = scan.nextLine();
            anotherFunction.toLowerCase();
            if (anotherFunction.startsWith("n")) {
                System.out.println("Goodbye!");
                knowMore = false;
            }
        }
    }
}

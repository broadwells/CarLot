import java.util.ArrayList;

/**
 * Created by broad on 4/20/2017.
 */
public class CarLot {
    private ArrayList<Car> carInventory = new ArrayList<>();

    public CarLot(ArrayList<Car> carInventory) {    //constructor for setting elements into ArrayList
        this.carInventory = carInventory;

    }

    public void listCars () {   //only listing the make, model, year of the car
        for (int i = 0; i < carInventory.size(); i++) {
            System.out.println("Car " + i + ": " + carInventory.get(i).getMake() + " " +
                    carInventory.get(i).getModel() + " " + carInventory.get(i).getYear());
        }
    }

    public void carInfo (int userNum) {
        if (userNum < 0 || userNum > carInventory.size()) { //validating userNum is a number w/in the ArrayList
            System.out.println("Invalid. Please enter only a number listed.");
        }
        for (int i = 0; i < carInventory.size(); i++) {     //prints price for new car and price/mileage for used car
            if (i == userNum) {
                if (carInventory.get(i) instanceof UsedCar) {   //use of instanceof to print used or new car
                    System.out.println("Used Car! Price: $" + carInventory.get(i).getPrice() + " " + carInventory
                            .get(i).toString());
                } else {
                    System.out.println("New Car! Price: $" + carInventory.get(i).getPrice());
                }
            }
        }
    }
    public void numOfCar(){     //prints out numbers of car (i.e. 0-5)
        int one = 0;
        System.out.println("Please select a car (" + one + " - " + (carInventory.size() - 1) + "): ");
    }

    public void addCar(Car userCar) {   //adds car information for new car using Car class
        carInventory.add(userCar);
    }

    public void addCar(UsedCar userCar) {   //adds car info for used car using UsedCar class
        carInventory.add(userCar);
    }

    public void removeCar(int userInput) {

        if (userInput < 0 || userInput > carInventory.size()) {
            System.out.println("Invalid input.");

        }
        carInventory.remove(userInput);
    }

    public void findCar(int userCarNum) {
        for (int i = 0; i < carInventory.size(); i++) {
            if (i == userCarNum) {
                System.out.println("Car " + i + ": " + carInventory.get(i).getMake() + " " +
                        carInventory.get(i).getModel() + " " + carInventory.get(i).getYear());
            }
        }
    }
    public void replaceCar(int userNum, String make, String model, int year, double price){ //for new car inputs
        for (int i = 0; i < carInventory.size(); i++) {
            if (i == userNum) {
                carInventory.get(i).setMake(make);
                carInventory.get(i).setModel(model);
                carInventory.get(i).setYear(year);
                carInventory.get(i).setPrice(price);
            }
        }
    }

    //for used car inputs
    public void replaceCar(int userNum, String make, String model, int year, double price, int mileage){
        for (int i = 0; i < carInventory.size(); i++) {
            if (i == userNum) {
                carInventory.get(i).setMake(make);
                carInventory.get(i).setModel(model);
                carInventory.get(i).setYear(year);
                carInventory.get(i).setPrice(price);
                carInventory.get(i).toString();
            }
        }
    }
}

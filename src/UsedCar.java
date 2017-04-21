/**
 * Created by broad on 4/20/2017.
 */
public class UsedCar extends Car{
    private int mileage;

    public UsedCar(String make, String model, int year, double price) {
        super(make, model, year, price); //super: constructors from parent class to use in child class

    }

    public UsedCar(String make, String model, int year, double price, int mileage) {
        super(make, model, year, price);
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Mileage: " + mileage;
    }
}

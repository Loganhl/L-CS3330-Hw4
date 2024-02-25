package pkg;

public abstract class Vehicle {
    protected String brand;
    protected String make;
    protected long modelYear;
    protected double price;
    protected VehicleColor color;
    protected FuelType fuelType;
    protected double mileage;
    protected double mass;
    protected int cylinders;
    protected double gasTankCapacity;
    protected StartMechanism startType;
    
    public Vehicle(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, StartMechanism startType, double gasTankCapacity) {
        this.brand = brand;
        this.make = make;
        this.modelYear = modelYear;
        this.price = price;
        this.color = color;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.mass = mass;
        this.cylinders = cylinders;
        this.startType = startType;
        this.gasTankCapacity = gasTankCapacity;
    }
    
    public Vehicle(Vehicle other) {
        this.brand = other.brand;
        this.make = other.make;
        this.modelYear = other.modelYear;
        this.price = other.price;
        this.color = other.color;
        this.fuelType = other.fuelType;
        this.mileage = other.mileage;
        this.mass = other.mass;
        this.cylinders = other.cylinders;
        this.startType = other.startType;
        this.gasTankCapacity = other.gasTankCapacity;
    }
    
    
    public String toString() {
        return "Brand: " + brand + ", Make: " + make + ", Model Year: " + modelYear +
                ", Price: " + price + ", Color: " + color + ", Fuel Type: " + fuelType +
                ", Mileage: " + mileage + ", Mass: " + mass + ", Cylinders: " + cylinders +
                ", Gas Tank Capacity: " + gasTankCapacity + ", Start Type: " + startType;
    }
    
    public abstract double calculateMaintenanceCost(double distance);

    public abstract double calculateFuelEfficiency(double distance, double fuelPrice);

    public abstract void startEngine();

}

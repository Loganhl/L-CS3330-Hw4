package pkg;

public class MotorBike extends Vehicle {
    public MotorBike(String type, String model, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, StartMechanism startType, double gasTankCapacity) {
        super(type, model, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity);
    }
}
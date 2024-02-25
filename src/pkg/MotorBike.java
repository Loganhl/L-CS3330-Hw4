package pkg;

public class MotorBike extends Vehicle {
    public MotorBike(String brand, String type, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, StartMechanism startType, double gasTankCapacity) {
    	super(type, brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity);
    }
    
    public MotorBike(MotorBike vehicle) {
        super(vehicle);
    }

    public double calculateMaintenanceCost(double distance) {
        return distance * mass * (2024 - getModelYear()) * cylinders * 0.002;
    }

    @Override
    public double calculateFuelEfficiency(double distance, double fuelPrice) {
        return cylinders * gasTankCapacity * fuelPrice / (distance * 0.001);
    }

    @Override
    public void startEngine() {
        System.out.println("Start engine: KICKSTART");
    }
}
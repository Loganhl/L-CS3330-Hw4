package pkg;

//Inherits from Vehicle.
public class Car extends Vehicle {
    public Car(String brand, String type, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, StartMechanism startType, double gasTankCapacity) {
    	super(type, brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity);
    }
    
    public Car(Car vehicle) {
        super(vehicle);
    }

	@Override
	public double calculateMaintenanceCost(double distance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
		
	}
}
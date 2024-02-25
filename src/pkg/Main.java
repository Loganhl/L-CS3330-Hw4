package pkg;

public class Main {
	
	 public static void main(String[] args) {
	 // Instantiate vehicleManager, perform operations based on the requirements.
	 VehicleManager vehicleManager = new VehicleManager();
	 
	 // Read vehicle data from the vehcileList.csv file and initialize objects.
	 boolean fileReadStatus = vehicleManager.initializeVehicle();
	 
	 if(fileReadStatus) {
		 // Display all vehicle information.
		 vehicleManager.displayAllVehicleInformation(vehicleManager.vehicleList);
	 
		 // Display all car information.
		 vehicleManager.displayAllCarInformation(100, 3);
	 
		 // Display all motorbike information.
		 vehicleManager.displayAllMotorBikeInformation(100, 3);
	 
	 	}
	 }
	}


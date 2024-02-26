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
		 vehicleManager.displayAllCarInformation(300, 3.25);
	 
		 // Display all motorbike information.
		 vehicleManager.displayAllMotorBikeInformation(300, 3.25);
	 
	 	}
	 }
	}


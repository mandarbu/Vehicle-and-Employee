package com.vehicle;

public class Car extends Vehicle {
	private boolean powerSteering;
    private String fuelType;

  

public Car(int vehicleNo, String engineStatus, int currentGear, boolean powerSteering, String fuelType) {
		super(vehicleNo, engineStatus, currentGear);
		this.powerSteering = powerSteering;
		this.fuelType = fuelType;
	}

	@Override
    public void ignite() {
        engineStatus = "on";
        currentGear = 1;
    }

    @Override
    public int changeGear(int flag) {
        if (flag == 1) {
            if (currentGear < 6) {
                return ++currentGear;
            } else {
                return currentGear;
            }
        } else if (flag == -1) {
            if (currentGear > 1) {
                return --currentGear;
            } else {
                return currentGear;
            }
        }
        return currentGear;
    }

    @Override
    public void stop() {
        engineStatus = "off";
        currentGear = 0;
    }

    public void showCarDetails() {
        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Engine Status: " + engineStatus);
        System.out.println("Current Gear: " + currentGear);
        System.out.println("Power Steering: " + powerSteering);
        System.out.println("Fuel Type: " + fuelType);
    }
}
	



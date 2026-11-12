package com.example.labtest;

import java.util.Scanner;

public class VehicleFeeCalculator {

    public double calculateFee(String vehicleType, double hours) {

        if (hours < 0) {
            throw new IllegalArgumentException("Invalid parking duration");
        }

        double rate;

        if (vehicleType.equalsIgnoreCase("two-wheeler")) {
            rate = 10;
        } else if (vehicleType.equalsIgnoreCase("four-wheeler")) {
            rate = 20;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type");
        }

        return Math.ceil(hours) * rate;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VehicleFeeCalculator calculator = new VehicleFeeCalculator();

        System.out.println("Vehicle Parking Fee Calculator");

        System.out.print("Enter vehicle type: ");
        String vehicleType = sc.nextLine();

        System.out.print("Enter parking duration: ");
        double hours = sc.nextDouble();

        try {
            double fee = calculator.calculateFee(vehicleType, hours);

            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Parking Hours: " + hours);
            System.out.println("Total Fee: Rs. " + fee);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}

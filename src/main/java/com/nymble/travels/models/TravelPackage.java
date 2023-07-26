package com.nymble.travels.models;

import com.nymble.travels.enums.PassengerType;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {

    private final String name;
    private final int passengerCapacity;
    private final List<Destination> itinerary;
    private final List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Passenger capacity reached. Cannot add more passengers.");
        }
    }

    public void enrollPassengerToActivity(Passenger passenger, Activity activity) {
        passenger.signUpForActivity(activity);
    }


    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName());
                System.out.println("Description: " + activity.getDescription());
                System.out.println("Cost: " + activity.getCost());
                System.out.println("Capacity: " + activity.getCapacity());
            }
            System.out.println();
        }
    }

    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Passenger Name: " + passenger.getName());
            System.out.println("Passenger Number: " + passenger.getPassengerNumber());
            System.out.println("Passenger Type: " + passenger.getType());
            if (passenger.getType() == PassengerType.STANDARD || passenger.getType() == PassengerType.GOLD) {
                System.out.println("Passenger Balance: " + passenger.getBalance());
            }
            System.out.println("Enrolled Activities:");
            for (Activity activity : passenger.getEnrolledActivities()) {
                //System.out.println("Activity: " + activity.getName() + " (Destination: " + activity.getDestination().getName() + ")");
                if (passenger.getType() == PassengerType.STANDARD || passenger.getType() == PassengerType.GOLD) {
                    double cost = passenger.getType() == PassengerType.STANDARD ? activity.getCost() : activity.getCost() * 0.9;
                    System.out.println("Price Paid: " + cost);
                }
            }
            System.out.println();
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                if (activity.hasAvailableSpace()) {
                    System.out.println("Activity: " + activity.getName() + " (Destination: " + destination.getName() + ")");
                    System.out.println("Available Spaces: " + (activity.getCapacity() - activity.getEnrolledPassengers()));
                }
            }
        }
    }

}

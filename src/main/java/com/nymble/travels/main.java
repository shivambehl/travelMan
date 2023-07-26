package com.nymble.travels;

import com.nymble.travels.enums.PassengerType;
import com.nymble.travels.models.*;

public class main {

    public static void main(String[] args) {
        // Create some activities and destinations
        Activity activity1 = new Activity("Hiking", "Enjoy the scenic beauty of mountains", 50, 10);
        Activity activity2 = new Activity("Scuba Diving", "Explore the underwater world", 100, 5);
        Destination destination1 = new Destination("Mountain Resort");
        Destination destination2 = new Destination("Beach Resort");

        destination1.addActivity(activity1);
        destination2.addActivity(activity2);

        // Create passengers
        Passenger passenger1 = PassengerFactory.getPassenger(PassengerType.STANDARD, "John Doe", 1001, 200);
        Passenger passenger2 = PassengerFactory.getPassenger(PassengerType.GOLD, "Jane Smith", 1002, 300);
        Passenger passenger3 = PassengerFactory.getPassenger(PassengerType.PREMIUM, "Alice Johnson", 1003);

        // Create the travel package
        TravelPackage travelPackage = new TravelPackage("Summer Vacation", 3);
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        // Enroll passengers in activities
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3);

        travelPackage.enrollPassengerToActivity(passenger1, activity1);
        travelPackage.enrollPassengerToActivity(passenger2, activity2);
        travelPackage.enrollPassengerToActivity(passenger2, activity2);

        // Print the details
        travelPackage.printItinerary();
        travelPackage.printPassengerList();
        travelPackage.printAvailableActivities();
    }

}

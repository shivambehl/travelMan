package com.nymble.travels.models;

import com.nymble.travels.enums.PassengerType;

import java.util.ArrayList;
import java.util.List;

public class PremiumPassenger implements Passenger{

    private String name;
    private int passengerNumber;

    private final List<Activity> enrolledActivities;

    public PremiumPassenger(String name, int passengerNumber) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.enrolledActivities = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPassengerNumber() {
        return passengerNumber;
    }

    @Override
    public double getBalance() {
        return 0; // Premium passengers don't have a balance
    }

    @Override
    public PassengerType getType() {
        return PassengerType.PREMIUM;
    }

    @Override
    public List<Activity> getEnrolledActivities() {
        return enrolledActivities;
    }


    @Override
    public void signUpForActivity(Activity activity) {
        enrolledActivities.add(activity);
        System.out.println(name + " (Premium) signed up for " + activity.getName() + " at " +
                " for FREE!");
        activity.enrollPassenger();
    }

}

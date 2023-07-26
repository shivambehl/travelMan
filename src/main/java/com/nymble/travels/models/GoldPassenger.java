package com.nymble.travels.models;

import com.nymble.travels.enums.PassengerType;

import java.util.ArrayList;
import java.util.List;

public class GoldPassenger implements Passenger{
    private String name;
    private int passengerNumber;
    private double balance;
    private final List<Activity> enrolledActivities;

    public GoldPassenger(String name, int passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
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
        return balance;
    }

    @Override
    public PassengerType getType() {
        return PassengerType.GOLD;
    }

    @Override
    public List<Activity> getEnrolledActivities() {
        return enrolledActivities;
    }



    @Override
    public void signUpForActivity(Activity activity) {
        double discountedCost = 0.9 * activity.getCost();
        if (discountedCost <= balance) {
            enrolledActivities.add(activity);
            // Sufficient balance, sign up for the activity with the discounted cost
            balance -= discountedCost;
            System.out.println(name + " (Gold) signed up for " + activity.getName() + " at " +
                    " for $" + discountedCost + " (10% discount applied)");
            activity.enrollPassenger();
        } else {
            System.out.println(name + " (Gold) does not have sufficient balance to sign up for " + activity.getName());
        }
    }
}

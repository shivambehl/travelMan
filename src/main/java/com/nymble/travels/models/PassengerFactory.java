package com.nymble.travels.models;

import com.nymble.travels.enums.PassengerType;


import static com.nymble.travels.enums.PassengerType.*;

public class PassengerFactory {

    public static Passenger getPassenger(PassengerType passengerType, String name, int passengerNumber, double balance) {
        return get(name, passengerNumber, balance, passengerType);
    }

    public static Passenger


    getPassenger(PassengerType passengerType, String name, int passengerNumber) {
        return get(name, passengerNumber, 0, passengerType);
    }

    private static Passenger get(String name, int passengerNumber, double balance, PassengerType passengerType) {
        if (STANDARD.equals(passengerType)) {
            return new StandardPassenger(name, passengerNumber, balance);
        } else if (GOLD.equals(passengerType)) {
            return new GoldPassenger(name, passengerNumber, balance);
        } else if (PREMIUM.equals(passengerType)) {
            return new PremiumPassenger(name, passengerNumber);
        }
        return null;
    }

}

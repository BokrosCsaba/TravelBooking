package com.bonex.travelbooking.bookingprocess;

import com.bonex.travelbooking.domain.TravelTicket;

public class CheapTravelBookingsystem implements BookingSystem{

    @Override
    public void setTravelTicket(TravelTicket ticket) {
        System.out.println("Cheap travel received ticket " + ticket);
    }

    @Override
    public void requestBooking() {
        System.out.println("Cheap travel had a booking request");
    }

    @Override
    public boolean getStatus() {
        return false;
    }

    @Override
    public boolean cancel() {
        return false;
    }
}

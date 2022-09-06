package com.bonex.travelbooking.bookingprocess;

import com.bonex.travelbooking.domain.TravelTicket;

public class EnjoyableToursBookingSystem implements BookingSystem{
    @Override
    public void setTravelTicket(TravelTicket ticket) {
        System.out.println("Enjoyable Tours has received ticket");
    }

    @Override
    public void requestBooking() {
        System.out.println("Enjoyable Tours has received a booking request");
    }

    @Override
    public boolean getStatus() {
        System.out.println("Enjoyable Tours is providing the booking status");
        return false;
    }

    @Override
    public boolean cancel() {
        return false;
    }
}

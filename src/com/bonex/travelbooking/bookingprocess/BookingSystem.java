package com.bonex.travelbooking.bookingprocess;

import com.bonex.travelbooking.domain.TravelTicket;

public interface BookingSystem {

    public void setTravelTicket(TravelTicket ticket);
    public void requestBooking();
    public boolean getStatus();

    public boolean cancel();


}

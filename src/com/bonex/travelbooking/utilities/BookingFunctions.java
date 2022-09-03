package com.bonex.travelbooking.utilities;

import com.bonex.travelbooking.domain.BusTicket;
import com.bonex.travelbooking.domain.TravelTicket;

public class BookingFunctions {

    public void bookTicket(TravelTicket ticket){
        //valami kód itt. A lényeg, hogy TravelTicketet kap, de a bejövő paraméter akármelyik child is lehet
    }

    public TravelTicket getTicket (int referenceNumber) {

        return new BusTicket();
    }
}

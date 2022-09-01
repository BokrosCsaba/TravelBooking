package com.bonex.travelbooking;

import com.bonex.travelbooking.domain.BusTicket;
import com.bonex.travelbooking.domain.ClassesOfTravel;
import com.bonex.travelbooking.domain.TrainTicket;
import com.bonex.travelbooking.domain.TravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws TravelDurationException {

        TrainTicket trainTicket = new TrainTicket();
        trainTicket.cancel();
        TrainTicket trainTicket2 = null;
        try {
            trainTicket2 = new TrainTicket(123L, "London", "Edinburgh", new BigDecimal("54.32"),
                    LocalDateTime.of(2022, 3, 7, 16, 03),
                    LocalDateTime.of(2022, 3, 7, 19, 03), ClassesOfTravel.BUSINESS, 43, 24);
        } catch (TravelDurationException e) {
            System.out.println("Hiba " + e);
        }


        trainTicket2.upgrade();
//        String[] providers = {"1st bus company", "2nd bus company", "3rd bus company"};
        ArrayList<String> providers = new ArrayList<>();
        providers.add("Első vállalat");
        providers.add("Második válallat");
        providers.add("Harmadik vállalat");

        System.out.println(providers);

        BusTicket busTicket = null;

        busTicket = new BusTicket(123L, "London", "Edinburgh", new BigDecimal("54.32"),
                    LocalDateTime.of(2022, 3, 7, 16, 03),
                    LocalDateTime.of(2023, 3, 7, 19, 03), providers);
                    busTicket.cancel();

        BusTicket busTicket2 = new BusTicket(124L, "London", "Edinburgh", new BigDecimal("54.32"),
                LocalDateTime.of(2022, 3, 7, 16, 03),
                LocalDateTime.of(2023, 3, 7, 19, 03), providers);
        busTicket.cancel();


        BusTicket busTicket3 = new BusTicket(125L, "London", "Edinburgh", new BigDecimal("54.32"),
                LocalDateTime.of(2022, 3, 7, 16, 03),
                LocalDateTime.of(2023, 3, 7, 19, 03), providers);
        busTicket.cancel();




        ArrayList<BusTicket> busTickets = new ArrayList<>();
        busTickets.add(busTicket);
        busTickets.add(busTicket2);
        busTickets.add(busTicket3);

//        for (int i=0; i<busTickets.size(); i++){
//            System.out.println(busTickets.get(i));
//        }
        for (BusTicket b: busTickets){
            System.out.println(b.getBookingRef());
        }
    }

}

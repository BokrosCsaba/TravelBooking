package com.bonex.travelbooking;

import com.bonex.travelbooking.bookingprocess.BookingSystem;
import com.bonex.travelbooking.bookingprocess.CheapTravelBookingsystem;
import com.bonex.travelbooking.bookingprocess.EnjoyableToursBookingSystem;
import com.bonex.travelbooking.domain.*;
import com.bonex.travelbooking.utilities.OriginSortComparator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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





        List<TravelTicket> tickets = new ArrayList<>();
        tickets.add(busTicket);
        tickets.add(busTicket2);
        tickets.add(busTicket3);
        tickets.add(trainTicket2);

        //Comparatort inplementált külön class-szal
        //Collections.sort(tickets, new OriginSortComparator());

        //Anonymous inner class-szal
        Collections.sort(tickets, new Comparator<TravelTicket>() {
            @Override
            public int compare(TravelTicket o1, TravelTicket o2) {
                return o1.getDestination().compareTo(o2.getDestination());
            }
        });
        //ugyanaz lambda expression-nel
        Collections.sort(tickets, (a,b)->{
            return a.getPrice().compareTo(b.getPrice());
        } );

        for (TravelTicket b: tickets){
            System.out.println(b);
        }

        TravelTicket foundTicket = tickets.get(1);
        System.out.println(foundTicket);

        if (foundTicket instanceof BusTicket){
            System.out.println("Its a bus ticket");
            BusTicket foundBusticket = (BusTicket) foundTicket;
            System.out.println(foundBusticket.getPermittedProviders());
        }
        else if (foundTicket instanceof TrainTicket foundTrainTicket){ // Java 17 feature, egyszerre vizsgál és castol is, itt csinál egy TrainTicket tipusút
            foundTrainTicket.getCarriageNumber();
            System.out.println("Its a train ticket");
        }
        else System.out.println("Its a plane ticket");

        BusTicket busTicket4 = new BusTicket(foundTicket, providers);
        BookingSystem bookingSystem = new EnjoyableToursBookingSystem();




    // a fenti instancolásba berakhatom bármelyik classt, ami implementálja a Bookinsystem interface-t, és az alábbi kód mindegyikkel lefut
    bookingSystem.setTravelTicket(busTicket4);
    bookingSystem.requestBooking();
    bookingSystem.getStatus();

    }

}

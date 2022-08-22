package com.bonex.travelbooking;

import com.bonex.travelbooking.domain.BusTicket;
import com.bonex.travelbooking.domain.ClassesOfTravel;
import com.bonex.travelbooking.domain.TrainTicket;
import com.bonex.travelbooking.domain.TravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args){

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
        String[] providers = {"1st bus company", "2nd bus company", "3rd bus company"};

        BusTicket busTicket = null;
        try {
            busTicket = new BusTicket(123L, "London", "Edinburgh", new BigDecimal("54.32"),
                    LocalDateTime.of(2022, 3, 7, 16, 03),
                    LocalDateTime.of(2023, 3, 7, 19, 03), providers);
                    busTicket.cancel();
        } catch (TravelDurationException e) {
            System.out.println("Hiba történt" + e);
        }



    }

}

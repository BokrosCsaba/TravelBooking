package com.bonex.travelbooking;

import com.bonex.travelbooking.domain.BusTicket;

import java.util.Scanner;

public class MakeABooking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("PLease choose ticket type (1: Plane ticket 2: Bus ticket 3: Train ticket");
        Integer choose = scanner.nextInt();

        switch (choose) {

            case 1:
                BusTicket busticket = new BusTicket();
                System.out.println("Type in booking reference:");
                Long bf = scanner.nextLong();
                busticket.setBookingRef(bf);
        }



    }
}

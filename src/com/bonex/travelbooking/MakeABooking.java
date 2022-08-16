package com.bonex.travelbooking;

import com.bonex.travelbooking.domain.BusTicket;
import com.bonex.travelbooking.domain.ClassesOfTravel;
import com.bonex.travelbooking.domain.PlaneTicket;
import com.bonex.travelbooking.domain.TrainTicket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MakeABooking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose ticket type (1: Bus ticket 2: Plane ticket 3: Train ticket");
        Integer choose = scanner.nextInt();
        if (choose>0 && choose<4) {
            System.out.println("Type in booking reference:");
            Long bf = scanner.nextLong();
            scanner.nextLine();
            System.out.println("Type in booking origin:");
            String origin = scanner.nextLine();

            System.out.println("Type in booking destination:");
            String destination = scanner.nextLine();
            System.out.println("Type in departure time (yyyy-MM-dd HH:mm):");
            String departureTime = scanner.nextLine();
            System.out.println("Type in arrival time (yyyy-MM-dd HH:mm):");
            String arrivalTime = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime departureDateTime = LocalDateTime.parse(departureTime, formatter);
            LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalTime, formatter);

            switch (choose) {

                case 1:


                    BusTicket busticket = new BusTicket();

                    busticket.setBookingRef(bf);

                    busticket.setOrigin(origin);

                    busticket.setDestination(destination);


                    busticket.setDepartureTime(departureDateTime);


                    busticket.setArrivalTime(arrivalDateTime);
                    System.out.println(busticket);
                    break;

                case 2:
                    PlaneTicket planeTicket = new PlaneTicket();

                    planeTicket.setBookingRef(bf);

                    planeTicket.setOrigin(origin);

                    planeTicket.setDestination(destination);

                    planeTicket.setDepartureTime(departureDateTime);

                    planeTicket.setArrivalTime(arrivalDateTime);

                    System.out.println("Type in travel class:");
                    String travelClass = scanner.nextLine();

                    planeTicket.setTravelClass(ClassesOfTravel.valueOf(travelClass.toUpperCase()));
                    System.out.println(planeTicket);
                    break;

                case 3:
                    TrainTicket trainTicket = new TrainTicket();

                    trainTicket.setBookingRef(bf);

                    trainTicket.setOrigin(origin);

                    trainTicket.setDestination(destination);

                    trainTicket.setDepartureTime(departureDateTime);

                    trainTicket.setArrivalTime(arrivalDateTime);

                    System.out.println("Type in travel class:");
                    String travelClassTrain = scanner.nextLine();

                    trainTicket.setTravelClass(ClassesOfTravel.valueOf(travelClassTrain.toUpperCase()));
                    System.out.println(trainTicket);
            }

        }
    else System.out.println("You didnt choose a valid type of ticket");
    }
}

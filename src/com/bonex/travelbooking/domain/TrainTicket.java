package com.bonex.travelbooking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class TrainTicket extends TravelTicket implements Comparable<TravelTicket>{

    private ClassesOfTravel travelClass;
    private Integer carriageNumber;
    private Integer seatNumber;


    public TrainTicket() {
        super();
    };

    public TrainTicket(Long bookingRef, String origin, String destination, BigDecimal price,
                       LocalDateTime departureTime, LocalDateTime arrivalTime, ClassesOfTravel travelClass,
                       Integer carriageNumber, Integer seatNumber) throws TravelDurationException {
        super(bookingRef, origin, destination, price, departureTime, arrivalTime);
        this.travelClass = travelClass;
        this.carriageNumber = carriageNumber;
        this.seatNumber = seatNumber;
    }

    public ClassesOfTravel getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(ClassesOfTravel travelClass) {
        this.travelClass = travelClass;
    }

    public Integer getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(Integer carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void upgrade() {
        if (travelClass !=ClassesOfTravel.FIRST) {
            travelClass = ClassesOfTravel.FIRST;
            System.out.println("You have been upgraded to class 1");
        }
        else
            {
                System.out.println("You are on 1st class already");
            }

    }

    @Override
    public String toString() {
        return "TrainTicket{" +
                "travelClass=" + travelClass +
                ", carriageNumber=" + carriageNumber +
                ", seatNumber=" + seatNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TrainTicket that = (TrainTicket) o;
        return Objects.equals(travelClass, that.travelClass) && Objects.equals(carriageNumber, that.carriageNumber) && Objects.equals(seatNumber, that.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), travelClass, carriageNumber, seatNumber);
    }
}

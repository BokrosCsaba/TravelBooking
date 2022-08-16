package com.bonex.travelbooking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class PlaneTicket  extends TravelTicket{

    private ClassesOfTravel travelClass;
    private Integer seatNumber;
    private Integer stopOvers;

    public PlaneTicket () {
        super();
    }

    public PlaneTicket(Long bookingRef, String origin, String destination, BigDecimal price,
                       LocalDateTime departureTime, LocalDateTime arrivalTime, ClassesOfTravel travelClass,
                       Integer seatNumber, Integer stopOvers) {
        super(bookingRef, origin, destination, price, departureTime, arrivalTime);
        this.travelClass = travelClass;
        this.seatNumber = seatNumber;
        this.stopOvers = stopOvers;
    }

    public ClassesOfTravel getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(ClassesOfTravel travelClass) {
        this.travelClass = travelClass;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getStopOvers() {
        return stopOvers;
    }

    public void setStopOvers(Integer stopOvers) {
        this.stopOvers = stopOvers;
    }

    public void upgrade(){
        System.out.println("You have been upgraded");

    }
    public void addStopOver() {
        stopOvers++;
        System.out.println("You have "+ stopOvers + " stopovers.");
    }

    @Override
    public String toString() {
        return "PlaneTicket{" +
                "travelClass=" + travelClass +
                ", seatNumber=" + seatNumber +
                ", stopOvers=" + stopOvers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlaneTicket that = (PlaneTicket) o;
        return Objects.equals(travelClass, that.travelClass) && Objects.equals(seatNumber, that.seatNumber) && Objects.equals(stopOvers, that.stopOvers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), travelClass, seatNumber, stopOvers);
    }
}

package com.bonex.travelbooking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public abstract class TravelTicket implements Comparable<TravelTicket>{

    private Long bookingRef;
    private String origin;
    private String destination;
    private BigDecimal price;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public TravelTicket() {}

    public TravelTicket(Long bookingRef, String origin, String destination, BigDecimal price, LocalDateTime departureTime, LocalDateTime arrivalTime) throws TravelDurationException {

        this.bookingRef = bookingRef;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;

        long diff = ChronoUnit.SECONDS.between(departureTime, arrivalTime);

        if (diff<0) {
            throw new TravelDurationException();
        }
    }

    public Long getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(Long bookingRef) {
        this.bookingRef = bookingRef;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void reschedule() {
        System.out.println("Im rescheduling the ticket");
    }

    public void cancel() {
        System.out.println("Im cancelling the ticket");
    }

    @Override
    public String toString() {
        return "TravelTicket{" +
                "bookingRef=" + bookingRef +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelTicket that = (TravelTicket) o;
        return Objects.equals(bookingRef, that.bookingRef) && Objects.equals(origin, that.origin) && Objects.equals(destination, that.destination) && Objects.equals(price, that.price) && Objects.equals(departureTime, that.departureTime) && Objects.equals(arrivalTime, that.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingRef, origin, destination, price, departureTime, arrivalTime);
    }

    @Override
    public int compareTo(TravelTicket o) {
        return bookingRef.compareTo(o.getBookingRef());
    }
}



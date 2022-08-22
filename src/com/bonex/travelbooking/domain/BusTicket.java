package com.bonex.travelbooking.domain;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class BusTicket extends TravelTicket {

    private String[] permittedProviders;
    public BusTicket() {
        super();
    }
    public BusTicket(Long bookingRef, String origin, String destination, BigDecimal price,
                     LocalDateTime departureTime, LocalDateTime arrivalTime, String[] permittedProviders) throws TravelDurationException {
        super(bookingRef, origin, destination, price, departureTime, arrivalTime);
        this.permittedProviders = permittedProviders;
    }

    public String[] getPermittedProviders() {
        return permittedProviders;
    }

    public void setPermittedProviders(String[] permittedProviders) {
        this.permittedProviders = permittedProviders;

    }

    @Override
    public void cancel() {
        Duration d= Duration.between(LocalDateTime.now(), getDepartureTime());
        Long days = d.toDays();
        if (days > 30) {
            super.cancel();
            System.out.println("Your travel has been cancelled");
        }
        else {
            System.out.println("Cannot be cancelled within 30 days");
        }

    }

    @Override
    public String toString() {
        return "BusTicket{" +
                "permittedProviders=" + Arrays.toString(permittedProviders) +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BusTicket busTicket = (BusTicket) o;
        return Arrays.equals(permittedProviders, busTicket.permittedProviders);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(permittedProviders);
        return result;
    }

}

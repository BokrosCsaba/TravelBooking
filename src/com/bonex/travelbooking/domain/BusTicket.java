package com.bonex.travelbooking.domain;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class BusTicket extends TravelTicket {

    private ArrayList<String> permittedProviders = new ArrayList<>();
    public BusTicket() {
        super();
    }
    public BusTicket(Long bookingRef, String origin, String destination, BigDecimal price,
                     LocalDateTime departureTime, LocalDateTime arrivalTime, ArrayList<String> permittedProviders) throws TravelDurationException {
        super(bookingRef, origin, destination, price, departureTime, arrivalTime);
        this.permittedProviders = permittedProviders;
    }

    public ArrayList<String> getPermittedProviders() {
        return permittedProviders;
    }

    public void setPermittedProviders(ArrayList<String> permittedProviders) {
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
        return "BusTicket{" + super.toString() +
                "permittedProviders=" + permittedProviders +
                "} " ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BusTicket busTicket = (BusTicket) o;
        return Objects.equals(permittedProviders, busTicket.permittedProviders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), permittedProviders);
    }
}

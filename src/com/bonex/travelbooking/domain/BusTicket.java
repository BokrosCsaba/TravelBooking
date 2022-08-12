package com.bonex.travelbooking.domain;

public class BusTicket extends TravelTicket{

    private String[] permittedProviders;

    public String[] getPermittedProviders() {
        return permittedProviders;
    }

    public void setPermittedProviders(String[] permittedProviders) {
        this.permittedProviders = permittedProviders;
    }
}

package com.bonex.travelbooking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TravelTicket {

    private Long bookingRef;
    private String origin;
    private String destination;
    private BigDecimal price;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

}

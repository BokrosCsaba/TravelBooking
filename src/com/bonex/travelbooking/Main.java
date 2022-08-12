package com.bonex.travelbooking;

import com.bonex.travelbooking.domain.TrainTicket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        TrainTicket trainTicket = new TrainTicket();
        trainTicket.cancel();
        TrainTicket trainTicket2 = new TrainTicket(123L, "London", "Edinburgh", new BigDecimal("54.32"),
                LocalDateTime.of(2022, 3, 7, 16, 03),
                LocalDateTime.of(2022, 3, 7, 19, 03),
                1, 43, 24);


        trainTicket2.upgrade();

    }

}

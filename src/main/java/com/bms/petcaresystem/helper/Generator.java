package com.bms.petcaresystem.helper;

import com.bms.petcaresystem.helper.message.BusinessMessage;

import java.util.Random;

public class Generator {
    private Generator() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Integer LENGTH = 10;
    private static final StringBuilder CODE = new StringBuilder();
    private static final Random RANDOM = new Random();

    public static String generateInvoiceCode() {
        for (int i = 0; i < LENGTH; i++) {
            int character = RANDOM.nextInt(ALPHA_NUMERIC_STRING.length());
            CODE.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return CODE.toString();
    }
}

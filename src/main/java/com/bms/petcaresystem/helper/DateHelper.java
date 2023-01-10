package com.bms.petcaresystem.helper;

import com.bms.petcaresystem.helper.message.BusinessMessage;

import java.time.LocalDateTime;

public class DateHelper {
    private DateHelper() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}

package com.billennium.petproject.util;
import org.joda.time.DateTime;

import java.util.Date;

public class DateTimeUtils {

    public static Date now() {
        return (new DateTime()).toDate();
    }
}

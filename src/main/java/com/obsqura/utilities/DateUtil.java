package com.obsqura.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final DateUtil dateUtilInstance = new DateUtil();
    final static DateFormat df = new SimpleDateFormat("MM/DD/YYYY");

    public DateUtil() {
    }

    public static DateUtil getInstance(){
        return dateUtilInstance;
    }

    public String getSystemCurrentDate(){
        Date date = new Date();
        return df.format(date);
    }

}

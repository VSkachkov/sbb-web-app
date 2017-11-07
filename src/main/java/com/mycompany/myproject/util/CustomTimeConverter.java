package com.mycompany.myproject.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class CustomTimeConverter {

    public Time convertFromDString(String timeString) throws ParseException{
        Time temp;
        SimpleDateFormat sdf = new SimpleDateFormat("HHMM");
        try{
            long ms = sdf.parse(timeString).getTime();
            temp = new java.sql.Time(ms);
        }
        catch (ParseException e){
            throw e;
        }
    return temp;
    }

}

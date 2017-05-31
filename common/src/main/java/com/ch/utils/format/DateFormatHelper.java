package com.ch.utils.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by apple on 2017/5/30.
 */
public class DateFormatHelper {
    private DateFormatHelper(){}
    private  final static String FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    public static String date2str(long time){
        Date date = new Date(time);
        DateFormat dateFormat = new SimpleDateFormat(FORMAT_STR);
        return dateFormat.format(date);
    }

//    public static long str2long(String str){
//        DateFormat dateFormat = new SimpleDateFormat(FORMAT_STR);
//    }
}

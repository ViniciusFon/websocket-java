package br.com.demowebsocket.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatUtils {

    private static DateFormat sdf_DT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static DateFormat sdf_D = new SimpleDateFormat("dd/MM/yyyy");
    private static final String doubleFormat = "%1$,.1f";
    private static final String floatFormat = "%1$,.1f";

    public static String parseDate(Date date) {
        return parseDate(date, true);
    }

    public static String parseDate(Date date, Boolean putHifen) {
        return date == null ? putHifen ? "-" : "" : sdf_D.format(date);
    }

    public static String parseDateTime(Date date) {
        return parseDateTime(date, true);
    }

    public static String parseDateTime(Date date, Boolean putHifen) {
        return date == null ? putHifen ? "-" : "" : sdf_DT.format(date);
    }

    public static String parseString(Object object) {
        return parseString(String.valueOf(object), true);
    }

    public static String parseString(Object object, Boolean putHifen) {
        return parseString(String.valueOf(object), putHifen);
    }

    public static String parseString(String string) {
        return parseString(string, true);
    }

    public static String parseString(String string, Boolean putHifen) {
        return ValidatorUtils.isNullOrEmpty(string) ? putHifen ? "-" : "" : string;
    }

    public static String parseDouble(Double dbl) {
        return parseDouble(dbl, true);
    }

    public static String parseDouble(Double dbl, Boolean putHifen) {
        return dbl == null || dbl.isNaN() || dbl.isInfinite() ? putHifen ? "-" : "" : String.valueOf(dbl);
    }

    public static String parseFloat(Float fl) {
        return parseFloat(fl, true);
    }

    public static String parseFloat(Float fl, Boolean putHifen) {
        return fl == null || fl.isNaN() || fl.isInfinite() ? putHifen ? "-" : "" : String.valueOf(fl);
    }

    public static String parseDoubleAndFormat(Double dbl) {
        return parseDoubleAndFormat(dbl, true);
    }

    public static String parseDoubleAndFormat(Double dbl, Boolean putHifen) {
        return dbl == null || dbl.isNaN() || dbl.isInfinite() ? putHifen ? "-" : "" : String.format(doubleFormat, dbl);
    }

    public static String parseFloatAndFormat(Float fl) {
        return parseFloatAndFormat(fl, true);
    }

    public static String parseFloatAndFormat(Float fl, Boolean putHifen) {
        return fl == null || fl.isNaN() || fl.isInfinite() ? putHifen ? "-" : "" : String.format(new Locale("en_US"), floatFormat, fl);
    }

    public static Date parseDate(String date, String format) {
        DateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        Date dt = null;
        try {
            dt = sdf.parse(date);
        } catch (ParseException e) {
            dt=null;
        }
        return dt;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T parser(Object obj, Class clazz) {
        T value = null;
        if (obj == null) {
            return null;
        } else {
            if (clazz.isAssignableFrom(String.class)) {
                value = (T) obj.toString();
            } else if (clazz.isAssignableFrom(Integer.class)) {
                value = (T) Integer.valueOf(obj.toString());
            } else if (clazz.isAssignableFrom(Boolean.class)) {
                value = (T) Boolean.valueOf(obj.toString());
            } else if (clazz.isAssignableFrom(Double.class)) {
                value = (T) Double.valueOf(obj.toString());
            } else if (clazz.isAssignableFrom(Long.class)) {
                value = (T) Long.valueOf(obj.toString());
            } else if (clazz.isAssignableFrom(Short.class)) {
                value = (T) Short.valueOf(obj.toString());
            } else if (clazz.isAssignableFrom(Date.class)) {
                value = (T) obj;
            }
        }
        return value;
    }
}

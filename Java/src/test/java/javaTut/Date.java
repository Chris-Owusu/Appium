package javaTut;

import java.text.SimpleDateFormat;

public class Date {

    public static void main(String[] args) {
        java.util.Date d = new java.util.Date();
        System.out.println(d.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        System.out.println(sdf.format(d));

        SimpleDateFormat sd = new SimpleDateFormat("M/d/yyyy hh:mm:ss");
        System.out.println(sd.format(d));
    }
}

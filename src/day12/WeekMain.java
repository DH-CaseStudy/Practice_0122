package day12;

import java.util.Calendar;

public class WeekMain {
    public static void main(String[] args) {
        Week today = null;

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.DAY_OF_MONTH);
        int dayofweek = now.get(Calendar.DAY_OF_WEEK);
        int day = now.get(Calendar.DAY_OF_WEEK);
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int seconds = now.get(Calendar.SECOND);

        switch (dayofweek){
            case 1 : today = Week.SUNDAY; break;
            case 2 : today = Week.Monday; break;
            case 3 : today = Week.TUESDAY; break;
            case 4 : today = Week.WEDNESDAY; break;
            case 5 : today = Week.THURSDAY; break;
            case 6 : today = Week.FRIDAY; break;
            case 7 : today = Week.SATURDAY; break;
        }

        if(today == Week.THURSDAY){
            System.out.println("오늘은 목요일~!");
        }
    }
}

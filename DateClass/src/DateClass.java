import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateClass {
    private Calendar calendar;

    //Constructor for MM/DD/YYYY format
    public DateClass(int month, int day, int year) {
        calendar = Calendar.getInstance();
        calendar.set(year, month -1, day); // Month is 0-based on Calendar
    }

    // Constructor for "Month Day. Year" format
    public DateClass(String month, int day, int year) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM", Locale.ENGLISH);
            Date date = sdf.parse(month);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.YEAR, year);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Constructor for DDD YYYY format
     public DateClass(int dayOfYear, int year) {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
    }

    //Method to output date in MM/DD/YYYY format
    public String toMMDDYYYY() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(calendar.getTime());
    }

    //Method to output date in "Month Day, Year" format
    public String toLongFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        return sdf.format(calendar.getTime());
    }

    //Method to output date in DDD YYYY format
    public String toDDDYYYY() {
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int year = calendar.get(Calendar.YEAR);
        return String.format("%03d %d", dayOfYear, year);
    }

    public static void main(String[] args) {
        //Test the Date class
        DateClass date1 = new DateClass(7, 24, 2012);
        System.out.println("MM/DD/YYYY: " + date1.toMMDDYYYY());
        System.out.println("Long Format: " + date1.toLongFormat());
        System.out.println("DDD YYYY: " + date1.toDDDYYYY());

        DateClass date2 = new DateClass("July", 24, 2012);
        System.out.println("MM/DD/YYYY: " + date2.toMMDDYYYY());
        System.out.println("Long Format: " + date2.toLongFormat());
        System.out.println("DDD YYYY: " + date2.toDDDYYYY());

        DateClass date3 = new DateClass(206, 2012); //206th day of year 2012 a leap year
         System.out.println("MM/DD/YYYY: " + date3.toMMDDYYYY());
         System.out.println("Long Format: " + date3.toLongFormat());
         System.out.println("DDD YYYY: " + date3.toDDDYYYY());
    }
}

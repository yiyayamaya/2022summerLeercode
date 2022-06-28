import java.util.Date;

public class Test {
    public static void main(String[] args) {

    }


    int calculateDaysBetweenDates(Date StartDate, Date EndDate) {
        long startTime = StartDate.getTime();
        long endTime = EndDate.getTime();
        long diff = endTime - startTime;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        return (int) diffDays;
    }
}

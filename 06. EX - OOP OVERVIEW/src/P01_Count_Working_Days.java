import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01_Count_Working_Days {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate start = LocalDate.parse(reader.readLine(), formatter);
        LocalDate end = LocalDate.parse(reader.readLine(), formatter);

        List<LocalDate> holidays = new ArrayList<>();
        holidays.add(LocalDate.of(2018,1, 1));
        holidays.add(LocalDate.of(2018,3, 3));
        holidays.add(LocalDate.of(2018,5, 1));
        holidays.add(LocalDate.of(2018,5, 6));
        holidays.add(LocalDate.of(2018,5, 24));
        holidays.add(LocalDate.of(2018,9, 6));
        holidays.add(LocalDate.of(2018,9, 22));
        holidays.add(LocalDate.of(2018,11, 1));
        holidays.add(LocalDate.of(2018,12, 24));
        holidays.add(LocalDate.of(2018,12, 25));
        holidays.add(LocalDate.of(2018,12, 26));

        long days = ChronoUnit.DAYS.between(start, end);

        int workingDays = 0;
        for (int i = 0; i <= days; i++) {
            boolean workday = checkIfHoliday(start, holidays);

            if (!workday ) {
                workingDays++;
            }
            start = start.plusDays(1);
        }
        System.out.println(workingDays);
    }

    private static boolean checkIfHoliday(LocalDate date, List<LocalDate> holidays) {
        for (int i = 0; i < holidays.size(); i++) {
            if (holidays.get(i).getMonth() == date.getMonth() &&
                    holidays.get(i).getDayOfMonth() == date.getDayOfMonth()) {
                return true;
            }
        }

        if ((date.getDayOfWeek().getValue() == 6) ||
                (date.getDayOfWeek().getValue() == 7)) {
            return true;
        } else {
            return false;
        }
    }
}

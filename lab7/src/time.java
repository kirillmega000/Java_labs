import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class time {
    public static String gettime(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  HH:mm");
        ZoneId zone = ZoneId.of("Europe/Moscow");
        Instant instant = Instant.now();
        ZonedDateTime zdt = instant.atZone(zone);
        String out = zdt.format(format);
         return out;
    }
}

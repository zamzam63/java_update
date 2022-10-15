package datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class AntarcticaTimeZones {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        List<ZonedDateTime> antarcticZones =
                ZoneId.getAvailableZoneIds().stream()  // Stream<String>
                        .filter(regionId -> regionId.contains("Antarctica"))
                        .map(ZoneId::of)  // Stream<ZoneId>
                        .map(now::atZone) // Stream<ZonedDateTime>
                        .sorted(comparingInt(
                                zoneId -> zoneId.getOffset().getTotalSeconds()))
                        .collect(Collectors.toList());

        antarcticZones.forEach(zdt ->
                System.out.printf("%7s: %25s %7s%n", zdt.getOffset(), zdt.getZone(),
                        zdt.getZone().getRules().isDaylightSavings(zdt.toInstant())));
    }
}

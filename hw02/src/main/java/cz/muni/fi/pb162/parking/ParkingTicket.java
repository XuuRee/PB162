package cz.muni.fi.pb162.parking;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Class represents ticket which belongs to {@link cz.muni.fi.pb162.parking.impl.Car}.
 * @author msabo
 */
public class ParkingTicket {

    private Date validUnTil;

    /**
     * Creates Parking ticket, valid from now.
     * @param daysValid how many days is ticket valid
     */
    public ParkingTicket(int daysValid) {
        this.validUnTil = addDays(now(), daysValid);
    }

    /**
     * Checks if the ticket has expired.
     * @return true if expired, false otherwise
     */
    public boolean hasExpired() {
        return validUnTil.before(now());
    }

    /**
     * Returns date moved daysValid ahead.
     * @param from time which should be moved ahead
     * @param daysValid number of days
     * @return date moved daysValid days ahead
     */
    private Date addDays(Date from, int daysValid) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(from);
        calendar.add(Calendar.DATE, daysValid);
        return calendar.getTime();
    }

    /**
     * Current time.
     * @return current time
     */
    private Date now() {
        return new GregorianCalendar().getTime();
    }

}

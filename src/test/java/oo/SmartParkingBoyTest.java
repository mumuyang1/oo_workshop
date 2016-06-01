package oo;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SmartParkingBoyTest {
    @Test
    public void should_park_success_in_parkLot_with_the_max_rest_space_rate() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(2);
        parkingLot1.park(new Car("1"));

        ParkingLot parkingLot2 = new ParkingLot(3);
        parkingLot2.park(new Car("2"));

        Car car = new Car("3");

        ParkingStrategy smartParkingStrategy = new SmartParkingStrategy();
        ParkingBoy smartParkingBoy = new ParkingBoy(smartParkingStrategy, parkingLot1, parkingLot2);
        Optional<String> ticket = smartParkingBoy.park(car);

        assertThat(ticket.isPresent(), is(true));
        assertThat(parkingLot2.unPark(ticket.get()).get(), is(car));
    }
}

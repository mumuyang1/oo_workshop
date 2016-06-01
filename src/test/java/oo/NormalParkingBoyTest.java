package oo;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NormalParkingBoyTest {

    @Test
    public void should_park_success_in_the_parkLot_with_max_rest_space() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);

        ParkingStrategy normalParkingStrategy = new NormalParkingStrategy();
        ParkingBoy normalParkingBoy = new ParkingBoy(normalParkingStrategy, parkingLot1, parkingLot2);

        Car car = new Car("1");
        Optional<String> ticket = normalParkingBoy.park(car);

        assertThat(ticket.isPresent(), is(true));
        assertThat(parkingLot2.unPark(ticket.get()).get(), is(car));
    }
}

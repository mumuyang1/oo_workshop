package oo;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public class ParkBoy {

    private final List<ParkLot> parkLots;
    private ParkStrategy parkStrategy;

    public ParkBoy(ParkStrategy parkStrategy, ParkLot... parkLots) {
        this.parkStrategy = parkStrategy;
        this.parkLots = Lists.newArrayList(parkLots);
    }

    public Optional<String> park(Car car) {
        ParkLot parkLot = this.parkStrategy.findParkLot(parkLots);
        return parkLot.park(car);
    }

    public Optional<Car> unPark(String ticket) {
        return this.parkLots.stream().map(parkLot -> parkLot.unPark(ticket)).
                filter(car -> car.isPresent()).
                findFirst().
                orElse(Optional.empty());
    }


    public List<ParkLot> getParkLots() {
        return parkLots;
    }
}

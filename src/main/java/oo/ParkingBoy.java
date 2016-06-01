package oo;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {

    private final List<ParkingLot> parkingLots;
    private ParkingStrategy parkingStrategy;

    public ParkingBoy(ParkingStrategy parkingStrategy, ParkingLot... parkingLots) {
        this.parkingStrategy = parkingStrategy;
        this.parkingLots = Lists.newArrayList(parkingLots);
    }

    public Optional<String> park(Car car) {
        ParkingLot parkingLot = this.parkingStrategy.findParkLot(parkingLots);
        return parkingLot.park(car);
    }

    public Optional<Car> unPark(String ticket) {
        return this.parkingLots.stream().map(parkLot -> parkLot.unPark(ticket)).
                filter(car -> car.isPresent()).
                findFirst().
                orElse(Optional.empty());
    }


    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}

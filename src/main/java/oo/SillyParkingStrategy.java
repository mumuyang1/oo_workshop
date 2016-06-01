package oo;

import java.util.List;

public class SillyParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingLot findParkLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().
                filter(p -> p.getRestSpace() > 0).
                findFirst().
                orElse(parkingLots.get(0));
    }
}

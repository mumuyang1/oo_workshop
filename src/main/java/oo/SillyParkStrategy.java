package oo;

import java.util.List;

public class SillyParkStrategy implements ParkStrategy {

    @Override
    public ParkLot findParkLot(List<ParkLot> parkLots) {
        return parkLots.stream().
                filter(p -> p.getRestSpace() > 0).
                findFirst().
                orElse(parkLots.get(0));
    }
}

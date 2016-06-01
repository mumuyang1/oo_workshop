package oo;

import com.google.common.collect.Lists;

import java.util.List;

public class NormalParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingLot findParkLot(List<ParkingLot> parkingLots) {
        return Lists.newArrayList(parkingLots).
                stream().
                sorted((o1, o2) -> Integer.compare(o2.getRestSpace(), o1.getRestSpace())).
                findFirst().
                orElse(parkingLots.get(0));
    }
}

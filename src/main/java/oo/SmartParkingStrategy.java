package oo;

import com.google.common.collect.Lists;

import java.util.List;

public class SmartParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingLot findParkLot(List<ParkingLot> parkingLots) {
        return Lists.newArrayList(parkingLots).stream().
                sorted((o1, o2) -> Double.compare(o2.getRestSpaceRate(), o1.getRestSpaceRate())).
                findFirst().
                orElse(parkingLots.get(0));
    }
}

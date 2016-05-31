package oo;

import com.google.common.collect.Lists;

import java.util.List;

public class SmartParkStrategy implements ParkStrategy {

    @Override
    public ParkLot findParkLot(List<ParkLot> parkLots) {
        return Lists.newArrayList(parkLots).stream().
                sorted((o1, o2) -> Double.compare(o2.getRestSpaceRate(), o1.getRestSpaceRate())).
                findFirst().
                orElse(parkLots.get(0));
    }
}

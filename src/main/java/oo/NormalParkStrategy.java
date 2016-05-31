package oo;

import com.google.common.collect.Lists;

import java.util.List;

public class NormalParkStrategy implements ParkStrategy {

    @Override
    public ParkLot findParkLot(List<ParkLot> parkLots) {
        return Lists.newArrayList(parkLots).
                stream().
                sorted((o1, o2) -> Integer.compare(o2.getRestSpace(), o1.getRestSpace())).
                findFirst().
                orElse(parkLots.get(0));
    }
}

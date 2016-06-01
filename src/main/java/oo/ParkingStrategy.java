package oo;

import java.util.List;

public interface ParkingStrategy {

    ParkingLot findParkLot(List<ParkingLot> parkingLots);
}

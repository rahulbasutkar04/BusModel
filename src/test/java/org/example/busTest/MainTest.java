package org.example.busTest;

import org.example.bus.Bus;
import org.example.bus.NoVacantSeatException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

//    @Test
//    void shouldCreateInstnaceOfBus() {
//        Bus bus = new Bus();
//
//        assertEquals(true, bus instanceof Bus);
//    }


    @Test
    void shouldCheckInitialCapacityIsZeroORNot() {
        Bus bus = new Bus(0);

        assertEquals(0, bus.getCapacity());
    }

    @Test
    void shouldCheckCapacityOfBusGreaterOrNot() {
        Bus bus = new Bus(30);

        assertEquals(30, bus.getCapacity());
    }

    @Test
    void shouldCheckInitialVacancyIsEqualToCapacity() {
        Bus bus = new Bus(30);
        bus.setVacancy(bus.getCapacity());
        assertEquals(30, bus.getVacancy());
    }


    @Test
    void shouldCheckInitiallyBusIsEmpty() {
        Bus bus = new Bus(30);

        assertEquals(0, bus.CheckIfBusIsEmpty());
    }


    @Test
    void shouldCreatePassengerMethodToOnBoardThemWithProperties() throws NoVacantSeatException {
        Bus bus = new Bus(30);

        bus.setVacancy(bus.getCapacity());

        bus.OnBoardPassenger(1, "RahulB", 20);

        Map<Integer, String> expectedPassengerMap = new HashMap<>();
        expectedPassengerMap.put(1, "RahulB");

        assertEquals(expectedPassengerMap, bus.getPassenger());
    }


    @Test
    void shouldCheckFareIsMappedOrNotCorrectly() throws NoVacantSeatException {
        Bus bus = new Bus(30);

        bus.setVacancy(bus.getCapacity());

        bus.OnBoardPassenger(1, "RahulB", 20);

        Map<Integer, Float> expectedFareMap = new HashMap<>();
        expectedFareMap.put(1, 20.0f);

        assertEquals(expectedFareMap, bus.getFareMap());
    }


    @Test
    void shouldReturnCorrectTotalFares() throws NoVacantSeatException {

        Bus bus = new Bus(30);

        bus.setVacancy(bus.getCapacity());

        bus.OnBoardPassenger(1, "RahulB", 20);
        bus.OnBoardPassenger(2, "RahulB", 40);
        bus.OnBoardPassenger(3, "RahulB", 60);
        bus.OnBoardPassenger(4, "RahulB", 10);
        bus.OnBoardPassenger(5, "RahulB", 30);

        assertEquals(160.0,bus.getTotalfare());


    }

    @Test
    void shouldThrowErrorIfNoVacantSeatISAvailable(){
        Bus bus = new Bus(30);

        bus.setVacancy(0);
        Exception exception = assertThrows(NoVacantSeatException.class, () -> bus.OnBoardPassenger(1, "RahulB", 20));
        assertEquals("No vacant Seat Available", exception.getMessage());
    }

    @Test
    void shouldDisPlayAllPassengersName() throws NoVacantSeatException {
        Bus bus = new Bus(30);

        bus.setVacancy(bus.getCapacity());

        bus.OnBoardPassenger(1, "RahulB", 20);
        bus.OnBoardPassenger(2, "Shubham", 40);
        bus.OnBoardPassenger(3, "John", 60);
        bus.OnBoardPassenger(4, "Sachin", 10);
        bus.OnBoardPassenger(5, "Amey", 30);

        List<String> expectedPassengerNames = Arrays.asList("RahulB", "Shubham", "John", "Sachin", "Amey");
        List<String> actualPassengerNames = bus.displayPassenger();

        assertEquals(expectedPassengerNames, actualPassengerNames);
    }


}









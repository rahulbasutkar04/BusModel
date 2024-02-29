package org.example.bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Bus {

    private int capacity;
    private int vacancy;
    private Map<Integer, String> passenger = new HashMap<>();
    private Map<Integer, Float> fareMap = new HashMap<>();
    float totalfare;

    public Bus(int capacity) {
        this.capacity = capacity;
        this.vacancy = capacity; // Initialize vacancy to full capacity
    }

    public int getCapacity() {
        return capacity;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy)
    {
        this.vacancy=vacancy;
    }

    public Map<Integer, Float> getFareMap() {
        return fareMap;
    }

    public Map<Integer, String> getPassenger() {
        return passenger;
    }


    public int CheckIfBusIsEmpty() {

        return passenger.size();
    }


    public float getTotalfare() {
        return totalfare;
    }

    public void setTotalfare(float totalfare) {
        this.totalfare = totalfare;
    }

    public void OnBoardPassenger(int id, String name, float fare) throws NoVacantSeatException {
        if (!passenger.containsKey(id) && vacancy > 0) {
            passenger.put(id, name);
            fareMap.put(id, fare);
            totalfare += fare;
            setTotalfare(totalfare);
            vacancy--;
        } else {
            throw new NoVacantSeatException("No vacant Seat Available");
        }
    }


    public List<String> displayPassenger() {
        List<String> data = new ArrayList<>();
        if (!passenger.isEmpty()) {
            for (Map.Entry<Integer, String> entry : passenger.entrySet()) {
                data.add(entry.getValue());
            }
        }
        return data;

    }

}





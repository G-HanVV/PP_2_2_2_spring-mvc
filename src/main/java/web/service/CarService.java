package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarService {
    private List<Car> carList;

    {
        carList = List.of(
                new Car("Car1", 1991, "blue"),
                new Car("Car2", 1992, "red"),
                new Car("Car3", 1993, "yellow"),
                new Car("Car4", 1994, "green"),
                new Car("Car5", 1995, "brown")
        );
    }

    public List<Car> getCars(String count) {
        return carList.subList(0, count == null ? carList.size() : Math.min(Integer.parseInt(count), carList.size()));
    }
}

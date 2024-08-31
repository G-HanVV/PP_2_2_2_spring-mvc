package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {
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

    @GetMapping(value = "")
    public String startCar(@RequestParam(required = false) String count, ModelMap model){
        model.addAttribute("cars",
                carList.stream()
                        .limit(Integer.parseInt(count == null ? String.valueOf(carList.size()) : count))
                        .toList());
        return "cars";
    }
}

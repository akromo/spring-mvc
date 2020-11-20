package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cars.add(new Car("model" + i, i, 1980 + i));
        }
        if (count == null || count >= 5) {
            model.addAttribute("cars", cars);
        } else {
            model.addAttribute("cars", cars.subList(0, count));
        }
        return "cars";
    }
}

package hello.dev.cities;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CitiesController {

    @RequestMapping("/cities")
    public List<City> getCities(){
        return Arrays.asList(
                new City(400000, "Cherkassy"),
                new City(5000000, "Kyiv"),
                new City(350000, "Odessa")
        );
    }
}

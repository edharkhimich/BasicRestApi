package hello.dev.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping("/countries")
    public List<Country> getCountries(){
        return countryService.getAllCountries();
    }

    @RequestMapping("/countries/{name}")
    public Country getOneCountry(@PathVariable String name){
        return countryService.getCountry(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/countries")
    public void addCountry(@RequestBody Country country){
        countryService.addCountry(country);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/countries/{name}")
    public void putCountry(@PathVariable String name, @RequestBody Country country){
        countryService.update(name, country);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/countries/{name}")
    public void putCountry(@PathVariable String name){
        countryService.delete(name);
    }



}

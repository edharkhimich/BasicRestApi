package hello.dev.countries;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {

    private List<Country> countries = new ArrayList<>(Arrays.asList(
            new Country("Ukraine", 42000000),
            new Country("Russia", 200000000)
    ));

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getCountry(String name) {
        return countries.stream()
                .filter(country -> country.getName().toLowerCase().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addCountry(Country country) {
        countries.add(country);
    }


    public void update(String name, Country c) {
        for (int i = 0; i < countries.size(); i++) {
            Country country = countries.get(i);
            if (country.getName().toLowerCase().equals(name)) {
                countries.set(i, c);
                return;
            }
        }
    }

    public void delete(String name) {
        countries.removeIf(country -> country.getName().toLowerCase().equals(name));
    }
}

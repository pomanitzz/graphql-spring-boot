package ua.pomanytskyi.graphqlspringboot.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Class for create just some init data
 */
@Component
public class DatabaseMockDataInitService implements CommandLineRunner {

    private final VehicleService vehicleService;

    public DatabaseMockDataInitService(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    /**
     * Just some init data
     */
    @Override
    public void run(String... args) throws Exception {
        this.vehicleService.createVehicle("Bus", "Minibus", "Skoda", "2020-08-07");
        this.vehicleService.createVehicle("Bus", "Single deck", "Ikarus", "1999-02-04");
        this.vehicleService.createVehicle("Car", "Cayenne", "Porsche", "2011-01-11");
    }
}

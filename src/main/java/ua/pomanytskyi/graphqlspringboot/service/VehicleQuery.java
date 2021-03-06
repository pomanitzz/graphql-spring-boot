package ua.pomanytskyi.graphqlspringboot.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import ua.pomanytskyi.graphqlspringboot.data.VehicleDto;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link GraphQLQueryResolver}.
 * In current implementation used just for get vehicles or get vehicle by id.
 * @author a.pomanytskyi
 */
@Component
public class VehicleQuery implements GraphQLQueryResolver {

    private final VehicleService vehicleService;

    public VehicleQuery(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    /**
     * Mapped in vehicleql.graphgls in: Query#vehicles
     */
    public List<VehicleDto> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }

    /**
     * Mapped in vehicleql.graphgls in: Query#vehicle
     */
    public Optional<VehicleDto> getVehicle(final long id) {
        return this.vehicleService.getVehicle(id);
    }
}

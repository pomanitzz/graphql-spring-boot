package ua.pomanytskyi.graphqlspringboot.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import ua.pomanytskyi.graphqlspringboot.data.VehicleDto;

/**
 * Implementation of {@link GraphQLMutationResolver}.
 * In current implementation used just for create vehicle.
 * @author a.pomanytskyi
 */
@Component
public class VehicleMutation implements GraphQLMutationResolver {

    private final VehicleService vehicleService;

    public VehicleMutation(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    /**
     * Mapped in vehicleql.graphgls in: Mutation#createVehicle
     */
    public VehicleDto createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }
}

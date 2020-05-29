package ua.pomanytskyi.graphqlspringboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pomanytskyi.graphqlspringboot.dao.VehicleRepository;
import ua.pomanytskyi.graphqlspringboot.data.Vehicle;
import ua.pomanytskyi.graphqlspringboot.data.VehicleDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public VehicleDto createVehicle(final String type,final String modelCode, final String brandName, final String launchDate) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return convert(vehicleRepository.save(vehicle));
    }

    @Transactional(readOnly = true)
    public List<VehicleDto> getAllVehicles(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count)
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<VehicleDto> getVehicle(final long id) {
        return convert(vehicleRepository.findById(id));
    }

    private Optional<VehicleDto> convert(Optional<Vehicle> vehicle) {
        return vehicle.map(this::convert);
    }

    private VehicleDto convert(Vehicle vehicle) {
        VehicleDto dto = new VehicleDto();
        dto.setId(vehicle.getId());
        dto.setType(vehicle.getType());
        dto.setModelCode(vehicle.getModelCode());
        dto.setBrandName(vehicle.getBrandName());
        dto.setLaunchDate(vehicle.getLaunchDate());
        return dto;
    }
}

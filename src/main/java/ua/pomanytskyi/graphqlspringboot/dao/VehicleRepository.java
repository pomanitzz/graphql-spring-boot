package ua.pomanytskyi.graphqlspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.pomanytskyi.graphqlspringboot.data.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}

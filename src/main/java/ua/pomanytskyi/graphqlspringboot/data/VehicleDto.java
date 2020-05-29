package ua.pomanytskyi.graphqlspringboot.data;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VehicleDto {

    private Long id;

    private String type;

    private String modelCode;

    private String brandName;

    private LocalDate launchDate;
}

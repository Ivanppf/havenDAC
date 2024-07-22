package com.ippf.havendac.model.entities;

import com.ippf.havendac.model.ENUM.PropertyType;
import com.ippf.havendac.presentation.DTO.request.PropertyRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_property")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PropertyType type;
    @Column(name = "isAvailable", nullable = false)
    private Boolean isAvailable;
    @Column(name = "isCountryside", nullable = false)
    private Boolean isCountryside;
    @Column(name = "hasSwimmingPool", nullable = false)
    private Boolean hasSwimmingPool;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Property(PropertyRequestDTO propertyRequestDTO) {
        description = propertyRequestDTO.description();
        type = propertyRequestDTO.propertyType();
        isAvailable = propertyRequestDTO.isAvailable();
        isCountryside = propertyRequestDTO.isCountryside();
        hasSwimmingPool = propertyRequestDTO.hasSwimmingPool();
    }

    public Property(Integer id,
                    PropertyType type,
                    Boolean isAvailable,
                    Boolean isCountryside,
                    Boolean hasSwimmingPool) {
        this.id = id;
        this.type = type;
        this.isAvailable = isAvailable;
        this.isCountryside = isCountryside;
        this.hasSwimmingPool = hasSwimmingPool;
    }

}

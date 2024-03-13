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
public class Property implements HavenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PropertyType type;
    @Column(name = "isAvailable", nullable = false)
    private boolean isAvailable;
    @Column(name = "isCountryside", nullable = false)
    private boolean isCountryside;
    @Column(name = "hasSwimmingPool", nullable = false)
    private boolean hasSwimmingPool;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Property(PropertyRequestDTO propertyRequestDTO) {
        description = propertyRequestDTO.description();
        type = propertyRequestDTO.type();
        isAvailable = propertyRequestDTO.isAvailable();
        isCountryside = propertyRequestDTO.isCountryside();
        hasSwimmingPool = propertyRequestDTO.hasSwimmingPool();
    }

}

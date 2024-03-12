package com.ippf.havendac.model.entities;

import com.ippf.havendac.model.ENUM.PropertyType;
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

    public Property(String description, PropertyType type, boolean isAvailable, boolean isCountryside, boolean hasSwimmingPool) {
        this.description = description;
        this.type = type;
        this.isAvailable = isAvailable;
        this.isCountryside = isCountryside;
        this.hasSwimmingPool = hasSwimmingPool;
    }

}

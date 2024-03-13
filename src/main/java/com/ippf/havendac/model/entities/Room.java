package com.ippf.havendac.model.entities;

import com.ippf.havendac.presentation.DTO.request.RoomRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_room")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Room implements HavenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private float length;
    @Column(nullable = false)
    private float width;
    private float area;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "property_id", foreignKey = @ForeignKey(name = "property"), nullable = false)
    private Property property;

    public Room(RoomRequestDTO roomRequestDTO) {
        length = roomRequestDTO.length();
        width = roomRequestDTO.width();
    }
}

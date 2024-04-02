package com.ippf.havendac.model.entities;

import com.ippf.havendac.model.ENUM.RoomType;
import com.ippf.havendac.presentation.DTO.request.RoomRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tb_room")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Float length;
    @Column(nullable = false)
    private Float width;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType roomType;
    private Float area;
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "property_id", foreignKey = @ForeignKey(name = "property"), nullable = false)
    private Property property;

    public Room(RoomRequestDTO roomRequestDTO) {
        length = roomRequestDTO.length();
        width = roomRequestDTO.width();
        roomType = roomRequestDTO.roomType();
    }

    public Room(Integer roomId,
                Float area,
                RoomType roomType,
                Property property) {
        id = roomId;
        this.area = area;
        this.roomType = roomType;
        this.property = property;
    }
}

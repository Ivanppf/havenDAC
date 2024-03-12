package com.ippf.havendac.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_comodo")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Comodo implements HavenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private float comprimento;
    @Column(nullable = false)
    private float largura;
    private float area;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_imovel", foreignKey = @ForeignKey(name = "imovel"), nullable = false)
    private Imovel imovel;

    public Comodo(float comprimento, float largura, Imovel imovel) {
        this.comprimento = comprimento;
        this.largura = largura;
        this.imovel = imovel;
    }

    @Override
    public String toString() {
        return "Comodo{" +
                "id=" + id +
                ", comprimento=" + comprimento +
                ", largura=" + largura +
                ", area=" + area +
                ", imovel=" + imovel.getId() +
                '}';
    }
}

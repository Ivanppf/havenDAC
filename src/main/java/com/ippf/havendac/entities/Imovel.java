package com.ippf.havendac.entities;

import com.ippf.havendac.ENUM.TipoImovel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_imovel")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Imovel implements HavenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoImovel tipo;
    @Column(name = "disponivel", nullable = false)
    private boolean isDisponivel;
    @Column(name = "zona_rural", nullable = false)
    private boolean isZonaRural;
    @Column(name = "possui_piscina", nullable = false)
    private boolean possuiPiscina;
    @Column(columnDefinition = "TEXT")
    private String descricao;

    public Imovel(String descricao, TipoImovel tipo, boolean isDisponivel, boolean isZonaRural, boolean possuiPiscina) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.isDisponivel = isDisponivel;
        this.isZonaRural = isZonaRural;
        this.possuiPiscina = possuiPiscina;
    }

}

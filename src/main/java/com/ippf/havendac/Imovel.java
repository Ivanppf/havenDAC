package com.ippf.havendac;

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
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoImovel tipo;
    @Column(name = "disponivel")
    private boolean isDisponivel;
    @Column(name = "zona_rural")
    private boolean isZonaRural;
    @Column(name = "possui_piscina")
    private boolean possuiPiscina;

    public Imovel(String descricao, TipoImovel tipo, boolean isDisponivel, boolean isZonaRural, boolean possuiPiscina) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.isDisponivel = isDisponivel;
        this.isZonaRural = isZonaRural;
        this.possuiPiscina = possuiPiscina;
    }

}

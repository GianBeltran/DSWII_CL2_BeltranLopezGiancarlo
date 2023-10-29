package pe.edu.cibertec.DSWII_CL2_BeltranLopez.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "producto")
@Data @NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;

    @Column(name = "nombproducto")
    private String nombproducto;

    @Column(name = "descproducto")
    private String descproducto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "fecha_venc")
    private Date fecha_venc;
}

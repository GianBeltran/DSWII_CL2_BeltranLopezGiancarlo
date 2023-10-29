package pe.edu.cibertec.DSWII_CL2_BeltranLopez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL2_BeltranLopez.model.Producto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findByNombproducto(String nombproducto);

    List<Producto> findByNombproductoContainingIgnoreCase(String filtro);

    @Query("SELECT p FROM Producto p WHERE p.cantidad > 10 AND p.cantidad < 100")
    List<Producto> filtrarProductosPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM Producto WHERE WHERE YEAR(fecha_venc) = 2024", nativeQuery = true)
    List<Producto> filtrarProductosPorNombreSQL(@Param("filtro") String filtro);
}

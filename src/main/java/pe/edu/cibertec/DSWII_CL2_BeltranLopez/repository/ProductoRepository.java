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

    @Query("SELECT p FROM producto p WHERE p.nombproducto LIKE %:filtro%")
    List<Producto> filtrarProductosPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM producto WHERE nombproducto LIKE %:filtro%", nativeQuery = true)
    List<Producto> filtrarProductosPorNombreSQL(@Param("filtro") String filtro);
}

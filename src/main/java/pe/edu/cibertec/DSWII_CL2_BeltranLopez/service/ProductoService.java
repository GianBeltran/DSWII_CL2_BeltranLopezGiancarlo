package pe.edu.cibertec.DSWII_CL2_BeltranLopez.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL2_BeltranLopez.model.Producto;
import pe.edu.cibertec.DSWII_CL2_BeltranLopez.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {

    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }
    public Producto guardar(Producto category){
        return productoRepository.save(category);
    }
    public Optional<Producto> obtenerProductoPorId(Integer id){
        Optional<Producto> category = productoRepository.findById(id);
        if(category.isEmpty()){
            return Optional.empty();
        }else
            return category;
    }

    public Optional<Producto> obtenerProductoPorNombre(String nombproducto){
        Optional<Producto> category = productoRepository.findByNombproducto(nombproducto);
        if(category.isEmpty())
            return  Optional.empty();
        else
            return category;
    }

    public List<Producto> obtenerProductosPorFiltro(String filtro){
        return productoRepository.filtrarProductosPorNombreSQL(filtro);
    }
}

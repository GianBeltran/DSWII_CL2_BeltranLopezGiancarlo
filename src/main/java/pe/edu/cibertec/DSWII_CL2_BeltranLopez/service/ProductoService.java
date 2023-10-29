package pe.edu.cibertec.DSWII_CL2_BeltranLopez.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL2_BeltranLopez.model.Producto;
import pe.edu.cibertec.DSWII_CL2_BeltranLopez.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }
    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }
    public Optional<Producto> obtenerProductoPorId(Integer id){
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isEmpty()){
            return Optional.empty();
        }else
            return producto;
    }

/*
    public Optional<Producto> obtenerProductoPorNombre(String productoName){
        Optional<Producto> producto = productoRepository.findByProductoname(productoName);
        if(producto.isEmpty())
            return  Optional.empty();
        else
            return producto;
    }

    public List<Producto> obtenerProductosPorFiltro(String filtro){
        return productoRepository.filtrarProductosPorNombreSQL(filtro);
    }

*/
}

package pe.edu.cibertec.DSWII_CL2_BeltranLopez.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_CL2_BeltranLopez.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_CL2_BeltranLopez.model.Producto;
import pe.edu.cibertec.DSWII_CL2_BeltranLopez.service.ProductoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/producto")
@AllArgsConstructor
public class ProductoController {

    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> productoList = new ArrayList<>();
        productoService.listarProductos().forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable("id") Integer id){
        Producto producto = productoService.obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+ id + " no existe."));

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @GetMapping("/nombproducto/{filtro}")
    public ResponseEntity<List<Producto>> filtraroProductosPorNombre(@PathVariable("filtro") String filtro){
        List<Producto> productoList = new ArrayList<>();
        productoService.obtenerProductosPorFiltro(filtro).forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.guardar(producto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") Integer id, @RequestBody Producto producto){
        Producto oldProducto = productoService.obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+ id + " no existe."));
        oldProducto.setNombproducto(oldProducto.getNombproducto());
        oldProducto.setDescproducto(oldProducto.getDescproducto());
        oldProducto.setCantidad(oldProducto.getCantidad());
        return new ResponseEntity<>(productoService.guardar(oldProducto), HttpStatus.OK);
    }
}

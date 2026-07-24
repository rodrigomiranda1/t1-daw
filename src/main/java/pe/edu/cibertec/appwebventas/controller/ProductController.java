package pe.edu.cibertec.appwebventas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appwebventas.dto.ProductDto;
import pe.edu.cibertec.appwebventas.service.CategoryService;
import pe.edu.cibertec.appwebventas.service.ProductService;
import pe.edu.cibertec.appwebventas.service.SupplierService;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final CategoryService categoryService;
    private final SupplierService supplierService;
    private final ProductService productService;

    public ProductController(CategoryService categoryService, SupplierService supplierService, ProductService productService) {
        this.categoryService = categoryService;
        this.supplierService = supplierService;
        this.productService = productService;
    }
    @GetMapping
    public String index(Model model){
        model.addAttribute("listproduct",
                productService.listarProductos());
        return "product/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new ProductDto());
        model.addAttribute("listcategory",
                categoryService.listarCategorias());
        model.addAttribute("listsupplier",
                supplierService.listarProveedores());
        return "product/create";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id,
                       Model model){
        model.addAttribute("product",
                productService.buscarProductoPorId(id));
        model.addAttribute("listcategory",
                categoryService.listarCategorias());
        model.addAttribute("listsupplier",
                supplierService.listarProveedores());
        return "product/edit";
    }

    @PostMapping("/create")
    public String registrarProducto(Model model,
                                    @ModelAttribute("product") ProductDto dto){
        productService.registrarProducto(dto);
        return "redirect:/product";
    }

    @PostMapping("/edit")
    public String editarProducto(Model model,
                                    @ModelAttribute("product") ProductDto dto){
        productService.actualizarProducto(dto);
        return "redirect:/product";
    }


}

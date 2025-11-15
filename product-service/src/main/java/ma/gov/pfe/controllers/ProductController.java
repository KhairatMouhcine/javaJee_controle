package ma.gov.pfe.controllers;

import ma.gov.pfe.dtos.ProductDto;
import ma.gov.pfe.services.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping
    public List<ProductDto> selectProducts() {
        return productService.selectProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
}
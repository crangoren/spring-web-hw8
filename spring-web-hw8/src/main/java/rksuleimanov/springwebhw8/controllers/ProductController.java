package rksuleimanov.springwebhw8.controllers;

import org.springframework.web.bind.annotation.*;
import rksuleimanov.springwebhw8.data.Product;
import rksuleimanov.springwebhw8.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAllProds(){
        return productService.findAll();
    }

    @GetMapping("products/{id}")
    public Optional<Product> findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("/products/change_price")
    public void changePrice(@RequestParam Long productId, @RequestParam Integer delta){
        productService.changePrice(productId, delta);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

//    @GetMapping("/products/price_between")
//    public List<Product> findProductsByPriceBetween(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "100") Integer max) {
//        return productService.findByPriceBetween(min, max);
//    }

    @GetMapping("/products/filter")
    public List<Product> filterByPriceBetween(@RequestParam(defaultValue = "0") Integer min, Integer max) {
        return productService.filterByPriceBetween(min, max);
    }

}

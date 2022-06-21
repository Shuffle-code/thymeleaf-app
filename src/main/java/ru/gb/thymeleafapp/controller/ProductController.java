package ru.gb.thymeleafapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbapimay.product.dto.ProductDto;
import ru.gb.thymeleafapp.service.CartService;
import ru.gb.thymeleafapp.service.ProductService;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CartService cartService;

    @GetMapping("/all")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @PreAuthorize("hasAnyAuthority('product.read')")
    public String getProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @GetMapping("/authorizePage")
    public String authCartUser() {
        return "cart-authorize";
    }

//    @GetMapping
//    @PreAuthorize("hasAnyAuthority('product.create', 'product.update')")
//    public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {
//        Product product;
//        if (id != null) {
//            product = productService.findById(id);
//        } else {
//            product = new Product();
//        }
//        model.addAttribute("product", product);
//        return "product-form";
//    }
//
//    @GetMapping("/{productId}")
////    @PreAuthorize("isAnonymous()")
////    @PreAuthorize("hasAnyAuthority('product.read')")
//    public String info(Model model, @PathVariable(name = "productId") Long id) {
//        Product product;
//        if (id != null) {
//            product = productService.findById(id);
//        } else {
//            return "redirect:/product/all";
//        }
//        model.addAttribute("product", product);
//        return "product-info";
//    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('product.create', 'product.update')")
    public String saveProduct(ProductDto product) {
        product.setManufactureDate(LocalDate.now());
        productService.save(product);
        return "redirect:/product/all";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteByIdInCart(@PathVariable(name = "id") Long id) {
        cartService.removeProduct(id);
        return "redirect:/product/cart";
    }


    @GetMapping("/delete/{id}")
//    @PreAuthorize("hasAnyAuthority('product.delete')")
    public String deleteById(@PathVariable(name = "id") Long id) {
        productService.deleteById(id);
        return "redirect:/product/all";
    }

    @GetMapping("/cart")
    public String getCartList(Model model) {
        model.addAttribute("products", cartService.getProducts());

//        if(!cart.getStatus().equals("not empty")) cartService.save(cart);
        return "cart-list";
    }


    @GetMapping("/addToCart")
    public String addProductToCart(@RequestParam(name = "id") Long id){
//        cartService.save(new Cart());
        cartService.addProduct(id);
//        cartService.save(this.cartService.getCart());
        return "redirect:/product/all";
    }


}

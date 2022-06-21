package ru.gb.thymeleafapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.gbapimay.product.dto.ProductDto;
import java.util.Set;

@Service
@RequiredArgsConstructor
//@Getter
@Slf4j
public class CartService {
    private final Set<ProductDto> products;
    private final ProductService productService;

    public Set<ProductDto> getProducts() {
        return products;
    }

    public void addProduct(Long id) {
        if (products.stream().anyMatch((p) -> p.getId().equals(id))) return;
        products.add(productService.findById(id));
    }

    public void removeProduct(Long id) {
        products.stream()
                .filter((p) -> p.getId().equals(id))
                .findAny()
                .ifPresent(products::remove);
    }
}

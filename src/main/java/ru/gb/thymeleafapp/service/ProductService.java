package ru.gb.thymeleafapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.gbapimay.product.api.ProductGateway;
import ru.gb.gbapimay.product.dto.ProductDto;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
//    private final ProductDto productDto;
    private final ProductGateway productGateway;

    public List<ProductDto> getProductList() {
        return productGateway.getProductList();
    }

    public void save(ProductDto productDto) {
        if (productDto.getId() != null) {
            productGateway.handleUpdate(productDto.getId(), productDto);
        } else {
            productGateway.handlePost(productDto);
        }
    }

    public ProductDto findById(Long id) {
        return productGateway.getProduct(id).getBody();
    }

    public List<ProductDto> findAll() {
        return productGateway.getProductList();
    }

    public void deleteById(Long id) {
        productGateway.deleteById(id);
    }
}


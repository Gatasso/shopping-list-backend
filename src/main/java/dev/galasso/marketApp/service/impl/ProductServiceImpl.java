package dev.galasso.marketApp.service.impl;

import dev.galasso.marketApp.model.Product;
import dev.galasso.marketApp.repository.ProductRepository;
import dev.galasso.marketApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product createProduct(Product product) {
        if (product.getName() == null || product.getName().isEmpty()) {
            return null;
        }
        return (repository.save(product));
    }

    @Override
    public Product findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product alterProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Product product) {
    //TODO: implement this method
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public List<Product> getProductByKeyWord(String keyWord) {
        return repository.findAllByNameContaining(keyWord);
    }
}

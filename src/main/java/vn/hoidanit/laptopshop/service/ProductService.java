package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct(){
        List<Product> list = this.productRepository.findAll();
        return list;
    }
    
    public Product handleSaveProduct(Product product){
        Product productSave = this.productRepository.save(product);
        return productSave;
    }

    public Product getProductById(long id) {
        Product product = this.productRepository.findById(id);
        return product;
    }
    public int deleteProduct(long id){
        this.productRepository.deleteById(id);
        return 1;
    }

}

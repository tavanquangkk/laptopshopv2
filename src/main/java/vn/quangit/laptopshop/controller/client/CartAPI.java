package vn.quangit.laptopshop.controller.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.quangit.laptopshop.domain.request.CartRequest;
import vn.quangit.laptopshop.service.ProductService;

@RestController
public class CartAPI {
    private final ProductService productService;

    public CartAPI(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/add-product-to-cart")
    public ResponseEntity<Integer> addProductToCart(@RequestBody CartRequest cartRequest, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        productService.handleAddProductToCart2(session, cartRequest.getProductId(), cartRequest.getQuantity());
        int sum = (int) session.getAttribute("sum");
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }
}
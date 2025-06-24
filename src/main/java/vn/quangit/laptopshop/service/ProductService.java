package vn.quangit.laptopshop.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.quangit.laptopshop.domain.Cart;
import vn.quangit.laptopshop.domain.CartDetail;
import vn.quangit.laptopshop.domain.Product;
import vn.quangit.laptopshop.domain.Product_;
import vn.quangit.laptopshop.domain.User;
import vn.quangit.laptopshop.domain.dto.ProductCriteriaDTO;
import vn.quangit.laptopshop.repository.CartDetailRepository;
import vn.quangit.laptopshop.repository.CartRepository;
import vn.quangit.laptopshop.repository.ProductRepository;
import vn.quangit.laptopshop.repository.UserRepository;
import vn.quangit.laptopshop.service.specification.ProductSpecs;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;
    private final UserRepository userRepository;

   
    public ProductService(ProductRepository productRepository, CartRepository cartRepository,
            CartDetailRepository cartDetailRepository,UserService userService,UserRepository userRepository) 
        {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }
    private Specification<Product> buildPriceSpecification(List<String> prices) {
        Specification<Product> combineSpecifications = Specification.where(null);
        for (String p : prices) {
            double min = 0;
            double max = 0;
            switch (p) {
                case "duoi-10-trieu":
                    min = 0;
                    max = 10_000_000;
                    break;
                case "tu-10-15-trieu":
                    min = 10_000_000;
                    max = 15_000_000;
                    break;
                case "tu-15-20-trieu":
                    min = 15_000_000;
                    max = 20_000_000;
                    break;
                case "tren-20-trieu":
                    min = 20_000_000;
                    max = Double.MAX_VALUE;
                    break;
                default:
                    break;
            }
            if (max != 0) {
                combineSpecifications = combineSpecifications.or(ProductSpecs.queryByRangeOfPrice(min, max));
            }
        }
        return combineSpecifications;
    }



    
    public Page<Product> fetchProductsWithSpec(Pageable page, ProductCriteriaDTO productCriteriaDTO) {
        Specification<Product> combinedSpec = Specification.where(null);
        if(productCriteriaDTO.getTarget() == null && productCriteriaDTO.getFactory() == null && productCriteriaDTO.getPrice()==null){
            return this.productRepository.findAll(page);
        }
        if(productCriteriaDTO.getTarget() != null && productCriteriaDTO.getTarget().isPresent()){
            Specification currentSpec = ProductSpecs.queryByTargetNameList(productCriteriaDTO.getTarget().get());
            combinedSpec = combinedSpec.and(currentSpec);
        }
        if(productCriteriaDTO.getFactory()!=null &&productCriteriaDTO.getFactory().isPresent()){
            Specification currentSpec = ProductSpecs.queryByFactoryNameList(productCriteriaDTO.getFactory().get());
              combinedSpec = combinedSpec.and(currentSpec);
        }
        if(productCriteriaDTO.getPrice()!=null &&productCriteriaDTO.getPrice().isPresent()){
            Specification currentSpec = buildPriceSpecification(productCriteriaDTO.getPrice().get());
            combinedSpec = combinedSpec.and(currentSpec);
        }


       return this.productRepository.findAll(combinedSpec,page);
    }


    


    //pagination and filter  logic
    public Page<Product> getAllProductWithSpec(Pageable pageable,String name){
        Page<Product> list = this.productRepository.findAll(ProductSpecs.nameLike(name),pageable);
        return list;
    }
    public Page<Product> getAllProduct(Pageable pageable){
        Page<Product> list = this.productRepository.findAll(pageable);
        return list;
    }

    //filter logic
    //by min max price

    public Page<Product> getProductsByMinPrice(Pageable pageable,double min){
         Page<Product> list = this.productRepository.findAll(ProductSpecs.queryProductWithMinPriceConditions(min),pageable );
         return list;
    }
    public Page<Product> getProductsByMaxPrice(Pageable pageable,double max){
         Page<Product> list = this.productRepository.findAll(ProductSpecs.queryProductWithMaxPriceConditions(max),pageable );
          return list;
    }

    //filter by factory name

    public Page<Product> getProductsByFactoryName(Pageable pageable,String factoryName){
         Page<Product> list = this.productRepository.findAll(ProductSpecs.queryByFactoryName(factoryName),pageable);
         return list;
    }
    //by factory name list
    public Page<Product> getProductsByFactoryNameList(Pageable pageable,List<String> factoryNameList){
         Page<Product> list = this.productRepository.findAll(ProductSpecs.queryByFactoryNameList(factoryNameList),pageable);
         return list;
    }

    //filter by range of price

    public Page<Product> getProductsByRangeOfPrice(Pageable pageable,double startVl,double endVl){
         Page<Product> list = this.productRepository.findAll(ProductSpecs.queryByRangeOfPrice(startVl, endVl),pageable);
         return list;
    }
    public Page<Product> getProductsByRangesOfPrice(Pageable pageable,double startVl1,double endVl1,double startVl2,double endVl2){
         Page<Product> list = this.productRepository.findAll(ProductSpecs.queryByRangesOfPrice(startVl1, endVl1,startVl2,endVl2),pageable);
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

    public void handleAddProductToCart(String email,long productId,HttpSession session) {
      
        User user = this.userService.getUserByEmail(email);
        if(user != null){
            Cart cart = this.cartRepository.findByUser(user);
            if(cart == null){
                //create new cart
                Cart otherCart = new Cart();
                otherCart.setUser(user);
                otherCart.setSum(0);
               cart = this.cartRepository.save(otherCart);
            }

            //save cart_detail
            //find product by id

            Optional<Product> product = Optional.ofNullable(this.productRepository.findById(productId));
            if(product.isPresent()){
                Product realProduct = product.get();

                // check san pham da duoc them vao gio hang truoc day chua
                CartDetail oldDetail = this.cartDetailRepository.findByCartAndProduct(cart, realProduct);
                if(oldDetail == null){
                    CartDetail cartDetail = new CartDetail();
                    cartDetail.setCart(cart);
                    cartDetail.setProduct(realProduct);
                    cartDetail.setQuantity(1);
                    cartDetail.setPrice(realProduct.getPrice());
                    this.cartDetailRepository.save(cartDetail);

                    //update sum
                    int s = cart.getSum() +1;
                    cart.setSum(s);
                    this.cartRepository.save(cart);
                    session.setAttribute("sum",s );
                    //session.setAttribute("cartId","" );
                }else {
                    oldDetail.setQuantity(oldDetail.getQuantity() + 1);
                    this.cartDetailRepository.save(oldDetail);
                }
                
            }
            


        }
    
    }




   



    public void handleAddProductToCart2(HttpSession session, Long id, long quantity) {
        User user = userRepository.findByEmail(session.getAttribute("email").toString());
        if (Objects.isNull(user)) {
            System.out.println("User not found");
        }
        //Create new cart
        Cart cart = cartRepository.findByUser(user);
        if (Objects.isNull(cart)) {
            cart = new Cart();
            cart.setUser(user);
            cart.setSum(0);
            cart = cartRepository.save(cart);
        }
        //Save cart detail
        Product product = this.productRepository.findById(id).isPresent()?this.productRepository.findById(id).get() : new Product() ;
        CartDetail cartDetail = cartDetailRepository.findByCartAndProduct(cart, product);
        if (Objects.isNull(cartDetail)) {
            cartDetail = new CartDetail();
            cartDetail.setCart(cart);
            cartDetail.setProduct(product);
            cartDetail.setQuantity(quantity);
            cartDetail.setPrice(product.getPrice());

            //Update sum cart
            cart.setSum(cart.getSum() + 1);
            cartRepository.save(cart);
            session.setAttribute("sum", cart.getSum());
        } else {
            cartDetail.setQuantity(cartDetail.getQuantity() + quantity);
        }
        cartDetailRepository.save(cartDetail);
    }
}

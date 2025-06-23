package vn.quangit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.quangit.laptopshop.domain.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    
}

package org.sid.billingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.billingservice.model.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;

    public double getTotal(){
        double sum=0;
        for(ProductItem productItem:productItems){
            sum+=productItem.getPrice()*productItem.getQuantity();
        }
        return sum;
    }
}
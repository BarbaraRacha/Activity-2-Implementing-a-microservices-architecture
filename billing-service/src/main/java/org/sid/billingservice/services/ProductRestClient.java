package org.sid.billingservice.services;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping(path = "/products?projection=p1")
    public PagedModel<Product> allProducts();
    @GetMapping(path = "/products/{id}?projection=p1")
    public Product productById(@PathVariable(name = "id") Long id);
}

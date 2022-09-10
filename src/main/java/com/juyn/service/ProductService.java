/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.juyn.service;

import com.juyn.pojo.Product;
import java.util.List;

/**
 *
 * @author FPT SHOP
 */
public interface ProductService {
    List<Product> getProduct(String kw);
    boolean addOrUpdate(Product product);
}

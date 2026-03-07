package com.exercise.cart;

import com.exercise.cart.domain.Client;
import com.exercise.cart.domain.Individual;
import com.exercise.cart.domain.Professional;
import com.exercise.cart.enums.ProductType;
import com.exercise.cart.service.CartService;
import com.exercise.cart.service.DefaultPricingService;
import com.exercise.cart.service.PricingService;

public class Cart {
    public static void main(String[] args) {
        Client client1 = new Individual("C001", "Test", "Jean");
        Client client2 = new Professional("P001", "Company Test", "123456789", null, 8_000_000);
        Client client3 = new Professional("P002", "Company ABC", "987654321", null, 12_000_000);

        PricingService pricingService = new DefaultPricingService();
        CartService cart1 = new CartService(pricingService);
        cart1.addProduct(ProductType.HIGH, 1);
        cart1.addProduct(ProductType.MEDIUM, 2);
        cart1.addProduct(ProductType.LAPTOP, 3);

        System.out.println("Total C001: " + cart1.calculateTotal(client1) + " euros");
        System.out.println("Total P001: " + cart1.calculateTotal(client2) + " euros");
        System.out.println("Total P002: " + cart1.calculateTotal(client3) + " euros");

        // PS: Just an example, cf. Test classes for whole cases coverage
    }
}
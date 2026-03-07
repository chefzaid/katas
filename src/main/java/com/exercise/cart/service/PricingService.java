package com.exercise.cart.service;

import com.exercise.cart.domain.Client;
import com.exercise.cart.enums.ProductType;

public interface PricingService {
    double getPrice(Client client, ProductType productType);
}
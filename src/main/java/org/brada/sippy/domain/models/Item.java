package org.brada.sippy.domain.models;

import java.math.BigDecimal;

public record Item(String name, String category, BigDecimal unitPrice, Integer quantity) {

}

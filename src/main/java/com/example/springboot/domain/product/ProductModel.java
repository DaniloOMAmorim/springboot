package com.example.springboot.domain.product;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private float price;
    private long code;

    public ProductModel(RequestProductDTO data) {
        this.name = data.name();
        this.price = data.price();
        this.code = data.code();
    }
}

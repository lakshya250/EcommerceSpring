package org.example.EcommerceSpring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Category extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    //one category can have many products
    //This does not mean that you're trying to store a list of products inside category table
    //Telling JPA , the relationship is already owned by the product entity. So, just read from there.
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}

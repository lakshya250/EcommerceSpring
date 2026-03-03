package org.example.EcommerceSpring.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
@Builder
public class Product extends BaseEntity{
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private String title;
    private String brand;
    private boolean popular;

    //each product belongs to one category
    // or one category can have many products
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id", nullable = false)
    private Category category;
}

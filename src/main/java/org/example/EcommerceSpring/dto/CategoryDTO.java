package org.example.EcommerceSpring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

  private int id;
  private String title;
  private double price;
  private String description;
  private String category;
  private String image;
  private RatingDTO rating;
}

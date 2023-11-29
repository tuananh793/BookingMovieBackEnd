package com.example.booking.entity;

import java.util.List;

import com.example.booking.dto.FoodDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private long price;
    private int category;
    private String img;
    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderFood> orderFoods;

    public FoodDTO toDTO() {
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setId(this.id);
        foodDTO.setPrice(this.price);
        foodDTO.setName(this.name);
        foodDTO.setImg(img);
        // Add other fields if needed

        return foodDTO;
    }

}

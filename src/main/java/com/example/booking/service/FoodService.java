package com.example.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking.dto.FoodDTO;
import com.example.booking.entity.Food;
import com.example.booking.entity.OrderFood;
import com.example.booking.entity.Orders;
import com.example.booking.repository.FoodRepo;
import com.example.booking.repository.OrderFoodRepo;

@Service
public class FoodService {
    @Autowired
    private FoodRepo foodRepo;
    @Autowired
    private OrderFoodRepo orderFoodRepo;

    public List<FoodDTO> getFoods() {
        List<FoodDTO> foodDTOs = new ArrayList<>();
        List<Food> foods = foodRepo.findAll();
        for (Food i : foods)
            foodDTOs.add(i.toDTO());
        return foodDTOs;
    }

    public List<FoodDTO> getByOrders(int id) {
        List<FoodDTO> result = new ArrayList<>();
        List<OrderFood> orderFoods = orderFoodRepo.findByOrder(id);
        for (OrderFood i : orderFoods) {
            Food food = i.getFood();
            result.add(food.toDTO());
        }
        return result;
    }

}

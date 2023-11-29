package com.example.booking.dto;

import com.example.booking.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class MyOrders {
    private User user;
    private List<OrderDTO> orderDTOList;
}

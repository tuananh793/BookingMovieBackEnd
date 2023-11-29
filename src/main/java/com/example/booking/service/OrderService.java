package com.example.booking.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.booking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;

import com.example.booking.dto.FoodDTO;
import com.example.booking.dto.MyOrders;
import com.example.booking.dto.OrderDTO;
import com.example.booking.dto.TicketDTO;
import com.example.booking.entity.Food;
import com.example.booking.entity.OrderFood;
import com.example.booking.entity.Orders;
import com.example.booking.entity.Ticket;
import com.example.booking.entity.User;

@Service
public class OrderService {

    @Autowired
    private OrderRepo ordersRepository;

    @Autowired
    private TicketRepo ticketRepository;

    @Autowired
    private OrderFoodRepo orderFoodRepository;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FoodService foodService;

    public void createOrder(User user, List<Ticket> tickets, List<Food> foods) {
        Orders orders = new Orders();
        orders.setUser(user);
        orders.setOrderTime(new Timestamp(System.currentTimeMillis()));

        for (Ticket ticket : tickets) {
            if (ticket.getSeat().toString().contains("A") || ticket.getSeat().toString().contains("B")
                    || ticket.getSeat().toString().contains("C") || ticket.getSeat().toString().contains("D"))
                ticket.setPrice(50000);
            else
                ticket.setPrice(60000);

            ticket.setShowing(ticket.getShowing());
            ticket.setOrder(orders);
        }

        for (Food food : foods) {
            OrderFood orderFood = new OrderFood();
            orderFood.setOrder(orders);
            orderFood.setFood(food);
            orders.getOrderFoods().add(orderFood);
        }

        ordersRepository.save(orders);
        ticketRepository.saveAll(tickets);
        orderFoodRepository.saveAll(orders.getOrderFoods());
    }

    public MyOrders getMyOrder(int userId) {
        List<Orders> orders = ordersRepository.findByUserId(userId);
        List<OrderDTO> result = new ArrayList<>();
        for (Orders i : orders) {
            List<Ticket> tickets = ticketRepository.findByOrder(i.getId());
            List<TicketDTO> ticketDTOs = new ArrayList<>();
            // for (Ticket t : tickets) {
            // ticketDTOs.add(t.toDTO());
            // }
            List<FoodDTO> foods = foodService.getByOrders(i.getId());
            OrderDTO orderDto = new OrderDTO();
            orderDto.setFood(foods);
            orderDto.setTickets(tickets);
            orderDto.setOrderTime(i.getOrderTime());
            result.add(orderDto);
        }
        MyOrders myOrders = new MyOrders();
        myOrders.setOrderDTOList(result);
        return myOrders;
    }

    public List<Orders> findByUserId(int userId) {
        return ordersRepository.findByUserId(userId);
    }
}

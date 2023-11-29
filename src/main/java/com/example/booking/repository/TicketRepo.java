package com.example.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.booking.entity.Orders;
import com.example.booking.entity.Showing;
import com.example.booking.entity.Ticket;
import java.util.List;

@Repository

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByShowing(Showing showing);

    List<Ticket> findByShowingId(int showingId);

    @Query(value = "SELECT * FROM ticket t WHERE t.order_id=?1", nativeQuery = true)
    List<Ticket> findByOrder(int orderId);
}

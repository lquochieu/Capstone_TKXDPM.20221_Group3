package model.entity.transaction;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * entity transaction  class
 *
 * @author Group 3
 */
@Getter
@Setter
public class Transaction {
    private int userId;
    private int bikeId;
    private int id;
    private int status;
    private LocalDateTime dateTime;
    private int totalTime;

    public Transaction(int userId, int bikeId) {
        this.userId = userId;
        this.bikeId = bikeId;
        this.totalTime = 0;
    }

    public int getRentalTime() {
        Duration duration = Duration.between(dateTime, LocalDateTime.now());
        return (int) duration.toSeconds();
    }

    @Override
    public String toString() {
        return "Transaction [userId=" + userId + ", bikeId=" + bikeId + ", id=" + id + ", status=" + status + "]";
    }

}

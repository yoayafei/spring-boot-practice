package yyf.springboot.quickstart.entity;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;

public class Meeting {
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(LocalTime endTime, LocalTime startTime, LocalDate date, Long id) {
        this.endTime = endTime;
        this.startTime = startTime;
        this.date = date;
        this.id = id;
    }

    public Meeting() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isOverlapping(Meeting other){
        return this.date.equals(other.date) &&
                (this.startTime.isBefore(other.endTime)  && this.endTime.isAfter(other.startTime));
    }
}

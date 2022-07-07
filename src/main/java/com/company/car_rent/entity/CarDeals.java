package com.company.car_rent.entity;

import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.JmixEntity;

import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
public class CarDeals {
    @JmixId
    private UUID CarDealId;

    private LocalDate expectedReturnDate;

    private LocalDate actualReturnDate;

    private String clientName;

    private LocalDate dateOfIssue;

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public UUID getCarDealId() {
        return CarDealId;
    }

    public void setCarDealId(UUID CarDealId) {
        this.CarDealId = CarDealId;
    }
}
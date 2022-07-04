package com.company.car_rent.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "CAR", indexes = {
        @Index(name = "IDX_CAR_DEAL_ID", columnList = "DEAL_ID")
})
@Entity
public class Car {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "MARK", nullable = false)
    @NotNull
    private String mark;

    @Column(name = "TYPE_", nullable = false)
    @NotNull
    private String type;

    @Column(name = "COST", nullable = false)
    @NotNull
    private Integer cost;

    @Column(name = "RENT_PRICE", nullable = false)
    @NotNull
    private Integer rentPrice;

    @JoinColumn(name = "DEAL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Deal deal;

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public Integer getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
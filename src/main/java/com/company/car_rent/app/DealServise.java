package com.company.car_rent.app;

import com.company.car_rent.entity.Car;
import com.company.car_rent.entity.Client;
import com.company.car_rent.entity.Deal;
import io.jmix.core.DataManager;
import io.jmix.core.FluentLoader;
import io.jmix.core.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class DealServise {
    @Autowired
    private DataManager dataManager;

    public boolean checkDriverLicinse(Deal deal){
            if (deal.getExpectedReturnDate().isAfter(deal.getClient().getDriversLicenseExpirationDate())) {
                return true;
            }
            return false;
    }
    public boolean checkCar(Deal deal, Car car, LocalDate date){
        for (Deal i : car.getDeal()) {
            if ( (i.getActualReturnDate() == null && !deal.getId().equals(i.getId()) || i.getActualReturnDate() != null && !date.isAfter(i.getActualReturnDate()))) return true;
        }
        return false;
    }
}
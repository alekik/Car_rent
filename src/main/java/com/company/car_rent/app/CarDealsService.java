package com.company.car_rent.app;

import com.company.car_rent.entity.Car;
import com.company.car_rent.entity.CarDeals;
import com.company.car_rent.entity.Client;
import com.company.car_rent.entity.Deal;
import io.jmix.core.DataManager;
import io.jmix.ui.screen.Install;
import io.jmix.ui.screen.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarDealsService {
    @Autowired
    private DataManager dataManager;

    public List<CarDeals> fetchCarDealsStatistics1(Car car) {
        if (car == null) return fetchCarDealsStatistics();
        List<CarDeals> carDeals = new ArrayList<>();
        for (Deal j : car.getDeal()) {
            CarDeals carDeal = dataManager.create(CarDeals.class);
            carDeal.setCarDealId(j.getId());
            carDeal.setClientName(j.getClient().getFullName());
            carDeal.setDateOfIssue(j.getDateOfIssue());
            carDeal.setActualReturnDate(j.getActualReturnDate());
            carDeal.setExpectedReturnDate(j.getExpectedReturnDate());
            carDeals.add(carDeal);
        }
        return carDeals;
    }

    public List<CarDeals> fetchCarDealsStatistics(){


        List<Car> cars = dataManager.load(Car.class).all().fetchPlan("car-with-deals").list();
        List<CarDeals> carDeals = new ArrayList<>();
        for (Car i : cars){
            for (Deal j : i.getDeal()){
                CarDeals carDeal= dataManager.create(CarDeals.class);
                carDeal.setCarDealId(j.getId());
                carDeal.setClientName(j.getClient().getFullName());
                carDeal.setDateOfIssue(j.getDateOfIssue());
                carDeal.setActualReturnDate(j.getActualReturnDate());
                carDeal.setExpectedReturnDate(j.getExpectedReturnDate());
                carDeals.add(carDeal);
            }
        }
        return carDeals;
    }
}
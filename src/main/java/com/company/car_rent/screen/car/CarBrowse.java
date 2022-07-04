package com.company.car_rent.screen.car;

import io.jmix.ui.screen.*;
import com.company.car_rent.entity.Car;

@UiController("Car.browse")
@UiDescriptor("car-browse.xml")
@LookupComponent("carsTable")
public class CarBrowse extends StandardLookup<Car> {
}
package com.company.car_rent.screen.car;

import io.jmix.ui.screen.*;
import com.company.car_rent.entity.Car;

@UiController("Car.edit")
@UiDescriptor("car-edit.xml")
@EditedEntityContainer("carDc")
public class CarEdit extends StandardEditor<Car> {
}
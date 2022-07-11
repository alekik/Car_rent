package com.company.car_rent.screen.cardeals;

import com.company.car_rent.app.CarDealsService;
import com.company.car_rent.entity.Car;
import io.jmix.core.LoadContext;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.car_rent.entity.CarDeals;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@UiController("CarDeals.browse")
@UiDescriptor("car-deals-browse.xml")
@LookupComponent("carDealsesTable")
public class CarDealsBrowse extends StandardLookup<CarDeals> {

    @Autowired
    private CarDealsService carDealsService;

    @Named("carDealsesDl")
    private CollectionLoader<CarDeals> carDealsesDl;

    private Car selectCar=null;

    @Install(to = "carDealsesDl", target = Target.DATA_LOADER)
    private List<CarDeals> carDealsesDlLoadDelegate(LoadContext<CarDeals> loadContext) {
        // Here you can load entities from an external store
        return carDealsService.fetchCarDealsStatistics1(selectCar);
//        return null;
    }

    public void onInit(InitEvent event) {

    }


    @Subscribe("carField")
    public void onCustomerFieldValueChange(HasValue.ValueChangeEvent<Car> event) {
//        event.getValue()
        List<CarDeals> cardeals = carDealsService.fetchCarDealsStatistics1(event.getValue());
        selectCar = event.getValue();
        carDealsesDl.load();
    }
}
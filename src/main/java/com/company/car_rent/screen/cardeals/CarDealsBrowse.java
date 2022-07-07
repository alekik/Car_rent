package com.company.car_rent.screen.cardeals;

import com.company.car_rent.app.CarDealsService;
import io.jmix.core.LoadContext;
import io.jmix.ui.screen.*;
import com.company.car_rent.entity.CarDeals;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

@UiController("CarDeals.browse")
@UiDescriptor("car-deals-browse.xml")
@LookupComponent("carDealsesTable")
public class CarDealsBrowse extends StandardLookup<CarDeals> {

    @Autowired
    private CarDealsService carDealsService;

    @Install(to = "carDealsesDl", target = Target.DATA_LOADER)
    private List<CarDeals> carDealsesDlLoadDelegate(LoadContext<CarDeals> loadContext) {
        // Here you can load entities from an external store
        return carDealsService.fetchCarDealsStatistics();
        //return null;
    }
}
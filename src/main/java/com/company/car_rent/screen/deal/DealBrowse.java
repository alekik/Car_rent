package com.company.car_rent.screen.deal;

import io.jmix.ui.screen.*;
import com.company.car_rent.entity.Deal;

@UiController("Deal.browse")
@UiDescriptor("deal-browse.xml")
@LookupComponent("dealsTable")
public class DealBrowse extends StandardLookup<Deal> {
}
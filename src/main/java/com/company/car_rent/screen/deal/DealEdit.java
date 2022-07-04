package com.company.car_rent.screen.deal;

import io.jmix.ui.screen.*;
import com.company.car_rent.entity.Deal;

@UiController("Deal.edit")
@UiDescriptor("deal-edit.xml")
@EditedEntityContainer("dealDc")
public class DealEdit extends StandardEditor<Deal> {
}
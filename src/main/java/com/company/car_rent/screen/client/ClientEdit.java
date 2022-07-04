package com.company.car_rent.screen.client;

import io.jmix.ui.screen.*;
import com.company.car_rent.entity.Client;

@UiController("Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
public class ClientEdit extends StandardEditor<Client> {
}
package com.company.car_rent.screen.client;

import io.jmix.ui.screen.*;
import com.company.car_rent.entity.Client;

@UiController("Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
public class ClientBrowse extends StandardLookup<Client> {
}
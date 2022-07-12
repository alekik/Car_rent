package com.company.car_rent.screen.deal;

import com.company.car_rent.app.DealServise;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.LayoutClickNotifier;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import com.company.car_rent.entity.Deal;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@UiController("Deal.edit")
@UiDescriptor("deal-edit.xml")
@EditedEntityContainer("dealDc")
public class DealEdit extends StandardEditor<Deal> {
    @Autowired
    DealServise dealServise;
    @Autowired
    private Dialogs dialogs;
    @Autowired
    private Notifications notifications;

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        if (dealServise.checkDriverLicinse(this.getEditedEntity()) || dealServise.checkCar(this.getEditedEntity(),this.getEditedEntity().getCar(),this.getEditedEntity().getDateOfIssue()) ) {
            dialogs.createMessageDialog()
                    .withCaption("Ошибка")
                    .withMessage("Машина ещё занята или срока действия ваших прав не хватает для столь долгой аренды")
                    .show();

        }
        else {
            this.closeWithCommit();
        }
    }
}
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
                    .withCaption("Error")
                    .withMessage("Date")
                    .show();
            //event.getModifiedInstances().stream().findFirst().get(0);
//            event.preventCommit();
            //event.preventCommit();
            //notifications.create().withCaption("Error").show();

        }
        else {
            this.closeWithCommit();
            //this.close(StandardOutcome.CLOSE);
        }
    }



//    @Subscribe(target = Target.DATA_CONTEXT)
//    public void onPreCommit(DataContext.PreCommitEvent event) {
//        if (dealServise.checkDriverLicinse(this.getEditedEntity()) || dealServise.checkCar(this.getEditedEntity(),this.getEditedEntity().getCar(),this.getEditedEntity().getDateOfIssue()) ) {
//            dialogs.createMessageDialog()
//                    .withCaption("Error")
//                    .withMessage("Date")
//                    .show();
//            //event.getModifiedInstances().stream().findFirst().get(0);
////            event.preventCommit();
//            //event.preventCommit();
//            //notifications.create().withCaption("Error").show();
//
//        }
//
//    }

//    @Subscribe("checkBtn")
//    public void onCheckBtnClick(Button.ClickEvent event) {
//        if (dealServise.checkDriverLicinse(this.getEditedEntity()) || dealServise.checkCar(this.getEditedEntity(),this.getEditedEntity().getCar(),this.getEditedEntity().getDateOfIssue()) ) {
//            dialogs.createMessageDialog()
//                    .withCaption("Error")
//                    .withMessage("Date")
//                    .show();
//            //event.getModifiedInstances().stream().findFirst().get(0);
////            event.preventCommit();
//            //event.preventCommit();
//            //notifications.create().withCaption("Error").show();
//
//        }
//        else {
//            close(StandardOutcome.COMMIT);
//        }
//    }






//    @Subscribe("commitAndCloseBtn")
//    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
//
//    }



//    @Subscribe("windowCommitAndClose")
//    public void onWindowCommitAndClose(Action.ActionPerformedEvent event) {
//        //System.out.println(this.getEditedEntity().getClient().getFullName());
//        //dealServise.createDeal(this.getEditedEntity());
//        /*dialogs.createMessageDialog()
//                .withCaption("Error")
//                .withMessage("Date")
//                .show();*/
//
//    }

    /*@Autowired
    private Dialogs dialogs;

    @Subscribe("msgDialogBtn")
    public void onMsgDialogBtnClick(Button.ClickEvent event) {
        dialogs.createMessageDialog()
                .withCaption("Error")
                .withMessage("Date")
                .show();
    }*/
}
package co.pragma.automatizacion.interactions;

import co.pragma.automatizacion.userinterfaces.ResultSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class SelectInTheList implements Interaction {

  private Target inputTarget;
  private String option;

  public SelectInTheList(Target inputTarget, String option) {
    this.inputTarget = inputTarget;
    this.option = option;
  }

  public static SelectInTheList theOption(Target inputTarget, String option) {
    return Tasks.instrumented(SelectInTheList.class, inputTarget, option);
  }

  @Step("{0} selects in the list the option '#option'")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        MoveMouse.to(ResultSearchPage.COMBO),
        Click.on(ResultSearchPage.COMBO),
        Click.on(inputTarget.of(option))
    );
  }
}

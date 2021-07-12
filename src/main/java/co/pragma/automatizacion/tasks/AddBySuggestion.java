package co.pragma.automatizacion.tasks;

import static co.pragma.automatizacion.userinterfaces.HomePage.BESTSELLER_OPTION;
import static co.pragma.automatizacion.userinterfaces.HomePage.POPULAR_OPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.pragma.automatizacion.userinterfaces.HomePage;
import co.pragma.automatizacion.userinterfaces.QuickViewPage;
import co.pragma.automatizacion.utils.constants.GeneralConstants;
import co.pragma.automatizacion.utils.enums.Options;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

public class AddBySuggestion implements Task {

  private String type;
  private String option;

  public AddBySuggestion(String type, String option) {
    this.type = type;
    this.option = option;
  }

  public static AddBySuggestion toCart(String type, String option) {
    return instrumented(AddBySuggestion.class, type, option);
  }

  @Step("{0} select and add the product to the cart")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Scroll.to(POPULAR_OPTION),
        Check.whether(type.equalsIgnoreCase(GeneralConstants.POPULAR)).andIfSo(
            Click.on(POPULAR_OPTION),
            MoveMouse.to(HomePage.POPULAR_PRODUCT),
            Click.on(HomePage.BUTTON_ADD_CART.of(Options.POPULAR.options()))).otherwise(
            Click.on(BESTSELLER_OPTION),
            MoveMouse.to(HomePage.BESTSELLER_PRODUCT),
            Click.on(HomePage.BUTTON_ADD_CART.of(Options.BESTSELLER.options()))),
        Check.whether(option.equals(Options.YES.options())).andIfSo(
            Click.on(QuickViewPage.BUTTON_CONTINUE_SHOPPING)));
  }
}

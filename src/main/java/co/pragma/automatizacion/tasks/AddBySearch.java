package co.pragma.automatizacion.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.pragma.automatizacion.interactions.Search;
import co.pragma.automatizacion.userinterfaces.ProductPage;
import co.pragma.automatizacion.userinterfaces.QuickViewPage;
import co.pragma.automatizacion.userinterfaces.ResultSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class AddBySearch implements Task {

  private String units;
  private String product;

  public AddBySearch(String units, String product) {
    this.units = units;
    this.product = product;
  }

  public static AddBySearch inThePage(String units, String product) {
    return Tasks.instrumented(AddBySearch.class, units, product);
  }

  @Step("{0} select and add the product to the cart")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Search.option(product),
        Scroll.to(ResultSearchPage.SEARCHED_ITEM.of(product)),
        MoveMouse.to(ResultSearchPage.SEARCHED_ITEM.of(product)),
        Click.on(ResultSearchPage.BUTTON_MORE),
        Enter.theValue(units).into(ProductPage.INPUT_QUANTITY),
        Click.on(ProductPage.ADD_TO_CART),
        WaitUntil.the(QuickViewPage.BUTTON_PROCEED_TO_CHECKOUT, isVisible()).forNoMoreThan(5)
            .seconds(),
        Click.on(QuickViewPage.BUTTON_PROCEED_TO_CHECKOUT));
  }
}

package co.pragma.automatizacion.tasks;

import co.pragma.automatizacion.interactions.Search;
import co.pragma.automatizacion.interactions.SelectInTheList;
import co.pragma.automatizacion.userinterfaces.ResultSearchPage;
import co.pragma.automatizacion.utils.enums.Options;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

public class AddAccordingToPrice implements Task {

  private String price;
  private String category;

  public AddAccordingToPrice(String price, String category) {
    this.category = category;
    this.price = price;
  }

  public static AddAccordingToPrice ofTheList(String price, String category) {
    return Tasks.instrumented(AddAccordingToPrice.class, price, category);
  }

  @Step("{0} searches and selects the most '#price' product")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Search.option(category),
        Click.on(ResultSearchPage.LIST_VIEW),
        Check.whether(price.equalsIgnoreCase(Options.ECONOMICAL.options())).andIfSo(
            SelectInTheList
                .theOption(ResultSearchPage.SELECT_OPTION, Options.LOWEST_PRICE.options()))
            .otherwise(
                SelectInTheList
                    .theOption(ResultSearchPage.SELECT_OPTION, Options.HIGHEST_PRICE.options())),
        MoveMouse.to(ResultSearchPage.ADD_TO_CART),
        Click.on(ResultSearchPage.ADD_TO_CART));
  }
}

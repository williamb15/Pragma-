package co.pragma.automatizacion.interactions;

import co.pragma.automatizacion.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class Search implements Interaction {

  private String option;

  public Search(String option) {
    this.option = option;
  }

  public static Search option(String option) {
    return Tasks.instrumented(Search.class, option);
  }

  @Step("{0} search the page the option '#option'")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Enter.theValue(option).into(HomePage.INPUT_SEARCH).thenHit(Keys.ENTER));
  }
}


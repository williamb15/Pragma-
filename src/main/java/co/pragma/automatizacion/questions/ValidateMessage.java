package co.pragma.automatizacion.questions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.pragma.automatizacion.userinterfaces.QuickViewPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ValidateMessage implements Question<String> {

  public static ValidateMessage ofConfirmation() {
    return new ValidateMessage();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(WaitUntil.the(QuickViewPage.LABEL_PRODUCT_SUCCESSFULLY_ADDED_TO_CART,
        isVisible()).forNoMoreThan(2).seconds());
    return Text.of(QuickViewPage.LABEL_PRODUCT_SUCCESSFULLY_ADDED_TO_CART)
        .viewedBy(actor).asString();
  }
}
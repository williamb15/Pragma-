package co.pragma.automatizacion.questions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.pragma.automatizacion.userinterfaces.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ValidateError implements Question<String> {

  public static ValidateError message() {
    return new ValidateError();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(WaitUntil.the(ProductPage.LABEL_NULL_QUANTITY,
        isVisible()).forNoMoreThan(2).seconds());
    return Text.of(ProductPage.LABEL_NULL_QUANTITY)
        .viewedBy(actor).asString();
  }
}
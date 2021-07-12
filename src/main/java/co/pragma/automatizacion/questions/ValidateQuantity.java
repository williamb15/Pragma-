package co.pragma.automatizacion.questions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.pragma.automatizacion.userinterfaces.PurchaseSummaryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ValidateQuantity implements Question<String> {

  public static ValidateQuantity ofThePurchase() {
    return new ValidateQuantity();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(WaitUntil.the(PurchaseSummaryPage.QUANTITY_PRODUCT,
        isVisible()).forNoMoreThan(2).seconds());
    return Text.of(PurchaseSummaryPage.QUANTITY_PRODUCT)
        .viewedBy(actor).asString();
  }
}
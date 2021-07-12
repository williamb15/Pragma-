package co.pragma.automatizacion.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.pragma.automatizacion.utils.constants.GeneralConstants;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class GeneralStepDefinitions {

  @Managed(driver = GeneralConstants.CHROME)
  protected WebDriver hisBrowser;

  @SuppressWarnings("unchecked")
  public void setUp() {
    setTheStage(new Cast());
    theActorCalled(GeneralConstants.ACTOR);
    theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
  }
}

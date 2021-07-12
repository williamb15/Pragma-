package co.pragma.automatizacion.stepdefinitions;

import static co.pragma.automatizacion.utils.constants.ExceptionsConstants.PRODUCT_NOT_ADDED_TO_CART;
import static co.pragma.automatizacion.utils.constants.ExceptionsConstants.THE_ERROR_MESSAGE_COULD_NOT_BE_VALIDATED;
import static co.pragma.automatizacion.utils.constants.ExceptionsConstants.THE_QUANTITY_OF_PRODUCTS_IS_NOT_CORRECT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import co.pragma.automatizacion.exceptions.AddProductException;
import co.pragma.automatizacion.questions.ValidateError;
import co.pragma.automatizacion.questions.ValidateMessage;
import co.pragma.automatizacion.questions.ValidateQuantity;
import co.pragma.automatizacion.tasks.AddAccordingToPrice;
import co.pragma.automatizacion.tasks.AddByCategory;
import co.pragma.automatizacion.tasks.AddBySearch;
import co.pragma.automatizacion.tasks.AddBySuggestion;
import co.pragma.automatizacion.utils.constants.GeneralConstants;
import co.pragma.automatizacion.utils.enums.Options;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;


public class AddProductsToCartStepDefinitions extends GeneralStepDefinitions {

  @Before
  public void config() {
    setUp();
  }

  @Given("the user is on the main page of the store")
  public void theUserIsOnTheMainPageOfTheStore() {
    theActorInTheSpotlight().wasAbleTo(Open.url(GeneralConstants.URL));
  }

  @When("he selects and adds one of the most {string} products")
  public void heSelectsAndAddsOneOfTheMostProducts(String type) {
    theActorInTheSpotlight().attemptsTo(AddBySuggestion.toCart(type, Options.NO.options()));
  }

  @When("he add a {string} product and continue one of the {string}")
  public void heAddAProductAndContinueOneOfThe(String type1, String type2) {
    theActorInTheSpotlight().attemptsTo(AddBySuggestion.toCart(type1, Options.YES.options()),
        AddBySuggestion.toCart(type2, Options.NO.options()));
  }

  @When("he adds {string} of the {string} to the cart")
  public void heAddsOfTheToTheCart(String units, String product) {
    theActorInTheSpotlight().attemptsTo(AddBySearch.inThePage(units, product));
  }

  @When("he searches and selects the most {string} product of category {string}")
  public void heSearchesAndSelectsTheMostEconomicalProductOfCategory(String price,
      String category) {
    OnStage.theActorInTheSpotlight().attemptsTo(
        AddAccordingToPrice.ofTheList(price, category));
  }

  @When("he enters {string}, then {string}, and selects {string}")
  public void heEntersWomenThenTopsAndSelectsBlouse(String category, String subcategory,
      String product) {
    theActorInTheSpotlight().attemptsTo(AddByCategory.forThe(category, subcategory, product));
  }

  @Then("he will be able to see the message {string}")
  public void heWillBeAbleToSeeTheMessage(String message) {
    theActorInTheSpotlight()
        .should(seeThat(ValidateMessage.ofConfirmation(), containsString(message))
            .orComplainWith(AddProductException.class, PRODUCT_NOT_ADDED_TO_CART));
  }

  @Then("he will be able to see in the summary Your shopping cart contains:{string} Products")
  public void heWillBeAbleToSeeInTheSummaryYourShoppingCartContainsProducts(String quantity) {
    theActorInTheSpotlight()
        .should(seeThat(ValidateQuantity.ofThePurchase(), containsString(quantity))
            .orComplainWith(AddProductException.class, THE_QUANTITY_OF_PRODUCTS_IS_NOT_CORRECT));
  }

  @Then("he will be able to visualize message of error {string}")
  public void heWillBeAbleToVisualizeMessageOfError(String messageError) {
    theActorInTheSpotlight().should(seeThat(ValidateError.message(), is(equalTo(messageError)))
        .orComplainWith(AddProductException.class, THE_ERROR_MESSAGE_COULD_NOT_BE_VALIDATED));
  }
}

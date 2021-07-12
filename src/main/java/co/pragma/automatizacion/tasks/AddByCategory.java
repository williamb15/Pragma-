package co.pragma.automatizacion.tasks;

import co.pragma.automatizacion.userinterfaces.HomePage;
import co.pragma.automatizacion.userinterfaces.ProductPage;
import co.pragma.automatizacion.userinterfaces.ResultSearchPage;
import co.pragma.automatizacion.utils.constants.GeneralConstants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class AddByCategory implements Task {

  private String nameCategory;
  private String nameSubcategory;
  private String nameProduct;

  public AddByCategory(String nameCategory, String nameSubcategory, String nameProduct) {
    this.nameCategory = nameCategory;
    this.nameSubcategory = nameSubcategory;
    this.nameProduct = nameProduct;
  }

  public static AddByCategory forThe(String nameCategory, String nameSubcategory,
      String nameProduct) {
    return Tasks.instrumented(AddByCategory.class, nameCategory, nameSubcategory, nameProduct);
  }

  @Step("{0} browse the subcategories and add product to the cart")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(HomePage.CATEGORY.of(nameCategory)),
        Click.on(ResultSearchPage.SUBCATEGORY.of(nameSubcategory)),
        Click.on(ResultSearchPage.LIST_VIEW),
        Click.on(ResultSearchPage.PRODUCT.of(nameProduct)),
        Enter.theValue(GeneralConstants.FORMAT_DATE).into(ProductPage.INPUT_QUANTITY),
        Click.on(ProductPage.ADD_TO_CART)
    );
  }
}

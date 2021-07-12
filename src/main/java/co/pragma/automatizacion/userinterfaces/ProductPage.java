package co.pragma.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {

  public static final Target ADD_TO_CART = Target.the("Button Add to Cart").locatedBy(
      "//p[@id='add_to_cart']//button");
  public static final Target INPUT_QUANTITY = Target.the("Input Quantity").locatedBy(
      "//p[@id='quantity_wanted_p']//input");
  public static final Target LABEL_NULL_QUANTITY = Target.the("Label null quantity")
      .locatedBy("//p[contains(text(), 'Null quantity.')]");

  private ProductPage() {
    super();
  }
}

package co.pragma.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class QuickViewPage {

  public static final Target BUTTON_PROCEED_TO_CHECKOUT = Target.the("Button Proceed to checkout")
      .locatedBy(
          "//div[@id='layer_cart']//following::span[contains(text(), 'Proceed to checkout')]");
  public static final Target BUTTON_CONTINUE_SHOPPING = Target.the("Button Continue Shopping")
      .locatedBy(
          "//span[@title]//span");
  public static final Target LABEL_PRODUCT_SUCCESSFULLY_ADDED_TO_CART = Target
      .the("Label product successfully added to cart")
      .locatedBy("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2");

  private QuickViewPage() {
    super();
  }
}
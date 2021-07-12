package co.pragma.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PurchaseSummaryPage {

  public static final Target QUANTITY_PRODUCT = Target.the("Quantity Product").locatedBy(
      "//span[@id='summary_products_quantity']");

  private PurchaseSummaryPage() {
    super();
  }
}

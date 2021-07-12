package co.pragma.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ResultSearchPage {

  public static final Target SEARCHED_ITEM = Target.the("Searched Item").locatedBy(
      "//div[@class='product-image-container']//child::a[@title='{0}']");
  public static final Target BUTTON_MORE = Target.the("Button More").locatedBy(
      "(//a[@class='button lnk_view btn btn-default']//span[contains(text(), 'More')])[1]");
  public static final Target LIST_VIEW = Target.the("List View ").locatedBy(
      "//i[@class='icon-th-list']");
  public static final Target COMBO = Target.the("Select").locatedBy(
      "//div[@id='uniform-selectProductSort']");
  public static final Target SELECT_OPTION = Target.the("Select Option").locatedBy(
      "//select[@id='selectProductSort']//option[contains(text(), '{0}')]");
  public static final Target ADD_TO_CART = Target.the("Add To Cart ").locatedBy(
      "(//a[@title='Add to cart'])[1]");
  public static final Target SUBCATEGORY = Target.the("Subcategory").locatedBy(
      "//ul[@class='clearfix']//child::a[@title='{0}']");
  public static final Target PRODUCT = Target.the("Product ").locatedBy(
      "//ul[@class='product_list row list']//child::a[contains(text(), '{0}')]");

  private ResultSearchPage() {
    super();
  }

}

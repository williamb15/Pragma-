package co.pragma.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
  public static final Target POPULAR_OPTION = Target.the("Popular Option").locatedBy(
      "//ul[@id='home-page-tabs']//a[contains(text(), 'Popular')]");
  public static final Target BESTSELLER_OPTION = Target.the("Best Seller Option").locatedBy(
      "//ul[@id='home-page-tabs']//a[contains(text(), 'Best Sellers')]");
  public static final Target POPULAR_PRODUCT = Target.the("Popular Product").locatedBy(
      "(//img[@class='replace-2x img-responsive'])[1]");
  public static final Target BESTSELLER_PRODUCT = Target.the("Popular Product").locatedBy(
      "(//ul[@id='blockbestsellers']//img[@class='replace-2x img-responsive'])[1]");
  public static final Target BUTTON_ADD_CART = Target.the("Button Add Cart").locatedBy(
      "(//ul[@id='{0}']//div[@class='button-container']//span[contains(text(), 'Add to cart')])[1]");
  public static final Target INPUT_SEARCH = Target.the("Input search")
      .located(By.id("search_query_top"));
  public static final Target CATEGORY = Target.the("Category").locatedBy(
      "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//child::a[contains(text(), '{0}')]");

  private HomePage() {
    super();
  }
}

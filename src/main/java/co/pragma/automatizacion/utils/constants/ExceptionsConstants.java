package co.pragma.automatizacion.utils.constants;

public class ExceptionsConstants {

  public static final String PRODUCT_NOT_ADDED_TO_CART = "Product not added to cart";
  public static final String THE_QUANTITY_OF_PRODUCTS_IS_NOT_CORRECT = "the quantity of products is not correct";
  public static final String THE_ERROR_MESSAGE_COULD_NOT_BE_VALIDATED = "The error message could not be validated";

  private ExceptionsConstants() {
    throw new IllegalStateException(GeneralConstants.UTILITY_CLASS);
  }
}

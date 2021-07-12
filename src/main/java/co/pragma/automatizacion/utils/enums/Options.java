package co.pragma.automatizacion.utils.enums;

public enum Options {

  POPULAR("homefeatured"),
  BESTSELLER("blockbestsellers"),
  ECONOMICAL("economical"),
  LOWEST_PRICE("Price: Lowest first"),
  HIGHEST_PRICE("Price: Highest first"),
  YES("Si"),
  NO("No");

  private String optionsValue;

  Options(String optionsValue) {
    this.optionsValue = optionsValue;
  }

  public String options() {
    return optionsValue;
  }
}

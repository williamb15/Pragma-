package co.pragma.automatizacion.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/add_products_to_cart.feature",
    glue = "co.pragma.automatizacion.stepdefinitions",
    snippets = SnippetType.CAMELCASE, tags ="@AddProductValidatingSubcategoriesAndQuantity")

public class AddProductsToCart {

}


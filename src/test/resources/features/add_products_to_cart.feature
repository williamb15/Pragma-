Feature: Add product to cart
  I as a user
  need to add a product to the cart
  to make a purchase

  Background:
    Given the user is on the main page of the store

  @AddPopularProductToCart
  Scenario: Add a product from home page
    When he selects and adds one of the most "popular" products
    Then he will be able to see the message "Product successfully added to your shopping cart"

  @AddPopularAndBestSellingProducts
  Scenario: Add a popular product, and keep buying one of the best-selling products
    When he add a "popular" product and continue one of the "best sellers"
    Then he will be able to see the message "Product successfully added to your shopping cart"

  @AddUnitsToAProduct
  Scenario Outline: Add multiple units to a specific product
    When he adds "<units>" of the "<product>" to the cart
    Then he will be able to see in the summary Your shopping cart contains:"<units>" Products
    Examples:
      | units | product               |
      | 10    | Printed Chiffon Dress |

  @AddProductsAccordingToPrice
  Scenario Outline: Add products according to price, of a specific category
    When he searches and selects the most "<price>" product of category "Dresses"
    Then he will be able to see the message "Product successfully added to your shopping cart"
    Examples:
      | price      |
      | economical |
      | expensive  |

  @AddProductValidatingSubcategoriesAndQuantity
  Scenario Outline: Add a product to the cart, browsing the subcategories and with a letter as quantity
    When he enters "<category>", then "<subcategory>", and selects "<product>"
    Then he will be able to visualize message of error "Null quantity."
    Examples:
      | category | subcategory | product |
      | Women    | Tops        | Blouse  |



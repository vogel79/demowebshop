# Testing task - QA Automation (Java)

Environment:
macOS Mojave (10.14.5),
jdk 13.0.1,
IntelliJ IDEA 2020.3.1,
Maven 3.6.3,
Selenium Server 3.141.59,
JUnit 4.13.2,
ChromeDriver 98.0.4758.102,
Browsers: Safari 12.1.1, Google Chrome 98.0.4758.102

Exercises:
1) Selenium WebDriver (UI)
A) Go to http://demowebshop.tricentis.com/
In the categories menu open Computer -> Desktops.
Set Display to "4" per page and check only 4 items displayed after that.
Sort "Price: High to Low", and click add to cart the most expensive item -> check the item is in the shopping cart.

B) Open http://demowebshop.tricentis.com/build-your-own-expensive-computer-2
Set Processor: Fast;
Set RAM: 8GB;
Select all available software;
Click "Add to cart" -> check the shopping cart has +1 item.
Open the Shopping cart -> check the item is there and the price is correct (according to the selected options on the item page).
Remove the item from the shopping cart.

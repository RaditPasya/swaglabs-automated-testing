# Web Automation Testing

Project automation testing untuk melakukan automated testing pada aplikasi web [Swag Labs](https://www.saucedemo.com/) serta API testing pada API Endpoint [DummyAPI](https://dummyapi.io). Project ini dikembangkan dengan bahasa Java untuk kode program dan pembuatan script test dan Maven sebagai build tools.

## Build With
Automation Testing pada project ini menggunakan beberapa tools dan library.
 <ul>
    <li>JUnit</li>
    <li>Cucumber</li>
    <li>Selenium</li>
    <li>WebDriverManager</li>
    <li>RestAssured</li>
 </ul>
 
# Getting Started
## Pre-requisites
Sebelum menjalankan project ini, perlu disiapkan environment yang sesuai.
<ul>
  <li>Java 17+</li>
  <li>Apache Maven 3.8.0+</li>
  <li>Web Browser</li>
</ul>

## Struture Project Test
Berikut ini merupakan struktur kode
```
📦src
 ┣ 📂main
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂a10
 ┃ ┃ ┃ ┃ ┗ 📜App.java
 ┗ 📂test
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂a10
 ┃ ┃ ┃ ┃ ┣ 📂helper
 ┃ ┃ ┃ ┃ ┃ ┗ 📜A10WebDriverManager.java
 ┃ ┃ ┃ ┃ ┣ 📂pagefactory
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CartPageFactory.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DetailsPageFactory.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜HomePageFactory.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginPageFactory.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜OverviewPageFactory.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜YourInfoPageFactory.java
 ┃ ┃ ┃ ┃ ┣ 📂steps
 ┃ ┃ ┃ ┃ ┃ ┣ 📂API
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜APIcreateTestSteps.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜APIdeleteTestSteps.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜APIgetTestSteps.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜APIputTestSteps.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂Automation
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartTestSteps.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CheckoutTestSteps.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DetailsSteps.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EtoESteps.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HomepageTestingSteps.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginSteps.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LogoutSteps.java
 ┃ ┃ ┃ ┃ ┗ 📂tests
 ┃ ┃ ┃ ┃ ┃ ┗ 📜TestRunner.java
 ┃ ┗ 📂resources
 ┃ ┃ ┗ 📂a10
 ┃ ┃ ┃ ┣ 📜APIcreateTest.feature
 ┃ ┃ ┃ ┣ 📜APIdeleteTest.feature
 ┃ ┃ ┃ ┣ 📜APIgetTest.feature
 ┃ ┃ ┃ ┣ 📜APIputTest.feature
 ┃ ┃ ┃ ┣ 📜CartTest.feature
 ┃ ┃ ┃ ┣ 📜CheckoutTest.feature
 ┃ ┃ ┃ ┣ 📜DetailsTest.feature
 ┃ ┃ ┃ ┣ 📜EtoESteps.feature
 ┃ ┃ ┃ ┣ 📜HomepageTesting.feature
 ┃ ┃ ┃ ┣ 📜login.feature
 ┃ ┃ ┃ ┗ 📜logout.feature
```

## Run Automation Test
1. Clone repository dengan git
   ```
   git clone https://github.com/RaditPasya/swaglabs-automated-testing.git
   ```
2. Jalankan perintah berikut untuk menginstall artifak yang didefinisikan
   ```
   mvn clean install
   ```
3. Jalankan perintah berikut pada terminal untuk menjalankan semua test
   ```
   mvn surefire-report:report
   ```
4. Jalankan perintah berikut pada terminal untuk melihat report
   ```bat
   start target\site\surefire-report.html
   ```

## Test Cases
Pembuatan test case meliputi test positif dan negatif untuk automated testing dan API Testing

#### Login
```
[T0.0.1] - Login successful with valid credentials
[T0.0.2] - Login with wrong username
[T0.0.3] - Login with wrong password
[T0.0.4] - Login with no password
[T0.0.5] - Login with no username
[T0.0.6] - Login with nothing

```

#### Logout
```
[T0.1.1] - Positive logout
```


#### API Create
```
[TC 1] - Missing APP_ID header
[TC 2] - Invalid APP_ID header
[TC 3] - Valid request with correct APP_ID
[TC 14] - Missing firstName in request body
[TC 5] - Missing lastName in request body
```
#### API Delete
```
[TC 1] - Missing APP_ID header
[TC 2] - Invalid APP_ID header
[TC 3] - Valid request with correct APP_ID
[TC 4] - User ID does not exist
[TC 5] - Invalid User ID format

```

#### API GET
```
[TC 1] - Missing APP_ID header
[TC 2] - Invalid APP_ID header
[TC 3] - Valid request with correct APP_ID
[TC 4] - User ID not found
[TC 5] - Invalid User ID

```

#### API PUT
```
[TC 1] - Missing APP_ID header
[TC 2] - Invalid APP_ID header
[TC 3] - Valid request with correct APP_ID
[TC 4] - Valid request with full update
[TC 5] - Invalid request with incorrect gender type

```

#### Cart Testing
```
Go to cart then continue shopping
Go to cart then continue shopping (add 6 items)
Go to cart then checkout with nothing
```
#### Checkout Testing
```
Checkout with invalid first name
Checkout with empty first name
Checkout with invalid zip code
```
#### Details Page Testing
```
Verify product details and add to cart
Verify product details, add to cart, and go back
Verify product details, add to cart, remove from cart, and go back
```
#### End-to-End Testing
```
End-to-end testing
```

#### HomePage Testing
```
Menambah 6 produk
Menghapus 6 produk
Mengurutkan produk
```

## Author
[Hanri Fajar Ramadhan](https://github.com/HanriFR) (211524012)

[Raditya Pasya Heryandi](https://github.com/RaditPasya) (211524021)

[Azis Surohman](https://github.com/zis4215) (201524037)

_Mahasiswa D4 Teknik Informatika Politeknik Negeri Bandung_
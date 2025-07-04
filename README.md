/*
# Entrata.com Selenium Test Suite

This project automates key UI checks for [Entrata.com](https://www.entrata.com) using:
- Java + Selenium WebDriver
- TestNG
- Maven (build tool)
- ExtentReports (HTML reports)

## 🔧 Project Structure

```
├── pom.xml
├── testng.xml
├── /src
│   ├── /main
│   │   └── /java/pages         # Page Object Model classes
│   └── /test
│       ├── /java/tests         # Test classes (SignInTest, SignupTest)
│       ├── /java/utils         # Reusable utilities
│       └── /resources          # testdata.properties
```

## 🧪 How to Run

```bash
mvn clean test
```

-> or open testng.xml file click on Alt+Shift+X,G  or Right click on Run as testNG Suite


## 📄 Reports & Logs

- HTML Report: `reports/extent-report.html`
- Screenshots on failure and success: `screenshots/*.png`

## ⚠️ Notes
- Form **submissions are disabled**; test only interacts with elements.
- Ensure ChromeDriver is in your PATH or configure it in BaseTest.
*/

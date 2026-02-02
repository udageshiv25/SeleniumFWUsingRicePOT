# Salesforce Login Automation Framework

[![Selenium](https://img.shields.io/badge/Selenium-4.0+-green.svg)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.0+-red.svg)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-blue.svg)](https://maven.apache.org/)
[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.oracle.com/java/)

An enterprise-level Selenium automation framework built using the **RICEPOT Framework** for automated testing of Salesforce login functionality. This project demonstrates industry best practices including Page Object Model (POM), TestNG integration, and robust exception handling.

---

## 🎯 About RICEPOT Framework

This automation framework was generated using the **RICEPOT Framework** - a structured approach to AI-assisted code generation:

- **R**ole: QA automation tester with 15 years of experience
- **I**nstructions: Generate enterprise-level Selenium framework with specific requirements
- **C**ontext: Salesforce login testing with AB Testing considerations
- **E**xample: PageFactory pattern with XPath locators
- **P**arameters: Production-level code with zero bad practices
- **O**utput: Runnable code with Page Objects and TestNG tests
- **T**one: Technical, precise, enterprise-grade

For detailed RICEPOT specifications, see [RICE_POT_pe.md](RICE_POT_pe.md)

---

## 🚀 Features

- ✅ **Page Object Model (POM)** with PageFactory pattern
- ✅ **Enterprise-level architecture** with BaseTest and utilities
- ✅ **Robust exception handling** with try-catch blocks
- ✅ **TestNG integration** with annotations and listeners
- ✅ **WebDriverManager** for automatic driver management
- ✅ **Configuration management** via properties file
- ✅ **Explicit waits** using WebDriverWait (no Thread.sleep)
- ✅ **XPath-only locators** for consistency
- ✅ **Comprehensive test coverage** (valid and invalid scenarios)
- ✅ **Test listeners** for logging and reporting

---

## 📁 Project Structure

```
RICEPOTSEL/
├── src/
│   ├── main/java/com/salesforce/pages/
│   │   ├── LoginPage.java          # Login page object
│   │   └── HomePage.java            # Home page object
│   └── test/
│       ├── java/com/salesforce/
│       │   ├── tests/
│       │   │   ├── BaseTest.java            # Base test class
│       │   │   ├── ValidLoginTest.java      # Valid login scenarios
│       │   │   └── InvalidLoginTest.java    # Invalid login scenarios
│       │   └── utils/
│       │       ├── ConfigReader.java        # Configuration reader
│       │       └── TestListener.java        # TestNG listener
│       └── resources/
│           └── config.properties            # Test configuration
├── pom.xml                          # Maven dependencies
├── testng.xml                       # TestNG suite configuration
├── RICE_POT_pe.md                   # RICEPOT framework documentation
└── README.md                        # This file
```

---

## 🛠️ Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 11+ | Programming language |
| Selenium WebDriver | 4.x | Browser automation |
| TestNG | 7.x | Test framework |
| Maven | 3.8+ | Build & dependency management |
| WebDriverManager | 5.x | Automatic driver management |
| Chrome Driver | Latest | Browser driver |

---

## 📋 Prerequisites

Before running this project, ensure you have:

- ✅ **Java JDK 11** or higher installed
- ✅ **Maven 3.8+** installed
- ✅ **Chrome browser** (latest version)
- ✅ **Git** (for cloning)

---

## 🔧 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/udageshiv25/SeleniumFWUsingRicePOT.git
cd SeleniumFWUsingRicePOT
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Configure Test Properties

Edit `src/test/resources/config.properties`:

```properties
browser=chrome
base.url=https://login.salesforce.com/?locale=in
implicit.wait=10
explicit.wait=10
page.load.timeout=30
headless.mode=false
valid.username=your_username
valid.password=your_password
```

---

## ▶️ Running Tests

### Run All Tests

```bash
mvn test
```

### Run Specific Test Class

```bash
mvn test -Dtest=ValidLoginTest
```

### Run via TestNG XML

```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run in Headless Mode

Update `config.properties`:
```properties
headless.mode=true
```

---

## 📊 Test Coverage

### Valid Login Tests (ValidLoginTest.java)
1. ✅ Verify login page elements are displayed
2. ✅ Verify username field accepts input
3. ✅ Verify password field accepts input
4. ✅ Verify remember me functionality
5. ✅ Verify login button is clickable

### Invalid Login Tests (InvalidLoginTest.java)
1. ❌ Login with empty credentials
2. ❌ Login with empty username
3. ❌ Login with empty password
4. ❌ Login with invalid username
5. ❌ Login with invalid password
6. ❌ Login with invalid email format
7. ❌ Login with special characters
8. ❌ SQL injection attempt

---

## 📦 Key Classes

### Page Objects

**LoginPage.java**
- Handles all login page interactions
- Uses @FindBy annotations with XPath
- Includes validation methods
- Robust error handling

**HomePage.java**
- Post-login page verification
- User avatar and app launcher checks
- Logout functionality

### Test Infrastructure

**BaseTest.java**
- Common setup and teardown
- WebDriver initialization
- Browser configuration

**TestListener.java**
- Test execution logging
- Success/failure reporting
- Test suite statistics

**ConfigReader.java**
- Centralized configuration
- Property file management
- Default value handling

---

## 🎨 Design Patterns Used

1. **Page Object Model (POM)** - Separation of page elements and test logic
2. **Factory Pattern** - PageFactory for element initialization
3. **Singleton Pattern** - ConfigReader for configuration
4. **Template Method Pattern** - BaseTest for common setup/teardown
5. **Observer Pattern** - TestListener for test event handling

---

## 📝 Best Practices Implemented

- ✅ No hardcoded values (externalized configuration)
- ✅ No Thread.sleep() (explicit waits only)
- ✅ XPath-only locators (no CSS or ID)
- ✅ Exception handling in all methods
- ✅ Reusable components
- ✅ Clear naming conventions
- ✅ No commented code
- ✅ Modular and maintainable structure
- ✅ Enterprise-grade architecture

---

## 🐛 Troubleshooting

### ChromeDriver Issues
WebDriverManager handles driver management automatically. If issues occur:
```bash
mvn clean install -U
```

### Test Failures
Check:
1. Internet connectivity
2. Salesforce website availability
3. XPath locators (may change with UI updates)
4. Browser version compatibility

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is created for educational and testing purposes.

---

## 👤 Author

**Shivkumar Udage**
- GitHub: [@udageshiv25](https://github.com/udageshiv25)
- Email: shivkumar.udage@nice.com

---

## 🙏 Acknowledgments

- Generated using **RICEPOT Framework** for AI-assisted development
- Selenium WebDriver community
- TestNG framework developers
- WebDriverManager by Boni Garcia

---

## 📚 Additional Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- [Maven Guide](https://maven.apache.org/guides/)
- [RICEPOT Framework Guide](RICE_POT_pe.md)

---

**⭐ If you find this project useful, please give it a star!**

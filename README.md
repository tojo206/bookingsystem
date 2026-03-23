# Winterflood Automation Framework

A simple, lightweight test automation framework for UI and API testing built with Java, Selenium WebDriver, and RestAssured.

## Table of Contents

- [Prerequisites](#prerequisites)
- [How to Run Tests](#how-to-run-tests)
- [Framework Architecture](#framework-architecture)
- [Project Structure](#project-structure)
- [Adding a New Test](#adding-a-new-test)
- [Viewing Reports](#viewing-reports)
- [Test Scenarios Covered](#test-scenarios-covered)

---

## Prerequisites

- **Java 17+** installed
- **Maven 3.6+** installed

---

## How to Run Tests

### Quick Start

```bash
mvn clean test
```

### With Environment Variables

```bash
# Windows
set Browser=chrome
set Url=https://automationintesting.online/
set Headless=true
mvn clean test

# Linux/macOS
export Browser=chrome
export Url=https://automationintesting.online/
export Headless=true
mvn clean test
```

### Environment Variables

| Variable | Default | Description |
|----------|---------|-------------|
| `Browser` | `chrome` | Browser to use (`chrome` or `edge`) |
| `Url` | `https://automationintesting.online/` | Base URL for UI tests |
| `Headless` | `false` | Run browser in headless mode |
| `USERNAME` | - | API username (optional) |
| `PASSWORD` | - | API password (optional) |

---

## Framework Architecture

### Design Philosophy: Simplicity First

This framework was built with simplicity and maintainability as core principles:

1. **Page Object Model (POM)** - UI elements and actions are encapsulated in page classes, keeping tests clean and readable
2. **Base Test Class** - Common setup/teardown logic in one place, inherited by all tests
3. **Reusable Actions** - Common UI interactions (click, type, verify) centralized in an Actions class with built-in error handling and screenshots
4. **API Helper** - Simple wrapper around RestAssured for consistent API testing

### Technology Stack

| Component | Technology |
|-----------|------------|
| Build Tool | Maven |
| Language | Java 17+ |
| UI Testing | Selenium WebDriver 4.41.0 |
| API Testing | RestAssured 6.0.0 |
| Test Framework | TestNG 7.12.0 |
| Reporting | Allure 2.33.0 |
| Driver Management | WebDriverManager 6.3.3 |

### Key Design Patterns

```
Tests (Business Logic)
    ↓
Page Objects (UI Elements & Actions)
    ↓
Actions (Common UI Operations)
    ↓
Browser Configuration (Driver Setup)
```

---

## Project Structure

```
Winterflood Framework/
├── src/test/java/
│   ├── Tests/
│   │   ├── BaseTest.java          # Base class with setup/teardown
│   │   ├── LandingPageTest.java   # UI tests
│   │   └── ApiTests.java          # API tests
│   ├── CommonBase/
│   │   ├── BrowserConfiguration.java  # Browser driver setup
│   │   ├── Actions.java              # Reusable UI actions
│   │   └── ApiHelper.java            # API helper methods
│   └── PageObjects/
│       └── LandingPage.java       # Page Object for UI elements
├── pom.xml                        # Maven dependencies
├── Testng.xml                     # Test suite configuration
└── .env                           # Environment variables (git-ignored)
```

---

## Adding a New Test

### Adding a UI Test

**Step 1: Create a Page Object** (if testing a new page)

```java
// src/test/java/PageObjects/NewPage.java
package PageObjects;

import CommonBase.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewPage extends Actions {

    private final By submitButton = By.id("submit");
    private final By inputField = By.cssSelector("#input");

    public NewPage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public void enterText(String text) {
        type(inputField, text);
    }

    public boolean isSubmitButtonVisible() {
        return isElementVisible(submitButton);
    }
}
```

**Step 2: Create the Test Class**

```java
// src/test/java/Tests/NewPageTest.java
package Tests;

import PageObjects.NewPage;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewPageTest extends BaseTest {

    @Test(priority = 1, description = "Verify submit button is visible")
    @Story("New Page - UI Validation")
    public void testSubmitButtonVisible() {
        driver.get("https://example.com/newpage");
        NewPage page = new NewPage(driver);

        Assert.assertTrue(page.isSubmitButtonVisible(),
            "Submit button should be visible");
    }

    @Test(priority = 2, description = "Submit form successfully")
    @Story("New Page - Form Submission")
    public void testFormSubmission() {
        driver.get("https://example.com/newpage");
        NewPage page = new NewPage(driver);

        page.enterText("Test input");
        page.clickSubmit();

        // Add assertions for expected result
    }
}
```

**Step 3: Add to Test Suite** (optional)

Edit `Testng.xml` to include your test:

```xml
<test name="UI Tests">
    <classes>
        <class name="Tests.LandingPageTest"/>
        <class name="Tests.NewPageTest"/>  <!-- Add this line -->
    </classes>
</test>
```

### Adding an API Test

Add new methods to `ApiTests.java`:

```java
@Test(description = "Delete a booking")
@Story("Booking API - Delete")
public void testDeleteBooking() {
    ApiHelper api = new ApiHelper("https://automationintesting.online");

    Response response = api.delete("/booking/1");

    Assert.assertEquals(response.getStatusCode(), 201);
}
```

---

## Viewing Reports

### Allure Reports

After running tests, generate and view the Allure report:

```bash
# Generate and open report
mvn allure:serve

# Or generate report to a directory
mvn allure:report
```

The report includes:
- Test execution summary
- Step-by-step test details
- Screenshots on failure
- Test duration and status

---

## CI/CD Integration

The framework includes a GitHub Actions workflow (`.github/workflows/testng.yml`) that:
- Runs tests on every push and pull request
- Generates Allure reports
- Uploads test artifacts

---

## Test Scenarios Covered

### Approach & Prioritization

The test scenarios were chosen based on a **risk-based testing approach**, focusing on:
1. **Critical user journeys** - paths that users must complete successfully
2. **Happy paths first** - ensuring core functionality works before testing edge cases
3. **High-impact failures** - scenarios that would severely impact business operations
4. **Data integrity** - ensuring data is correctly created, updated, and persisted

### Positive Test Scenarios (Happy Paths)

#### 1. Authentication & Navigation (LandingPage Tests)
**Priority: Critical** - Users can't access the system without this
- Admin login with valid credentials
- Navigation to different sections after login
- Verification that navigation elements are visible and accessible

**Why this matters:** Authentication is the gateway to all other functionality. If users can't log in, nothing else matters.

#### 2. Room Creation (CreateRooms Tests)
**Priority: High** - Core business functionality
- Creating new rooms with complete, valid data
- Verifying room creation success
- Validating that created rooms appear in the system

**Why this matters:** Rooms are the core inventory of a B&B. Without rooms, there's no booking business. This is a revenue-generating feature.

#### 3. Branding Management (BrandingTests)
**Priority: Medium-High** - Business identity and customer-facing information
- Updating B&B details (name, description, logo)
- Setting map coordinates and directions
- Managing contact information
- Updating address details
- Form submission with all required fields

**Why this matters:** Branding affects how customers perceive the B&B. Accurate location and contact info is essential for guests to find and contact the property. While not blocking, incorrect information damages reputation and causes operational issues.

#### 4. API Functionality (ApiTests)
**Priority: High** - Backend data management
- Creating bookings via API
- Deleting bookings via API
- Verifying API response codes

**Why this matters:** APIs are used for integrations, third-party booking systems, and potentially mobile apps. Reliable API operations are critical for business operations.


## Tips

- Use `priority` in `@Test` to control test execution order
- Add `@Story` annotations for better Allure report organization
- Extend `Actions` class for custom reusable UI operations
- Use `.env` file for local credentials (never commit this file)

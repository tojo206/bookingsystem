package CommonBase;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Actions {

        private final WebDriver driver;
        private final WebDriverWait wait;
        private final JavascriptExecutor js;

        public Actions(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            this.js = (JavascriptExecutor) driver;
        }


        @Step("Click on element: {name}")
        public void click(WebElement element, String name) {
            String originalStyle = "";
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));

                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
                originalStyle = highlight(element);
                element.click();

                Allure.step("Clicked: " + name);
            } catch (Exception e) {
                captureError("Click failed on: " + name, e);
            } finally {
                restoreStyle(element, originalStyle);
            }
        }

        @Step("Enter '{text}' into: {name}")
        public void sendKeys(WebElement element, String text, String name) {
            String originalStyle = "";
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                originalStyle = highlight(element);

                element.clear();
                element.sendKeys(text);

                Allure.step("Entered text into: " + name);
            } catch (Exception e) {
                captureError("SendKeys failed on: " + name, e);
            } finally {
                restoreStyle(element, originalStyle);
            }
        }

        @Step("Verify element is visible: {name}")
        public void verifyVisible(WebElement element, String name) {
            String originalStyle = "";
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                originalStyle = highlight(element);

                Assert.assertTrue(element.isDisplayed(), name + " is not visible");

                Allure.step("Verified visible: " + name);
            } catch (Exception e) {
                captureError("Visibility check failed on: " + name, e);
            } finally {
                restoreStyle(element, originalStyle);
            }
        }

        private String highlight(WebElement element) {
            try {
                String originalStyle = (String) js.executeScript(
                        "return arguments[0].getAttribute('style') || '';", element);

                js.executeScript(
                        "arguments[0].setAttribute('style', arguments[1] + " +
                                "'; border: 2px solid red; background: yellow;');",
                        element, originalStyle);

                return originalStyle;
            } catch (Exception e) {
                return "";
            }
        }

        private void restoreStyle(WebElement element, String originalStyle) {
            try {
                js.executeScript(
                        "arguments[0].setAttribute('style', arguments[1]);",
                        element, originalStyle);
            } catch (Exception ignored) {}
        }


        private void captureError(String message, Exception e) {
            Allure.step("error " + message);

            try {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot", "image/png",
                        new String(screenshot), ".png");
            } catch (Exception ignored) {}

            Assert.fail(message + " | " + e.getMessage());
        }
    }


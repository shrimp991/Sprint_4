package tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPageScooterService;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class TestAnswerTheQuestion {
    private WebDriver driver;
    @Before
    public void setPropAndStartBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    @Test
    public void checkHowMuchDoesItCost() {
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual = mainPageScooterService.getHowMuchDoesItCostAnswer();
        assertEquals("Текст ответа на совпадает", expected, actual);
    }
    @Test
    public void checkWantSeveralScootersAtOnce() {
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actual = mainPageScooterService.getWantSeveralScootersAtOnceAnswer();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkHowRentalTimeCalculated() {
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actual = mainPageScooterService.getHowRentalTimeCalculatedAnswer();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkPossibleToOrderScooterToday() {
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actual = mainPageScooterService.getPossibleToOrderScooterToday();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkPossibleToExtendOrderOrReturnEarlier() {
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actual = mainPageScooterService.getPossibleToExtendOrderOrReturnEarlier();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkChargingAlongWithScooter() {
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actual = mainPageScooterService.getChargingAlongWithScooter();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkPossibleToCancelOrder() {
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actual = mainPageScooterService.getPossibleToCancelOrder();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkBringScooterBeyondMKAD() {
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actual = mainPageScooterService.getBringScooterBeyondMKAD();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @After
    public void teardown() {
        driver.quit();
    }
}

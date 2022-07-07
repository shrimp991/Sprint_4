package tests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPageScooterService;
import pages.OrderInformationPage;
import static org.hamcrest.CoreMatchers.startsWith;

public class TestMakingTheOrder {
    private WebDriver driver;
    @Before
    public void setPropAndStartBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void TestWithUpperOrderButton() {
        OrderInformationPage orderInformationPage = new OrderInformationPage(driver);
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.clickUpperOrderButton();
        orderInformationPage.creatingAnOrder(
                "Максим",
                "Калинин",
                "Лен. обл. , ул. Новая 11, кв 77",
                "Лубянка",
                "+79993332211",
                "01.01.2001",
                "сутки",
                "чёрный жемчуг",
                "Домофон не работает, позвоните на мобильный");
    }
    @Test
    public void TestWithLowerOrderButton() {
        OrderInformationPage orderInformationPage = new OrderInformationPage(driver);
        MainPageScooterService mainPageScooterService = new MainPageScooterService(driver);
        mainPageScooterService.clickLowerOrderButton();
        orderInformationPage.creatingAnOrder(
                "Дмитрий",
                "Иванов",
                "Москва, ул. Никакая 5, кв. 5",
                "Тверская",
                "+79214463322",
                "12.12.2022",
                "двое суток",
                "серая безысходность",
                "Желательно, чтобы привезли до обеда");
    }
    @After
    public void teardown(){
        OrderInformationPage orderInformationPage = new OrderInformationPage(driver);
        String expected = "Заказ оформлен";
        String actual = orderInformationPage.getNotificationOfOrderCreation();
        Assert.assertThat("Уведомление о создании заказа не появлиось или заказ не создан", actual, startsWith(expected));
        driver.quit();
    }
}

package jaggaer.tests;

import jaggaer.handlers.CommonHandler;
import jaggaer.handlers.ExecutionContext;
import jaggaer.handlers.HPageFactory;
import jaggaer.util.InitConfigUtils;
import jaggaer.webpages.DashboardPage;
import jaggaer.webpages.LoginPage;
import jaggaer.webpages.RecommendationPage;
import jaggaer.webpages.RecommendationRulesPage;
import org.junit.jupiter.api.*;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoTest extends CommonHandler {
    public static CommonHandler  handler;
    public static InitConfigUtils config;

    LoginPage loginPage;
    RecommendationRulesPage recommendationRulesPage;
    RecommendationPage recommendationPage;
    DashboardPage dashboardPage;

    public DemoTest() throws IOException{
    }

    @BeforeAll
    public static void setUpAll() throws IOException {

        config = new InitConfigUtils();
        handler = new CommonHandler();
        initCommonHandler();
        //handler.Driver().manage().deleteAllCookies();
        HPageFactory factory = new HPageFactory(handler);
        new ExecutionContext(factory);

    }

    @BeforeAll
    public void setUpLoginPage() throws IOException {
        loginPage = new LoginPage();
        dashboardPage= new DashboardPage();
        recommendationPage= new RecommendationPage();
        recommendationRulesPage= new RecommendationRulesPage();
    }

    @AfterAll
    public void tearDown(){
        handler.Driver().quit();
    }

    @Test
    @Order(1)
    public void homePageAccessIntoApplication() throws Throwable{
        System.out.println("wrongHomePageAccessIntoApplication");
        try {
            handler.Driver().get(config.getPageProperty("wronghomepage"));
        }
        catch(Exception e){
            Assertions.assertFalse(true);
        }
    }

    @Test
    @Order(2)
    public void firstLoginIntoApplication() throws Throwable{
        System.out.println("wrongLoginIntoApplication");
        handler.Driver().get(config.getPageProperty("homepage"));

        Assertions.assertFalse(loginPage.login(
                config.getProperty("wrongusername"),
                config.getProperty("password")
        ));
    }

    @Test
    @Order(3)
    public void secondLoginIntoApplication() throws Throwable{
        System.out.println("wrongLoginIntoApplication");
        handler.Driver().get(config.getPageProperty("homepage"));

        Assertions.assertFalse(loginPage.login(
                config.getProperty("username"),
                config.getProperty("wrongpassword")
        ));
    }


    @Test
    @Order(4)
    public void loggedIntoApplication() throws Throwable{
        System.out.println("loggedIntoApplication");
        handler.Driver().get(config.getPageProperty("homepage"));

        Assertions.assertTrue(loginPage.login(
                config.getProperty("username"),
                config.getProperty("password")
        ));
    }


 /*   @Test
    @Order(5)
    public void clickSSOLinkOnTheDashboard() throws Throwable{
        System.out.println("dashboard page");
        Assertions.assertTrue(dashboardPage.clickSSOLinkOnDashboard());
    }

    @Test
    @Order(6)
    public void recommendationPageNavigation() throws Throwable{
        System.out.println("recommendation page");
        Assertions.assertTrue(recommendationPage.switchToRecommendationPage());
    }

    @Test
    @Order(7)
    public void recommendationRulesNavigation() throws Throwable{
        System.out.println("recommendationRules page access");
        Assertions.assertTrue(recommendationPage.clickRecommendationRulesLink());
    }

    @Test
    @Order(8)
    public void recommendationRulesPageNavigation() throws Throwable{
        System.out.println("recommendation rules page");
        Assertions.assertTrue(recommendationRulesPage.getPageTitle());
    }*/

}

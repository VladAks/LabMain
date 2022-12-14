package test;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.AvByHomePage;
import service.UserCreator;


public class AvTest extends CommonConditions{

    @Test

    public void AddCommentToAd() {
        String Comment = "This!";
        User testUser = UserCreator.withCredentialsFromProperty();
        String expectedSearchResultsNumber = new AvByHomePage(driver)
                .openPage( "http://av.by")
                .ClickToCloseButton()
                .OpenAdsPage()
                .ClickCook()
                .ClickForFistAds()
                .ClickToComment(Comment)
                .Login(testUser)
                .GetTextInListComment();

        Assert.assertFalse(expectedSearchResultsNumber==Comment,"Successful");
    }

    @Test

    public void SearchTermNumberInThePage() {

        String expectedSearchResultsNumber = new AvByHomePage(driver)
                .openPage( "http://av.by")
                .ClickToCloseButton()
                .OpenAdsPage()
                .ClickCook()
                .ClickForFistAds()
                .ClickToShowNumberButton()
                .GetTextInListNumber();

        Assert.assertFalse(expectedSearchResultsNumber.isEmpty(),"Successful");
    }
}

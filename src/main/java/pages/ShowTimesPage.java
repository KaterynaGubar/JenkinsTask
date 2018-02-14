package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShowTimesPage extends BasePage {

    public boolean isTodaySelected() {
        return $("#one-day").is(checked);
    }

    public boolean isTodaysMoviesDisplayed() {
        String[] currentDates = $$(".date.current").getTexts();
        int currentDay = Integer.parseInt(currentDates[0].substring(0, 2));
        return LocalDateTime.now().getDayOfMonth() == currentDay;
    }

    public void uncheck2dMovies() {
        SelenideElement movies2d = $(byXpath("//*[@class='filters-block__format'][1]/a"));
        movies2d.click();
    }

    public boolean is2dMoviesNotShown(){
        String[] moviesFormat = $$(byClassName("showtimes-line-technology-title")).getTexts();
        for(String e : moviesFormat){
            if(e.contains("2D")){
                return false;
            }
        }
        return true;
    }

    public boolean isTosterPresent(){
        return $(".img-responsive").is(visible);
    }

}

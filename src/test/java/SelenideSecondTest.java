import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSecondTest {

    @Test
    void findSolutionsTest() {
        open("https://github.com");
        $(byTagAndText("button", "Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $(".application-main ").shouldHave(text("Build like the best"));
    }

    @Test
    @Timeout(7)
    void moveActionsTestFall(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");
        actions().clickAndHold(columnA).moveToElement(columnB).release().perform();
        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }

    @Test
    void dragDropTest () {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");
        columnA.shouldHave(text("A"));
        columnB.shouldHave(text("B"));
        columnA.dragAndDrop(to(columnB));
        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }
}


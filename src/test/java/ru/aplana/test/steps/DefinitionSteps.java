package ru.aplana.test.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import ru.aplana.test.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("браузер с открытой страницей market.yandex.ru")
    public void яНаСтартовойСтранице() {
        endUser.gets_start_page();
    }

    @When("я открываю раздел '$sectionName'")
    public void яОткрываюРаздел(String sectionName) {
        endUser.opens_link(sectionName);
    }

    @When("я ввожу цену $limitSide $price")
    public void яВвожуЦену(String limitSide, String price) {
        endUser.enters_text(limitSide, price);
    }

    @When("я выбираю чекбокс $vendor")
    public void яВыбираюЧекбокс(String vendor) {
        endUser.sets_checkbox(vendor);
    }

    @When("я выбираю результат из списка с индексом $index")
    public void яВыбираюРезультатИзСписка(int index) {
        endUser.chooses_result(index);
    }

    @When("я нажимаю кнопку '$buttonText'")
    public void яНажимаюКнопку(String buttonText) {
        endUser.clicks_button(buttonText);
    }

    @Then("я должен увидеть окно с текстом '$windowText'")
    public void яДолженУвидетьОкноСТекстом(String windowText) {
        endUser.should_see_window_with_text(windowText);
    }

}

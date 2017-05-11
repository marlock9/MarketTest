package ru.aplana.test.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import ru.aplana.test.pages.DictionaryPage;

/**
 * Created by marlock on 06.05.17.
 */
public class EndUserSteps {

    DictionaryPage dictionaryPage;
    /*
    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }



    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_start_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
    */
    @Step
    public void gets_start_page() {
        dictionaryPage.open();
    }

    @Step
    public void opens_link(String linkText) {
        dictionaryPage.clickLink(linkText);
    }

    @Step
    public void enters_text(String limitSide, String price) {
        dictionaryPage.typeIntoInputField(limitSide, price);
    }

    @Step
    public void sets_checkbox(String text) {
        dictionaryPage.setCheckbox(text);
    }

    @Step
    public void chooses_result(int index) {
        dictionaryPage.clickSearchResultByIndex(index);
    }

    @Step
    public void clicks_button(String text) {
        dictionaryPage.clickButton(text);
    }

    @Step
    public void should_see_window_with_text(String text) {
        Assert.assertTrue(dictionaryPage.getPurchaseWindowText().contains(text));
    }

}
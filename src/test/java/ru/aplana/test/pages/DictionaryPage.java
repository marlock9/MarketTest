package ru.aplana.test.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://market.yandex.ru")
public class DictionaryPage extends PageObject {

    public void clickLink(String linkText) {
        WebElementFacade link = find(By.linkText(linkText));
        link.click();
    }

    public void typeIntoInputField(String limitSide, String price) {
        List<WebElementFacade> parametersBlocks = findAll(By.cssSelector("span.title__content"));
        WebElementFacade priceBlock = parametersBlocks.stream().filter((el) -> el.getText().equals("Цена, руб.")).findFirst().get();
        WebElementFacade inputField = priceBlock.find(By.xpath("../../..")).find(By.cssSelector(String.format("span[sign-title=%s] input", limitSide)));
        inputField.type(price);
    }

    public void setCheckbox(String text) {
        List<WebElementFacade> checkboxes = findAll(By.cssSelector("label.checkbox__label"));
        WebElementFacade checkbox = checkboxes.stream().filter((el) -> el.getText().equals(text)).findFirst().get();
        checkbox.click();
    }

    private void waitForSearchResultsRendering() {
        waitFor(webDriver -> ((Long) evaluateJavascript("return jQuery.active")) == 1);
        waitFor(webDriver -> ((Long) evaluateJavascript("return jQuery.active")) == 0);
    }

    public void clickSearchResultByIndex(int index) {
        waitForSearchResultsRendering();
        waitForRenderedElements(By.cssSelector("span.snippet-card__header-text"));
        List<WebElementFacade> results = findAll(By.cssSelector("span.snippet-card__header-text"));
        results.get(index-1).click();
    }

    public void clickButton(String text) {
        List<WebElementFacade> buttons = findAll(By.cssSelector("a[type='button'] > span"));
        WebElementFacade button = buttons.stream().filter((el) -> el.getText().equals(text)).findFirst().get().find(By.xpath(".."));
        button.click();
    }

    public String getPurchaseWindowText() {
        waitFor(webDriver -> waitForRenderedElements(By.cssSelector("div.offer-purchase__product-title")));
        return find(By.cssSelector("div.offer-purchase__product-title")).getText();
    }

}

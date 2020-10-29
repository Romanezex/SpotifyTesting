package testpackage.pages;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;


    @DefaultUrl("https://www.spotify.com/ua/signup/")
    public class SignUpPage extends PageObject {






        private By emailField = By.cssSelector("input#email");
        private By confirmEmailField = By.cssSelector("input#confirm");
        private By passwordField = By.cssSelector("input#password");
        private By nameField = By.cssSelector("input#displayname");
        private By monthDropDown = xpath("//select[@id = 'month']");

        //has String type in example
        private String monthDropDownOption = "//select[@id = \"month\"]/option[text() = \"%s\"]";
        private By dayField = By.cssSelector("input#day");
        private By yearField = By.cssSelector("input#year");

        //has String type in example
        private String sexRadioButton = "/html/body/div[1]/main/div[2]/form/div[6]/div[2]/label[3]/span[1]";
        private By shareCheckbox = By.cssSelector("div.Group-sc-1lird8m-0:nth-child(9) > label:nth-child(1) > input");
        private String privacyCheckbox = "/html/body/div[1]/main/div[2]/form/div[9]/label/span[1]";
        private By registerButton = By.cssSelector("button.Button-oyfj48-0");

        private By errorLabel = xpath("//div[@class = 'FormHelpText__Help-e48exm-0 jSRKEf InputErrorMessage__Container-tliowl-0 dKluWf']");
        String errorByText = "//div[@class = 'FormHelpText__Help-e48exm-0 jSRKEf InputErrorMessage__Container-tliowl-0 dKluWf']";




/*    private By errorEmailField = By.xpath("//span[text() = 'You need to enter your email.']");
    private By errorConfirmEmailField = By.xpath("//div[text() = 'You need to confirm your email.']");
    private By errorPasswordField = By.xpath("//span[text() = [//div[text() = 'You need to enter a password.']");
    private By errorNameField = By.xpath("//span[text() = '//div[text() = 'Enter a name for your profile.']");

    private By errorDayField = By.xpath("//span[text() = '//div[text() = 'Enter a valid day of the month.']");
    private By errorYearField = By.xpath("//span[text() = '//div[text() = 'Select your birth month.']");
    private By errorMonthDropDown = By.xpath("//span[text() = '//div[text() = 'Enter a valid year.']");
    private By errorSexRadioButton = By.xpath("//span[text() = '//div[text() = 'Select your gender.']");
    private By errorPrivacyCheckbox = By.xpath("//span[text() = '//div[text() = 'Please accept the terms and conditions to continue.']");*/


        public SignUpPage typeEmail(String email) {
            find(emailField).sendKeys(email);
            return this;
        }

        public SignUpPage typeConfirmEmailField(String email) {
            find(confirmEmailField).sendKeys(email);
            return this;
        }

        public SignUpPage typePassword(String password) {
            find(passwordField).sendKeys(password);
            return this;
        }

        public SignUpPage typeName(String name) {
            find(nameField).sendKeys(name);
            return this;
        }

        public SignUpPage setMonth(String month) {
            find(monthDropDown).click();
            find(xpath(format(monthDropDownOption, month))).waitUntilVisible();
            return this;
        }



        public SignUpPage typeDay(String day) {
            find(dayField).sendKeys(day);
            return this;
        }

        public SignUpPage typeYear(String year) {
            find(yearField).sendKeys(year);
            return this;
        }

/*    public SignUpPage setSex(String value) {
        driver.findElement(xpath(format(sexRadioButton, value))).click();
        return this;}*/

        public SignUpPage setSex() {
            find(xpath(sexRadioButton)).click();
            return this;
        }

        public SignUpPage setShare(boolean value) {
            WebElement checkbox = find(shareCheckbox);
            if (!checkbox.isSelected() == value) {
                checkbox.click();
            }
            return this;
        }

        public SignUpPage setPrivacy() {
            find(xpath(privacyCheckbox)).click();
            return this;
        }

        public void clickSignUpButton() {
            find(registerButton).click();
        }



        public ListOfWebElementFacades getErrors() {
            return findAll(errorLabel);
        }

        public String getErrorByNumber(int number) {
            return getErrors().get(number - 1).getText();
        }

        public boolean isErrorVisible(String message) {
            return findAll(xpath(format(errorByText, message))).size() > 0 && findAll(xpath(format(errorByText, message))).get(0).isDisplayed();
        }


}

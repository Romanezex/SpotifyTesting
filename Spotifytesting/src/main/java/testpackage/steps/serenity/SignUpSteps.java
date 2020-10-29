package testpackage.steps.serenity;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import testpackage.pages.SignUpPage;

public class SignUpSteps {

    SignUpPage page;

    @Step
    public void open_signup_page(){
        page.open();
    }

    @Step
    public void type_email(String mail) {
        page.typeEmail(mail);
    }

    @Step
    public void type_confirmation_email(String mail) {
        page.typeConfirmEmailField(mail);
    }

    @Step
    public void type_password(String password) {
        page.typePassword(password);
    }

    @Step
    public void type_name(String name) {
        page.typeName(name);
    }

    @Step
    public void set_month(String month) {
        page.setMonth(month);
    }

    @Step
    public void set_day(String day) {
        page.typeDay(day);
    }

    @Step
    public void set_year(String year) {
        page.typeYear(year);
    }


    @Step
    public void select_sex() {
        page.setSex();
    }

    @Step
    public void set_share(boolean value) {
        page.setShare(value);
    }

    @Step
    public void set_privacy(){page.setPrivacy();}

    @Step
    public void click_signup() {
        page.clickSignUpButton();
    }

    @Step
    public void should_see_error(String message) {
        Assertions.assertThat(page.isErrorVisible(message))
                .as("User should see error but he doesn't")
                .isTrue();

    }

    @Step
    public void should_not_see_error(String message) {
        Assertions.assertThat(page.isErrorVisible(message))
                .as("User should not see message, but he does")
                .isFalse();
    }



    @Step
    public void should_see_errors_count(int count) {
        Assertions.assertThat(page.getErrors()).hasSize(count);
    }



    @Step
    public void should_see_error_by_number(int number, String message) {
        Assertions.assertThat(page.getErrorByNumber(number)).isEqualTo(message);
    }

}

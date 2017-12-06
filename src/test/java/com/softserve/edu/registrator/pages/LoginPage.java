package com.softserve.edu.registrator.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.users.IUser;

public class LoginPage extends ATopComponent {

	public static enum LoginPageL10n {
		LOGIN_LABEL("Логін", "Логин", "Login"),
		PASSWORD_LABEL("Пароль", "Пароль", "Password"),
		SUBMIT_BUTTON("Увійти", "Войти", "Sign in");

		private HashMap<ChangeLanguageFields, String> field;

		private LoginPageL10n(String... localization) {
			this.field = new HashMap<ChangeLanguageFields, String>();
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				this.field.put(language, localization[i]);
				i++;
			}
		}

		public String getLocalization(ChangeLanguageFields language) {
			return this.field.get(language).trim();
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private static final String REGISTER_ERROR = "Button Register not Found";
	public static final String NAME_IMAGE = "ukraine_logo2.gif";
	//
	private static final String LOGIN_LABEL_XPATH = "//label[contains(@for,'inputEmail')]";
	private static final String LOGIN_INPUT_ID = "login";
	private static final String PASSWORD_LABEL_XPATH = "//label[contains(@for,'inputPassword')]";
	private static final String PASSWORD_INPUT_ID = "password";
	private static final String SIGNIN_CSSSELECTOR = "button.btn.btn-primary";
	private static final String LOGO_CSSSELECTOR = "img.login_logo.col-md-8.col-xs-12";
	private static final String REGISTER_CSSSELECTOR = ".btn.btn-success";

	// Fields

	private WebElement loginLabel;
	private WebElement loginInput;
	private WebElement passwordLabel;
	private WebElement passwordInput;
	private WebElement signin;
	private WebElement logo;
	private List<WebElement> register;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.loginLabel = driver.findElement(By.xpath(LOGIN_LABEL_XPATH));
		this.loginInput = driver.findElement(By.id(LOGIN_INPUT_ID));
		this.passwordLabel = driver.findElement(By.xpath(PASSWORD_LABEL_XPATH));
		this.passwordInput = driver.findElement(By.id(PASSWORD_INPUT_ID));
		this.signin = driver.findElement(By.cssSelector(SIGNIN_CSSSELECTOR));
		this.logo = driver.findElement(By.cssSelector(LOGO_CSSSELECTOR));
		//
		//this.loginLabel = Search.xpath(LOGIN_LABEL_XPATH);
		//this.loginInput = Search.id(LOGIN_INPUT_ID);
		// Search.setExplicitVisibleStrategy();
		//this.passwordLabel = Search.xpath(PASSWORD_LABEL_XPATH);
		//this.passwordInput = Search.id(PASSWORD_INPUT_ID);
		// Search.setExplicitClickableStrategy();
		//this.signin = Search.cssSelector(SIGNIN_CSSSELECTOR);
		// Search.setImplicitStrategy();
		//this.logo = Search.cssSelector(LOGO_CSSSELECTOR);
	}
	
	// PageObject

	// get Data

	public WebElement getLoginLabel() {
		return this.loginLabel;
	}

	public WebElement getLoginInput() {
		return this.loginInput;
	}

	public WebElement getPasswordLabel() {
		return this.passwordLabel;
	}

	public WebElement getPasswordInput() {
		return this.passwordInput;
	}

	public WebElement getSignin() {
		return this.signin;
	}

	public WebElement getLogo() {
		return this.logo;
	}

	public boolean isRegisterExist() {
        //register = Search.cssSelectors(REGISTER_CSSSELECTOR);
	    register = driver.findElements(By.cssSelector(REGISTER_CSSSELECTOR));
        return register.size() > 0;
    }
	
	public WebElement getRegister() {
		// TODO Check WebElement Exist
		//return Search.cssSelector(REGISTER_CSSSELECTOR);
	    if (!isRegisterExist()) {
            //throw new GeneralCustomException(REGISTER_ERROR);
	        throw new RuntimeException(REGISTER_ERROR);
        }
        return register.get(0);
	}

	// Functional

	public String getLoginLabelText() {
		return getLoginLabel().getText().trim();
	}

	public String getLoginInputAttributeText(String attribute) {
		return getLoginInput().getAttribute(attribute);
	}

	public String getLoginInputText() {
		return getLoginInputAttributeText(VALUE_ATTRIBUTE);
	}

	public String getPasswordLabelText() {
		return getPasswordLabel().getText().trim();
	}

	public String getPasswordInputAttributeText(String attribute) {
		return getPasswordInput().getAttribute(attribute);
	}

	public String getPasswordInputText() {
		return getPasswordInputAttributeText(VALUE_ATTRIBUTE);
	}

	public String getSignintText() {
		return getSignin().getText().trim();
	}

	public String getLogoAttributeText(String attribute) {
		return getLogo().getAttribute(attribute).trim();
	}

	public String getLogoAttributeSrcText() {
		return getLogoAttributeText(SRC_ATTRIBUTE);
	}

	public String getRegisterText() {
        System.out.println("\t+++ getRegisterText() DONE");
        return getRegister().getText().trim();
    }
	
	// set Data

	public void setLoginInput(String login) {
		getLoginInput().sendKeys(login);
	}

	public void setLoginInputClear(String login) {
		clearLoginInput();
		setLoginInput(login);
	}

	public void setPasswordInput(String password) {
		getPasswordInput().sendKeys(password);
	}

	public void setPasswordInputClear(String password) {
		clearPasswordInput();
		setPasswordInput(password);
	}

	public void clearLoginInput() {
		getLoginInput().clear();
	}

	public void clearPasswordInput() {
		getPasswordInput().clear();
	}

	public void clickLogin() {
		getLoginInput().click();
	}

	public void clickPassword() {
		getPasswordInput().click();
	}

	public void clickSignin() {
		getSignin().click();
	}

	public void clickRegister() {
		getRegister().click();
	}

	// Business Logic

	public LoginPage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		return new LoginPage(driver);
	}

	private void setLoginData(IUser user) {
		setLoginInputClear(user.getEmail());
		setPasswordInputClear(user.getPassword());
		clickSignin();
	}

//	public CommonPage successLogin(IUser user) {
//		setLoginData(user);
//		return new CommonPage();
//	}

    public LoginPage unsuccessfulLogin(IUser invalidUser) {
        setLoginData(invalidUser);
        return new LoginPage(driver); 
    }

//	public AdminHomePage successAdminLogin(IUser admin) {
//		setLoginData(admin);
//		return new AdminHomePage();
//	}

//	public RegistratorHomePage successRegistratorLogin(IUser registrator) {
//		setLoginData(registrator);
//		return new RegistratorHomePage();
//	}

}

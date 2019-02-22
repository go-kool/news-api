import { protractor, browser } from 'protractor';
import { SignUpPage } from './01signup.po';

describe('Signup page Testing', () => {
    let page: SignUpPage;
    

    beforeEach(() => {
        page = new SignUpPage();
        page.navigateToSignupPage();
    });

    it('should be able to signup', () => {
        page.sendNameForSignUp().sendKeys('Testing');
        page.sendEmailForSignUp().sendKeys('Testing@Test.com');
        page.sendPasswordForSignUp().sendKeys('Test@123');
        page.sendSignupButtonForSignUp().click();
        browser.waitForAngular();
        expect(browser.driver.getCurrentUrl()).toContain('/login');
    });

    it('should display the error message in signup', () => {
        page.sendNameForSignUp().sendKeys('Testing');
        page.sendEmailForSignUp().sendKeys('Testing@Test.com');
        page.sendPasswordForSignUp().sendKeys('Test@123');
        page.sendSignupButtonForSignUp().click();
        browser.waitForAngular();
        expect(browser.driver.getCurrentUrl()).toContain('/signup');
    });
});
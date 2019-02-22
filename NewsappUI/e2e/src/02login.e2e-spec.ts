import { protractor, browser } from 'protractor';
import { LoginPage } from './02login.po';


describe('Login page Testing', () => {
    let page: LoginPage;
   

    beforeEach(() => {
        page = new LoginPage();
        page.navigateToLoginPage();
    });

    it('should not be able to Login with wrong credentials', () => {
       
        page.sendEmailForLogin().sendKeys('Testing@Test.com');
        page.sendPasswordForLogin().sendKeys('Test@12');
        page.sendLoginButtonForLogin().click();
        browser.waitForAngular();
        expect(browser.driver.getCurrentUrl()).toContain('/login');
    });
    
    it('should be able to Login', () => {
       
        page.sendEmailForLogin().sendKeys('Testing@Test.com');
        page.sendPasswordForLogin().sendKeys('Test@123');
        page.sendLoginButtonForLogin().click();
        browser.waitForAngular();
        expect(browser.driver.getCurrentUrl()).toContain('/Dashboard');
    });

   
})

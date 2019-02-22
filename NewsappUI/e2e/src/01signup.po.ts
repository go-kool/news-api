import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class SignUpPage {

    navigateToSignupPage() {
        return browser.get('/signup');
    }

    sendNameForSignUp() {
        return element(by.id('name'));
    }

    sendEmailForSignUp() {
        return element(by.id('email'));
    }

    sendPasswordForSignUp() {
        return element(by.id('password'));
    }

    sendSignupButtonForSignUp() {
        return element(by.id('signupbutton'));
    }
}
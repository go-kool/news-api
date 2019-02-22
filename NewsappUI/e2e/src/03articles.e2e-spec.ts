import { protractor, browser } from 'protractor';
import { ArticlesPage } from './03Articles.po';
import { by } from 'protractor';

describe('Signup page Testing', () => {
    let page: ArticlesPage;
   

    beforeEach(() => {
        page = new ArticlesPage();
    });


    it('should be able to search for any article and add them to favourite and look them under favourites section', () => {
        page.sendSearchField().sendKeys('trump');
        page.sendSearchButton().click();
        browser.waitForAngular();
        browser.sleep(5000);
        page.sendStarButton3().click();
        page.sendStarButton4().click();
        page.sendFavouriteFromNavBar().click();
        browser.sleep(5000);
        expect(browser.driver.getCurrentUrl()).toContain('/favourite');
    });

    it('should be able to log out ',()=>{
        page.sendLogoutFromNavBar().click();
        browser.waitForAngular();
        expect(browser.driver.getCurrentUrl()).toContain('/login');
    })
})

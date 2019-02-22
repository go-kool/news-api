import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class ArticlesPage {

    navigateToArticlesPage() {
        return browser.get('/Dashboard');
    }

    sendSearchField() {
        return element(by.id('txtSearch'));
    }

    sendSearchButton()
    {
        return element(by.id('searchbutton'))
    }

    sendStarButton3()
    {
        return element(by.id('3'))
    }

    sendStarButton4()
    {
        return element(by.id('4'))
    }


    sendFavouriteFromNavBar()
    {
        return element(by.id('favourite'))   
    }
   
    sendLogoutFromNavBar()
    {
        return element(by.id('logout'))   
    }
}
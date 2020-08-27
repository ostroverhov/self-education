const {describe, it} = require('mocha');
const MainPage = require('./pages/mainPage');
const ResultPage = require('./pages/resultPage');
const Browser = require('./../framework/browser');
const {assert} = require('chai');
const flightModel = require('../flightModel');
const chai = require('chai'), chaiHttp = require('chai-http');
chai.use(chaiHttp);

describe('Aviasales TestSuite', () => {
    let browser;

    before(() => {
        browser = new Browser();
        browser.setUpDriver();
        this.mainPage = new MainPage(browser);
        this.resultPage = new ResultPage(browser);
    });

    after(() => {
        browser.quit();
    });

    it('should check mainpage is opened', async () => {
        assert.isTrue(await this.mainPage.isDisplayed(), 'Page is not opened');
    });

    it('should selected ticket', async () => {
        await this.mainPage.fillSearchForm(
            flightModel.originCity,
            flightModel.destinationCity,
            flightModel.departureDate,
            flightModel.returnDate
        );
        assert.equal(JSON.stringify(flightModel), JSON.stringify(await this.resultPage.getSearchParameters()), 'Check flight parameters');
    });

    it('get faster flight', () => {
        this.resultPage.getFastestFlight();
    });
});
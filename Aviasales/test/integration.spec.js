const {describe, it} = require('mocha');
const HomePage = require('./pages/mainPage');
const Browser = require('./../framework/browser');
const {assert} = require('chai');
const bikes = require('./../app/bikes.json');
const chai = require('chai'), chaiHttp = require('chai-http');
chai.use(chaiHttp);

describe('Aviasales TestSuite', () => {
    let browser;
    let className1 = 'comfort';
    let className2 = 'endurance';
    let className3 = 'race';

    before(async () => {
        browser = new Browser();
        await browser.setUpDriver();
        this.homePage = new HomePage(browser);
    });

    after(async () => {
        await browser.quit();
    });

    afterEach(async () => {
        await browser.getScreenshot();
    });

    it('should check homepage is opened', async () => {
        assert.isTrue(await this.homePage.isDisplayed(), 'Page is not opened');
    });

    it('should find name, image, description and class for each bike from /app/bikes.json', async () => {
        for (let i = 0; i < bikes.items.length; i++) {
            assert.isTrue(await this.homePage.findBike(i), `[id=${i}] Bike was not found`);
        }
    });

    it('should sort bikes by 1 class', async () => {

        await this.homePage.clickCheckBoxFilter(className1);
        assert.isTrue(await this.homePage.isFilterSuccess(className1));

        await browser.refresh();
        assert.isTrue(await this.homePage.isFilterSuccess(className1));
    });

    it('should sort bikes by 2 classes', async () => {
        await this.homePage.clickCheckBoxFilter(className1);

        await this.homePage.clickCheckBoxFilter(className1);
        await this.homePage.clickCheckBoxFilter(className2);

        assert.isTrue(await this.homePage.isFilterSuccess(className1));
        assert.isTrue(await this.homePage.isFilterSuccess(className2));
    });

    it('should sort bikes by 3 classes', async () => {
        await this.homePage.clickCheckBoxFilter(className1);
        await this.homePage.clickCheckBoxFilter(className2);

        await this.homePage.clickCheckBoxFilter(className1);
        await this.homePage.clickCheckBoxFilter(className2);
        await this.homePage.clickCheckBoxFilter(className3);
        assert.isTrue(await this.homePage.isFilterSuccess(className1));
        assert.isTrue(await this.homePage.isFilterSuccess(className2));
        assert.isTrue(await this.homePage.isFilterSuccess(className3));
    });

    it('should check a JSON object and bikes at https://jujhar.com/bikes.json', async () => {
        chai.request('https://jujhar.com').get('/bikes.json').end((err, response) => {
            assert.isNull(err, `There is an error: ${err}`);
            assert.deepEqual(JSON.parse(response.text), bikes, 'JSON object is not relevant');
        });
        await browser.navigate('https://jujhar.com/bikes.json');
    });
});
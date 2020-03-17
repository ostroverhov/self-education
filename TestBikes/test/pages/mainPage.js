const BasePage = require('../../framework/basePage');
const logger = require('../../framework/utils/log.util');
const panel = require('../elements/panel');
const checkBox = require('../elements/checkBox');
const Case = require('case');
const {By} = require('selenium-webdriver');
const retry = require('async-retry');
const bikes = require('../../app/bikes.json');
const locators = {
    pageLoc: By.xpath('//h1[contains(text(), "Bike Store")]'),
    bikeClasses: By.xpath('//div[contains(@class, "panel-footer")]'),
    bikeLoc: (name, img, desc, cl) => `//*[contains(text(), "${name}")][//*[contains(@src, "${img}")]][//*[contains(text(), "${desc}")]][//*[contains(text(), "${cl}")]]`,
    filterLoc: (filter) => `//span[contains(text(), "${filter}")]/preceding-sibling::input`
};

function isTrue(smth) {
    return smth === true;
}

class MainPage extends BasePage {

    constructor(browser) {
        super(browser, locators.pageLoc, "Home page");
    }

    async getBikePanel(name, img, desc, cl) {
        return new panel(this.browser, name, By.xpath(locators.bikeLoc(name, img, desc, cl)));
    }

    async getCheckBoxFilter(name) {
        return new checkBox(this.browser, name, By.xpath(locators.filterLoc(name)));
    }

    async getBikesClasses(name) {
        return new panel(this.browser, name, locators.bikeClasses);
    }

    async findBike(i) {
        logger.info(`Find bike id = ${i}`);
        let results = [];
        for (let j = 0; j < bikes.items[i].class.length; j++) {
            results[j] = await (await this.getBikePanel(bikes.items[i].name, bikes.items[i].image.thumb, bikes.items[i].description, bikes.items[i].class[j])).isDisplayedElement();
        }
        return results.every(isTrue);
    }

    async clickCheckBoxFilter(className) {
        logger.info(`Click checkBox ${className}`);
        await retry(async () => {
            (await this.getCheckBoxFilter(className)).findAndClick();
        }, {
            retries: 5,
            minTimeout: 1,
            maxTimeout: 3
        });
    }

    async isFilterSuccess(className) {
        logger.info(`Check is filter ${className} success`);
        let results = [];
        const classes =  (await this.getBikesClasses("panel")).findElementsFromPage();
        for (let i = 0; i < classes.length; i++) {
            results[i] = Case.lower(classes[i].getText()).includes(className);
        }
        return results.every(isTrue);
    }
}

module.exports = MainPage;
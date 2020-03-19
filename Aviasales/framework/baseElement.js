const logger = require('./utils/log.util');
require('selenium-webdriver');

class BaseElement {

    constructor(browser, name, locator) {
        logger.info(`Create element ${name}`);
        this.browser = browser;
        this.name = name;
        this.locator = locator;
    }

    async findAndClick() {
        logger.info(`Find element and click ${this.name}`);
        let element = await this.findElement().catch((error) => {
            logger.warning(`${error}`);
        });
        await element.click().catch((error) => {
            logger.warning(`${error}`);
        });
    }

    async findElement() {
        logger.info(`Find element ${this.name}`);
        return await this.browser.driver.findElement(this.locator).catch((error) => {
            logger.warning(`${error}`);
        });
    }

    async findElementsFromPage() {
        logger.info(`Find elements ${this.name}`);
        return await this.browser.driver.findElements(this.locator).catch((error) => {
            logger.warning(`${error}`);
        });
    }

    async isDisplayedElement() {
        logger.info(`Is displayed element ${this.name}`);
        return await this.browser.driver.findElement(this.locator).isDisplayed().catch((error) => {
            logger.warning(`${error}`);
        });
    }

    async getText() {
        logger.info(`Get text from element ${this.name}`);
        return this.browser.driver.findElement(this.locator).getText().catch((error) => {
            logger.warning(`${error}`);
        });
    }
}

module.exports = BaseElement;
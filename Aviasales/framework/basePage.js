const logger = require('./utils/log.util');

class BasePage {

    constructor(browser, locator, namePage) {
        logger.info(`Create page ${namePage}`);
        this.browser = browser;
        this.locator = locator;
    }

    async isDisplayed() {
        logger.info(`Is displayed page ${this.name}`);
        return (this.browser.driver.findElement(this.locator)).isDisplayed().catch((error) => {
            logger.warning(`${error}`);
        });
    }

    async setValue(script) {
        logger.info(`Set attribute to element ${this.name}`);
        return await this.browser.driver.executeScript(script).catch((error) => {
            logger.warning(`${error}`);
        });
    }
}

module.exports = BasePage;
const BaseElement = require('../../framework/baseElement');
const logger = require('../../framework/utils/log.util');

class TextBox extends BaseElement {

    constructor(browser, name, locator) {
        logger.info(`Create text box ${name}`);
        super(browser, `TextBox ${name}`, locator);
    }

    async cleanAndTypeText(text) {
        logger.info(`Clean and type text ${text} to element ${this.name}`);
        await this.browser.driver.findElement(this.locator).then((element) => {
            element.clear();
            element.clear();
            element.sendKeys(text);
        }).catch((error) => {
            logger.warning(`${error}`);
        });
    }
}

module.exports = TextBox;
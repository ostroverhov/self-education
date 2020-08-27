const BaseElement = require('../../framework/baseElement');
const logger = require('../../framework/utils/log.util');

class Button extends BaseElement {

    constructor(browser, name, locator) {
        logger.info(`Create button ${name}`);
        super(browser,`Button ${name}`, locator);
    }
}

module.exports = Button;
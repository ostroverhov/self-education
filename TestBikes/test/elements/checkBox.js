const BaseElement = require('../../framework/baseElement');
const logger = require('../../framework/utils/log.util');

class CheckBox extends BaseElement {

    constructor(browser, name, locator) {
        logger.info(`Create panel ${name}`);
        super(browser,`CheckBox ${name}`, locator);
    }
}

module.exports = CheckBox;
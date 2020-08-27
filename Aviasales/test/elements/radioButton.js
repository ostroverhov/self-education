const BaseElement = require('../../framework/baseElement');
const logger = require('../../framework/utils/log.util');

class RadioButton extends BaseElement {

    constructor(browser, name, locator) {
        logger.info(`Create radioButton ${name}`);
        super(browser,`RadioButton ${name}`, locator);
    }
}

module.exports = RadioButton;
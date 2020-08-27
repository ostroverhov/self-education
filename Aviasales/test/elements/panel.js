const BaseElement = require('../../framework/baseElement');
const logger = require('../../framework/utils/log.util');

class Panel extends BaseElement {

    constructor(browser, name, locator) {
        logger.info(`Create panel ${name}`);
        super(browser,`Panel ${name}`, locator);
    }
}

module.exports = Panel;
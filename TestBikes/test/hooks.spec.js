const logger = require('./../framework/utils/log.util');

before(async () => {
    logger.info('Test run started');
});

after(async () => {
    logger.info('Test run finished');
});

beforeEach(async () => {
    logger.info(`Test started`);
});

afterEach(async () => {
    logger.info('Test finished');
});
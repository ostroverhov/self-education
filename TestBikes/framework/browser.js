require('chromedriver');
require('geckodriver');
const {Builder} = require('selenium-webdriver');
const config = require('../config.json');
const logger = require('./utils/log.util');
const fs = require('fs');

class Browser {

    constructor() {
        this.driver;
    }

    async setUpDriver() {
        logger.info('Browser is started');
        try {
            switch (config.browser) {
                case 'chrome':
                    this.driver = new Builder().forBrowser('chrome').build();
                    break;
                case 'firefox':
                    this.driver = new Builder().forBrowser('firefox').build();
                    break;
                default:
                    logger.info("Select browser chrome/firefox");
                    break;
            }
            await this.driver.get(config.startURL);
            await this.driver.manage().window().maximize();
            await this.driver.manage().setTimeouts(config.timeouts);
        } catch (error) {
            logger.error(`Cannot start browser: ${error}`);
        }
    }

    async quit() {
        logger.info("Quit from driver");
        await this.driver.quit().catch((error) => {
            logger.warning(`Error during closing the browser: ${error}`);
        });
    }

    async refresh() {
        logger.info("Refresh page");
        await this.driver.navigate().refresh().catch((error) => {
            logger.warning(`Error during closing the browser: ${error}`);
        });
    }

    async getScreenshot() {

        // this.driver.takeScreenshot().then(function(data){
        //     var base64Data = data.replace(/^data:image\/png;base64,/,"")
        //     fs.writeFile(`out${testName}.png`, base64Data, 'base64', function(err) {
        //         if(err) console.log(err);
        //     });
        // });


        return await this.driver.takeScreenshot().catch((error) => {
            logger.warning(`${error}`);
        });
    }

    async navigate(url) {
        logger.info(`Navigate to ${url}`);
        await this.driver.get(url).catch((error) => {
            logger.warning(`Error during closing the browser: ${error}`);
        });
    }
}

module.exports = Browser;
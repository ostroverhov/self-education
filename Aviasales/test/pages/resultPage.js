const BasePage = require('../../framework/basePage');
const logger = require('../../framework/utils/log.util');
const panel = require('../elements/panel');
const textBox = require('../elements/textBox');
const button = require('../elements/button');
const {By} = require('selenium-webdriver');
const regExpYear = '\\d{4}';
const regExpMonth = '\\.(\\d{2})\\.';
const regExpDay = '(\\d{2})';
const locators = {
    pageLoc: By.xpath(`//div[contains(@class, "--compact")]`),
    originLoc: By.id('origin'),
    destinationLoc: By.id('destination'),
    dateDepartureLoc: By.xpath(`//div[contains(@class, "--departure")]/input`),
    dateReturnLoc: By.xpath(`//div[contains(@class, "--return")]/input`),
    dateLoc: By.xpath(`//div[contains(@class, "--departure")]`),
    calendarLoc: By.xpath(`//div[@class='trip-duration__dropdown']`),
    countDownLoc: By.xpath(`//div[@class='countdown']`),
    fastestFlightLoc: By.xpath(`//span[contains(text(), 'Самый быстрый')]`),
};
const fields = {
    originField: (browser) => new textBox(browser, `Origin field`, locators.originLoc),
    destinationField: (browser) => new textBox(browser, `Destination field`, locators.destinationLoc),
    dateField: (browser) => new textBox(browser, `Date field`, locators.dateLoc),
    dateDepartureField: (browser) => new textBox(browser, `Date departure field`, locators.dateDepartureLoc),
    dateReturnField: (browser) => new textBox(browser, `Date departure field`, locators.dateReturnLoc),
    calendarDropDown: (browser) => new panel(browser, `Calendar dropdown`, locators.calendarLoc),
    fastestFlightButton: (browser) => new button(browser, `Duration flight panel`, locators.fastestFlightLoc),
    countDownPanel: (browser) => new panel(browser, `Countdown panel`, locators.countDownLoc)
};

class ResultPage extends BasePage {

    constructor(browser) {
        super(browser, locators.pageLoc, "Result page");
    }

    async getSearchParameters() {
        logger.info(`Get search parameters`);
        await fields.dateField(this.browser).findAndClick();
        await fields.calendarDropDown(this.browser).waitOfPresence();
        let departureDateString = await fields.dateDepartureField(this.browser).getAttributeValue();
        let returnDateString = await fields.dateReturnField(this.browser).getAttributeValue();
        return {
            originCity: await fields.originField(this.browser).getAttributeValue(),
            destinationCity: await fields.destinationField(this.browser).getAttributeValue(),
            departureDate: this.getDate(departureDateString),
            returnDate: this.getDate(returnDateString)
        };
    }

    async getFastestFlight() {
        logger.info(`Get fastest flight`);
        fields.countDownPanel(this.browser).waitOfHide();
        await fields.fastestFlightButton(this.browser).findAndClick().catch((error) => {
            logger.warning(`${error}`);
        });
    }

    getDate(stringDate) {
        logger.info(`Get date`);
        let stringYearDeparture = stringDate.match(regExpYear)[0];
        let stringMonthDeparture = stringDate.match(regExpMonth)[1] - 1;
        let stringDayDeparture = stringDate.match(regExpDay)[0];
        return new Date(
            stringYearDeparture, stringMonthDeparture, stringDayDeparture
        ).toDateString();
    }
}

module.exports = ResultPage;
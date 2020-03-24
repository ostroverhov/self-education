const BasePage = require('../../framework/basePage');
const logger = require('../../framework/utils/log.util');
const panel = require('../elements/panel');
const textBox = require('../elements/textBox');
const radioButton = require('../elements/radioButton');
const button = require('../elements/button');
const {By} = require('selenium-webdriver');
const locators = {
    pageLoc: By.xpath(`//div[@class='forms-resolver__forms-wrap']`),
    originLoc: By.id('origin'),
    destinationLoc: By.id('destination'),
    dateDepartureLoc: By.xpath(`//div[contains(@class, "--departure")]`),
    dateReturnLoc: By.xpath(`//div[contains(@class, "--return")]`),
    calendarDateLoc: (date) => By.xpath(`//div[@aria-label='${date}']`),
    dropDownPassengersAndClassLoc: By.xpath(`//div[contains(@class, "--avia")]`),
    checkBoxClassLoc: By.xpath(`//div[contains(@class, "--avia")]`),
    buttonSubmitLoc: By.xpath(`//span[@class='b-button__text']`),
};
const fields = {
    originField: (browser) => new textBox(browser, `Origin field`, locators.originLoc),
    destinationField: (browser) => new textBox(browser, `Destination field`, locators.destinationLoc),
    dateDepartureField: (browser) => new textBox(browser, `Date departure field`, locators.dateDepartureLoc),
    calendarDatePanel: (browser, date) => new panel(browser, `Date from calendar field`, locators.calendarDateLoc(date)),
    dropDownPassengersAndClass: (browser) => new panel(browser, `Panel info about passengers and class`, locators.dropDownPassengersAndClassLoc),
    radioButtonEconomyClass: (browser) => new radioButton(browser, `Panel info about passengers and class`, locators.dropDownPassengersAndClassLoc),
    buttonSubmit: (browser) => new button(browser, `Button submit`, locators.buttonSubmitLoc)
};

class MainPage extends BasePage {

    constructor(browser) {
        super(browser, locators.pageLoc, "Main page");
    }

    async fillSearchForm(origin, destination, departureDate, returnDate) {
        logger.info(`Fill search form ${origin}, ${destination}, ${departureDate}, ${returnDate}`);
        await this.inputOriginCity(origin);
        await this.inputDestinationCity(destination);
        await this.inputDateRange(departureDate, returnDate);
        await this.selectEconomyClass();
        await this.clickSubmit();
    }

    async inputOriginCity(origin) {
        logger.info(`Input origin city ${origin}`);
        fields.originField(this.browser).cleanAndTypeText(origin);
    }

    async inputDestinationCity(destination) {
        logger.info(`Input destination ciry ${destination}`);
        fields.destinationField(this.browser).cleanAndTypeText(destination);
    }

    async inputDateRange(departureDate, returnDate) {
        logger.info(`input date range from ${departureDate} to ${returnDate}`);
        await fields.dateDepartureField(this.browser).findAndClick();
        await fields.calendarDatePanel(this.browser, departureDate).findAndClick();
        await fields.calendarDatePanel(this.browser, returnDate).findAndClick();
    }

    async selectEconomyClass() {
        logger.info(`Select economy class`);
        await fields.dropDownPassengersAndClass(this.browser).findAndClick();
        await fields.radioButtonEconomyClass(this.browser).findAndClick();
    }

    async clickSubmit() {
        logger.info(`Click button submit`);
        await fields.buttonSubmit(this.browser).waitOfPresence();
        await fields.buttonSubmit(this.browser).findAndClick();
    }
}

module.exports = MainPage;
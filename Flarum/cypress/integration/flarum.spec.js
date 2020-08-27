const credentials = require('./../../credentials');

context('Test flarum', () => {
    beforeEach(() => {
        cy.visit('https://discuss.flarum.org/')
    });

    it('Open and check main page flarum', () => {
        cy.get('.Header-logo')
            .should('be.visible')
            .and('have.attr', 'src');
    });

    it('Login at flarum and work with bio', () => {
        cy.log('Login at flarum');
        cy.login(credentials.login, credentials.password);

        cy.log('Click name of user and check dropdown menu');
        cy.contains(credentials.login).click();
        cy.get('.item-session > .ButtonGroup > .Dropdown-menu > li').should(($item) => {
            expect($item).to.have.length(4);
            expect($item.eq(0)).to.contain('Profile');
            expect($item.eq(1)).to.contain('Settings');
            expect($item.eq(3)).to.contain('Log Out')
        });

        cy.log('Click profile of user and check name and status');
        cy.contains('Profile').click();
        cy.contains('Online').should('be.visible');
        cy.contains(credentials.login).should('be.visible');

        cy.log('Type bio about user');
        cy.server();
        cy.route('GET', '/api/posts?*').as('getProfile');
        cy.visit(`https://discuss.flarum.org/u/${credentials.login}`).wait('@getProfile').its('url').then(url => {
            cy.log('Type bio about user and check');
            cy.typeText('qwerty');
            cy.contains('Online').click();
            cy.contains('qwerty').should('be.visible');

            cy.log('Stubbing bio about user and check');
            cy.typeText('here i am');
            cy.request(`/api/users/${url.match(credentials.pattern)[0]}`).its('body').as('changeBody');
            cy.get('@changeBody').then(body => {
                body.data.attributes.bio = 'stubbed bio';
                cy.route('POST', `/api/users/${url.match(credentials.pattern)[0]}`, body)
            });
            cy.contains('Online').click();
        });

        cy.log('Reload page and check bio');
        cy.reload();
        cy.contains('qwerty').should('be.visible')
    });

    // Cypress.Commands.add('typeText', (text) => {
    //     cy.get('.UserBio-content').click();
    //     cy.get('textarea').clear();
    //     cy.get('textarea').clear().type(text);
    // })

});

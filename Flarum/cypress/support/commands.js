Cypress.Commands.add("login", (login, password) => {
    cy.contains('Log In').click();
    cy.get('[name=identification]')
        .type(login, {force: false})
        .should('have.value', login);
    cy.get('[name=password]')
        .type(password, {force: false})
        .should('have.value', password);
    cy.get('form').submit();
    cy.get('.Button-label > .username').should('have.text', login);
});

Cypress.Commands.add('typeText', (text) => {
    cy.get('.UserBio-content').click();
    cy.get('textarea').clear();
    cy.get('textarea').clear().type(text);
})
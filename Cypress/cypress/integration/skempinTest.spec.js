/// <reference types="cypress" />

context('Testing skempin project', () => {
  beforeEach(() => {
    cy.visit('https://skempin.github.io/reactjs-tmdb-app/')
  })

  it('Test with 3 movie', () => {
    cy.server()
   
    cy.log("Check main page by logo and url")
    cy.get('.logo').should('be.visible')
    cy.url().should('include', 'reactjs-tmdb-app/')

    cy.log("Input 'Arrival', check variants, select 1 film and check")
    cy.get('#q').type('Arrival')
    cy.route('GET', '3/search/*').as('getMovies')
    cy.wait('@getMovies').its('status').should('eq', 200)
    cy.contains('Arrival').should('include.text', 'Arrival')
    cy.contains('The Arrival').should('include.text', 'The Arrival')
    cy.contains('The Second Arrival').should('include.text', 'The Second Arrival')
    cy.get('.tt-suggestion').contains('Arrival').click()
    cy.contains('Why are they here?').should('be.visible')
    
    cy.log("Input 'The Arrival', select 4 film and check")
    cy.get('#q').clear().type('The Arrival')
    cy.wait('@getMovies').its('status').should('eq', 200)
    cy.get('.tt-suggestion').eq(3).click()
    cy.contains('The battle for Earth has begun').should('be.visible')

    cy.log("Input 'The Avengers', select 1 film, change response and check")
    cy.get('#q').clear().type('The Avengers')
    cy.wait('@getMovies').its('status').should('eq', 200)
    cy.request('https://api.themoviedb.org/3/movie/24428?&api_key=cfe422613b250f702980a3bbf9e90716').its('body').as('movieBody')
    cy.get('@movieBody').then(body => {
      let updatedBody = body
      updatedBody["vote average"] = 101.1
      cy.route('GET', 'https://api.themoviedb.org/3/movie/24428?&api_key=cfe422613b250f702980a3bbf9e90716', updatedBody)
    })
    cy.get('.tt-suggestion').first().click()
    cy.get('h1').contains('The Avengers').should('be.visible')
    cy.contains('Vote Average: ').find('span').should('include.text', '101.1 / 10')
  })
})

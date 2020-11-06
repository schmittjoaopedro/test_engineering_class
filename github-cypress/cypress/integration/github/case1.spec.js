/// <reference types="cypress" />

context('Case 1', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Search for choco-solver', () => {
        cy.get("[name=q]").type('choco-solver').should('have.value', 'choco-solver');
        cy.get("a > div[aria-label=choco-solver]").click();
        cy.get("a > em:contains('choco-solver')").click();
        cy.get('.BorderGrid-cell > p').should('contains.text', 'An open-source Java library for Constraint Programming');
    })

})
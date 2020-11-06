/// <reference types="cypress" />

context('Case 1', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Search for choco-solver', () => {
        cy.get("[name=q]").type('choco-solver').should('have.value', 'choco-solver');
        cy.get("a:contains('choco-solver')").click();
        cy.get("em:contains('choco-solver')").click();
        cy.get("p:contains('An open-source Java library for Constraint Programming')");
    })

})
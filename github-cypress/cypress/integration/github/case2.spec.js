/// <reference types="cypress" />

context('Case 2', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Check number of closed issues', () => {
        cy.get("[name=q]").type('choco-solver').should('have.value', 'choco-solver');
        cy.get("a:contains('choco-solver')").click();
        cy.get("em:contains('choco-solver')").click();
        cy.get("span:contains('Issues')").click();
        cy.get("a:visible:contains('Closed')").click();
        cy.get("span[aria-label='Closed issue']").should('have.length', 25);
    })

})
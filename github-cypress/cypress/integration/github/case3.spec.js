/// <reference types="cypress" />

context('Case 3', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Check commits of tag choco-4.0.1', () => {
        cy.get("[name=q]").type('choco-solver').should('have.value', 'choco-solver');
        cy.get("a:visible:contains('choco-solver')").click();
        cy.get("em:visible:contains('choco-solver')").click();
        cy.get("span:visible:contains('master')").click();
        cy.get("button:visible:contains('Tags')").click();
        cy.get("input[placeholder='Find a tag']").type('choco-4.0.1');
        cy.get("span:visible:contains('choco-4.0.1')").click();
        cy.get("strong:visible:contains('4,011')");
    })

    it('Check commits of tag choco-3.3.3', () => {
        cy.get("[name=q]").type('choco-solver').should('have.value', 'choco-solver');
        cy.get("a:visible:contains('choco-solver')").click();
        cy.get("em:visible:contains('choco-solver')").click();
        cy.get("span:visible:contains('master')").click();
        cy.get("button:visible:contains('Tags')").click();
        cy.get("input[placeholder='Find a tag']").type('choco-3.3.3');
        cy.get("span:visible:contains('choco-3.3.3')").click();
        cy.get("strong:visible:contains('3,253')");
    })

})
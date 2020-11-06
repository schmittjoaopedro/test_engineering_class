/// <reference types="cypress" />

context('Case 4', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Check number of commits greater than 0', () => {
        cy.get("[name=q]").type('choco-solver').should('have.value', 'choco-solver');
        cy.get("a:contains('choco-solver')").click();
        cy.get("em:contains('choco-solver')").click();
        cy.get("[class='d-none d-sm-inline'] > strong").should(($element) => {
            expect(parseInt($element.text())).to.be.at.least(1);
        });
    })

})
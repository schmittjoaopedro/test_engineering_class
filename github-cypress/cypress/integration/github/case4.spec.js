context('Case 4', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Check number of commits on choco-solver', () => {
        cy.get("[name=q]").type('choco-solver').should('have.value', 'choco-solver');
        cy.get("a:contains('choco-solver')").click();
        cy.get("em:contains('choco-solver')").click();
        cy.get("[class='d-none d-sm-inline'] > strong").should(($element) => {
            expect(parseInt($element.text())).to.be.at.least(0);
        });
    })

    it('Check number of commits on or-tools', () => {
        cy.get("[name=q]").type('or-tools').should('have.value', 'or-tools');
        cy.get("a:contains('or-tools')").click();
        cy.get("em:contains('or-tools')").click();
        cy.get("[class='d-none d-sm-inline'] > strong").should(($element) => {
            expect(parseInt($element.text())).to.be.at.least(0);
        });
    })

})
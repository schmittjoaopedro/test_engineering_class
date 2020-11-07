context('Case 4', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Check number of commits on choco-solver', () => {
        cy.get("input:visible[name=q]").type('choco-solver');
        cy.get("a:contains('choco-solver')").click();
        cy.get("em:contains('choco-solver')").click();
        cy.get("span:visible[class='d-none d-sm-inline'] > strong").should(($element) => {
            expect(parseInt($element.text())).to.be.at.least(0);
        });
    })

    it('Check number of commits on or-tools', () => {
        cy.get("input:visible[name=q]").type('or-tools');
        cy.get("a:contains('or-tools')").click();
        cy.get("em:contains('or-tools')").click();
        cy.get("span:visible[class='d-none d-sm-inline'] > strong").should(($element) => {
            expect(parseInt($element.text())).to.be.at.least(0);
        });
    })

})
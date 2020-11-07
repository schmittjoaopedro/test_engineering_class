context('Case 1', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Search for choco-solver', () => {
        cy.get("input:visible[name=q]").type('choco-solver');
        cy.get("a:visible:contains('choco-solver')").click();
        cy.get("em:visible:contains('choco-solver')").click();
        cy.get("p:visible:contains('An open-source Java library for Constraint Programming')");
    })

    it('Search for or-tools', () => {
        cy.get("input:visible[name=q]").type('or-tools');
        cy.get("a:visible:contains('or-tools')").click();
        cy.get("em:visible:contains('or-tools')").click();
        cy.get("p:visible:contains('Google\\'s Operations Research tools')");
    })

})
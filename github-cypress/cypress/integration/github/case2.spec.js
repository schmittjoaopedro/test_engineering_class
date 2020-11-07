context('Case 2', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Check pagination of closed issues on choco-solver', () => {
        cy.get("[name=q]").type('choco-solver').should('have.value', 'choco-solver');
        cy.get("a:visible:contains('choco-solver')").click();
        cy.get("em:visible:contains('choco-solver')").click();
        cy.get("span:visible:contains('Issues')").click();
        cy.get("a:visible:contains('Closed')").click();
        cy.get("span:visible[aria-label='Closed issue']").should('have.length', 25);
    })

    it('Check pagination of closed issues on or-tools', () => {
        cy.get("[name=q]").type('or-tools').should('have.value', 'or-tools');
        cy.get("a:visible:contains('or-tools')").click();
        cy.get("em:visible:contains('or-tools')").click();
        cy.get("span:visible:contains('Issues')").click();
        cy.get("a:visible:visible:contains('Closed')").click();
        cy.get("span:visible[aria-label='Closed issue']").should('have.length', 25);
    })

})
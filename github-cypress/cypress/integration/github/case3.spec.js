context('Case 3', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Check tag commits on choco-solver', () => {
        cy.get("[name=q]").type('choco-solver').should('have.value', 'choco-solver');
        cy.get("a:visible:contains('choco-solver')").click();
        cy.get("em:visible:contains('choco-solver')").click();
        cy.get("span:visible:contains('master')").click();
        cy.get("button:visible:contains('Tags')").click();
        cy.get("input[placeholder='Find a tag']").type('choco-4.0.1');
        cy.get("span:visible:contains('choco-4.0.1')").click();
        cy.get("strong:visible:contains('4,011')");
    })

    it('Check tag commits on or-tools', () => {
        cy.get("[name=q]").type('or-tools').should('have.value', 'or-tools');
        cy.get("a:visible:contains('or-tools')").click();
        cy.get("em:visible:contains('or-tools')").click();
        cy.get("span:visible:contains('stable')").click();
        cy.get("button:visible:contains('Tags')").click();
        cy.get("input[placeholder='Find a tag']").type('v7.7');
        cy.get("span:visible:contains('v7.7')").click();
        cy.get("strong:visible:contains('7,810')");
    })

})
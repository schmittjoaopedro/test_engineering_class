context('Case 5', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Search for specific issue on choco-solver', () => {
        cy.get("[name=q]").type('choco-solver').should('have.value', 'choco-solver');
        cy.get("a:visible:contains('choco-solver')").click();
        cy.get("em:visible:contains('choco-solver')").click();
        cy.get("span:visible:contains('Issues')").click();
        cy.get("input:visible[value='is:issue is:open ']").clear()
            .type("is:issue Ibex-lib changing standard double definition")
            .type('{enter}');
        cy.get("a:visible:contains('Ibex-lib changing standard double definition')").click();
        cy.get("strong:contains('4.10.6')");
    })

    it('Check number of commits on or-tools', () => {
        cy.get("[name=q]").type('or-tools').should('have.value', 'or-tools');
        cy.get("a:contains('or-tools')").click();
        cy.get("em:contains('or-tools')").click();
        cy.get("span:visible:contains('Issues')").click();
        cy.get("input:visible[value='is:issue is:open ']").clear()
            .type("is:issue Error on run TSP sample from docs with version 7.5")
            .type('{enter}');
        cy.get("a:visible:contains('Error on run TSP sample from docs with version 7.5')").click();
        cy.get("strong:contains('v7.6')");
        
    })

})
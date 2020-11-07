context('Case 3', () => {
    beforeEach(() => {
        cy.visit('https://github.com/')
        cy.viewport(1240, 960)
    })

    it('Check tag commits on choco-solver', () => {
        cy.get("input:visible[name='q']").type('choco-solver').type("{enter}");
        cy.get("em:visible:contains('choco-solver')").click();
        cy.get("span:visible:contains('master')").click();
        cy.get("button:visible:contains('Tags')").click();
        cy.get("input:visible[placeholder='Find a tag']").type('choco-4.0.1');
        cy.get("span:visible:contains('choco-4.0.1')").click();
        cy.get("strong:visible:contains('4,011')");
    })

    it('Check tag commits on or-tools', () => {
        cy.get("input:visible[name='q']").type('or-tools').type("{enter}");
        cy.get("em:visible:contains('or-tools')").click();
        cy.get("span:visible:contains('stable')").click();
        cy.get("button:visible:contains('Tags')").click();
        cy.get("input:visible[placeholder='Find a tag']").type('v7.7');
        cy.get("span:visible:contains('v7.7')").click();
        cy.get("strong:visible:contains('7,810')");
    })

})
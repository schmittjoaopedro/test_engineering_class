context('Case 3', () => {
    beforeEach(() => {
        cy.visit('https://www.americanas.com.br/')
        cy.viewport(1240, 960)
    })

    it('Navegar no resultado dos produtos através do mecanismo de paginação. Verificar que ao trocar de página os produtos também são alterados.', () => {
        cy.get("input[id='h_search-input']").type('smartphone');
        cy.get("button[id='h_search-btn']").click();
        // verifica que existem 25 elementos com o atributo 'to' contendo o texto "pfm_carac=smartphone" 
        cy.get("a[to*='pfm_carac=smartphone']").should('have.length', 24);
        // obtém o nome do primeiro produto da lista
        let firstName;
        cy.get("a[to*='pfm_carac=smartphone'] > span[class*='src__Name']:first")
            .then($firstName => firstName = $firstName.text());
        // navega para segunda página
        cy.get("button[class*='src__PageButton']:contains('2')").click();
        // wait the loading symbol appear then disappear
        cy.get("div[class*='lds-ring']");
        cy.get("div[class*='lds-ring']").should("not.exist");
        // verifica se o nome do produto alterou
        cy.get("a[to*='pfm_carac=smartphone'] > span[class*='src__Name']:first")
            .then($secondName => expect($secondName.text()).to.not.equal(firstName));
    })

})
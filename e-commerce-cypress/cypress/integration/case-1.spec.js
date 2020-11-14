context('Case 1', () => {
    beforeEach(() => {
        cy.visit('https://www.americanas.com.br/')
        cy.viewport(1240, 960)
    })

    it('Encontrar  produtos a partir de um expressão de pesquisa (ex: "smartphone"). Verificar que o resultado apresenta resultados contendo o texto da busca.', () => {
        cy.get("input[id='h_search-input']").type('smartphone');
        cy.get("button[id='h_search-btn']").click();
        // verifica que existem 25 elementos com o atributo 'to' contendo o texto "pfm_carac=smartphone" 
        cy.get("a[to*='pfm_carac=smartphone']").should('have.length', 24);
    })

})
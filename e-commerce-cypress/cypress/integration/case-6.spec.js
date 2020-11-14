context('Case 6', () => {
    beforeEach(() => {
        cy.visit('https://www.americanas.com.br/')
        cy.viewport(1240, 960)
    })

    it('Ao selecionar um produto específico, executar o calculo do frete para entrega. Verificar que ao inserir um CEP é retornado o custo', () => {
        cy.get("input[id='h_search-input']").type('smartphone');
        cy.get("button[id='h_search-btn']").click();
        // verifica que existem 25 elementos com o atributo 'to' contendo o texto "pfm_carac=smartphone" 
        cy.get("a[to*='pfm_carac=smartphone'] > div:first").click();
        // obter campo do frete
        cy.get("input[placeholder='digite o CEP']").type("89256620").type("{enter}");
        // verifica se o resultado aparece
        cy.get("span[class*='freight-option-price']").should('have.length.greaterThan', 0);
    })

})
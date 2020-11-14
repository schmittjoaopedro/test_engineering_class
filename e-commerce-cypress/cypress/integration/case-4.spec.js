context('Case 4', () => {
    beforeEach(() => {
        cy.visit('https://www.americanas.com.br/')
        cy.viewport(1240, 960)
    })

    it('Especializar o resultado de um filtro, usando categorias como: marca, tipo, função, estado, etc… Verificar que o número de resultados encontrados reduz.', () => {
        cy.get("input[id='h_search-input']").type('smartphone');
        cy.get("button[id='h_search-btn']").click();
        // verifica que existem 25 elementos com o atributo 'to' contendo o texto "pfm_carac=smartphone" 
        cy.get("a[to*='pfm_carac=smartphone']").should('have.length', 24);
        // obtém o nome do primeiro produto da lista
        let totalBeforeFilter;
        cy.get("span[class*='TotalText']")
            .then($total => totalBeforeFilter = $total.text());
        // navega para segunda página
        cy.get("div[id='product_feature_marca'] > div:contains('samsung')").click();
        // verifica se o nome do produto alterou
        cy.get("span[class*='TotalText']")
            .then($total => expect($total.text()).to.not.equal(totalBeforeFilter));
    })

})
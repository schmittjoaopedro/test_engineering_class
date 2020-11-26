context('Case 2', () => {
    beforeEach(() => {
        cy.visit('https://www.americanas.com.br/')
        cy.viewport(1240, 960)
    })

    it('Encontrar produtos e listar pelo preço, do mais barato para o mais caro. Verificar que o preço do último produto do resultado é maior do que do primeiro.', () => {
        cy.get("input[id='h_search-input']").type('smartphone');
        cy.get("button[id='h_search-btn']").click();
        // seleciona a opção "Menores Preços" do campo de ordenar por
        cy.get("select[id='sort-by']").select("Menores Preços");
        // wait the loading symbol appear then disappear
        cy.get("div[class*='lds-ring']");
        cy.get("div[class*='lds-ring']").should("not.exist");
        // verifica que existem 25 elementos com o atributo 'to' contendo o texto "pfm_carac=smartphone" 
        cy.get("a[to*='pfm_carac=smartphone']").should('have.length', 24);
        // obtem a lista de preço para cada produto (elementos com o atributo 'to' contendo o texto "pfm_carac=smartphone")
        // e então pega o primeiro preço e o último preço da lista, remove caracteres para converter o texto para numero
        // e verifica que o preço 1 é menor que o preço 2
        cy.get("a[to*='pfm_carac=smartphone'] > span[class*='PromotionalPrice']").should(el => {
            var price1 = parseInt(el[0].textContent.replace('R$', '').replace(',', '').replace('.', ''));
            var price2 = parseInt(el[23].textContent.replace('R$', '').replace(',', '').replace('.', ''));
            expect(price1).to.be.lessThan(price2);
        });
    })

})
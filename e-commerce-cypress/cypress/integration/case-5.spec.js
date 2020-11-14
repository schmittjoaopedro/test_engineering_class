context('Case 5', () => {
    beforeEach(() => {
        cy.visit('https://www.americanas.com.br/')
        cy.viewport(1240, 960)
    })

    it('Ao selecionar um produto específico, verificar que existem diferentes formas de pagamento disponíveis.', () => {
        cy.get("input[id='h_search-input']").type('smartphone');
        cy.get("button[id='h_search-btn']").click();
        // espera 1.5 segundos para que a página começar a ser atualizada conforme a ordem definida
        cy.wait(1500);
        // verifica que existem 25 elementos com o atributo 'to' contendo o texto "pfm_carac=smartphone" 
        cy.get("a[to*='pfm_carac=smartphone'] > div:first").click();
        // clicar em "mais formas de pagamaneto"
        cy.get("a[to='#modal-payment-methods']").click();
        // Verificar se existe "cartão de crédito"
        cy.get("div[class*='src__Content'] span:contains('cartão de crédito')");
        // Verificar se existe "americanas"
        cy.get("div[class*='src__Content'] span:contains('americanas')");
        // Verificar se existe "boleto bancário"
        cy.get("div[class*='src__Content'] span:contains('boleto bancário')");
        // Verificar se existe "ame"
        cy.get("div[class*='src__Content'] span:contains('ame')");
    })

})
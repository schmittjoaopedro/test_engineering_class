context('Case 7', () => {
    beforeEach(() => {
        cy.visit('https://www.americanas.com.br/')
        cy.viewport(1240, 960)
    })

    it('Ao selecionar um produto específico, visualizar a imagem do produto. Verificar que é possível navegar diferentes imagens disponíveis', () => {
        cy.get("input[id='h_search-input']").type('notebook');
        cy.get("button[id='h_search-btn']").click();
        // verifica que existem 25 elementos com o atributo 'to' contendo o texto "pfm_carac=smartphone" 
        cy.get("a[to*='pfm_carac=notebook'] > div:first").click();
        // clica na primeira imagem
        cy.get("div[class*='src__ProductInfo'] div[class*='__Snap'] picture[class*='src__Picture']:first").click();
        // clica na próxima imagem
        cy.get("button[class*='arrow--right']").click();
    })

})
context('Case 8', () => {
    beforeEach(() => {
        cy.visit('https://www.americanas.com.br/')
        cy.viewport(1240, 960)
    })

    it('Ao selecionar um produto específico, visualizar a imagem do produto. Verificar que é possível navegar diferentes imagens disponíveis', () => {
        cy.get("input[id='h_search-input']").type('notebook');
        cy.get("button[id='h_search-btn']").click();
        // espera 1.5 segundos para que a página começar a ser atualizada conforme a ordem definida
        cy.wait(1500);
        // verifica que existem 25 elementos com o atributo 'to' contendo o texto "pfm_carac=smartphone" 
        cy.get("a[to*='pfm_carac=notebook'] > div:first").click();
        // rola página até seção de comentários
        cy.get("div[class*='src__WrapperReview']").scrollIntoView();
        // verifica se existe mais de uma tag de comentário
        cy.get("h4[class*='review__Title']").should('have.length.greaterThan', 0)
    })

})
package com.santander.juniores2.produto.dto;

import com.santander.juniores2.produto.model.Ebook;
import com.santander.juniores2.produto.model.LivroFisico;
import com.santander.juniores2.produto.model.Produto;
import com.santander.juniores2.produto.model.TipoProduto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(

        Long id,
        String titulo,
        String autor,
        String editora,
        BigDecimal precoFinal,
        Integer estoque,
        TipoProduto tipo,

        BigDecimal peso,
        Long tamanhoArquivoMb)
{
    public static ProdutoResponseDTO fromEntity(Produto produto) {

        BigDecimal peso = null;
        Long tamanhoArquivoMb = null;

        if (produto instanceof LivroFisico fisico) {
            peso = fisico.getPeso();
        }

        if (produto instanceof Ebook ebook) {
            tamanhoArquivoMb = ebook.getTamanhoArquivoMb();
        }

        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getTitulo(),
                produto.getAutor(),
                produto.getEditora(),
                produto.calcularPrecoFinal(),
                produto.getEstoque(),
                produto.getTipo(),
                peso,
                tamanhoArquivoMb);
    }
}


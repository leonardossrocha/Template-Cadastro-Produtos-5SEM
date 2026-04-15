package com.seu.pacote; // Mude para o pacote do seu projeto

public class ProductValidator {

    /**
     * Verifica se o preço é válido:
     * - Não pode ser nulo ou vazio
     * - Tem que ser um número válido (Double)
     * - Tem que ser maior que zero
     * - (Opcional, mas testado) Máximo de 2 casas decimais
     */
    public boolean isPriceValid(String price) {
        if (price == null || price.trim().isEmpty()) {
            return false;
        }

        try {
            double parsedPrice = Double.parseDouble(price);

            // Rejeita zero ou números negativos
            if (parsedPrice <= 0) {
                return false;
            }

            // Valida se não tem mais de 2 casas decimais
            String[] parts = price.split("\\.");
            if (parts.length == 2 && parts[1].length() > 2) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            // Se o aluno digitar "abc" em vez de número, cai aqui e retorna falso
            return false;
        }
    }

    /**
     * Verifica se a quantidade é válida:
     * - Não pode ser nula ou vazia
     * - Tem que ser um número inteiro
     * - Tem que ser maior que zero
     */
    public boolean isQuantityValid(String quantity) {
        if (quantity == null || quantity.trim().isEmpty()) {
            return false;
        }

        try {
            int parsedQuantity = Integer.parseInt(quantity);

            // Rejeita zero ou números negativos
            return parsedQuantity > 0;

        } catch (NumberFormatException e) {
            // Se digitar "10.5" ou texto, o Integer.parseInt falha e cai aqui
            return false;
        }
    }

    /**
     * Verifica se todos os campos obrigatórios estão preenchidos.
     * Retorna false se qualquer um for nulo ou apenas espaços em branco.
     */
    public boolean areFieldsPopulated(String name, String code, String price, String quantity) {
        return name != null && !name.trim().isEmpty() &&
                code != null && !code.trim().isEmpty() &&
                price != null && !price.trim().isEmpty() &&
                quantity != null && !quantity.trim().isEmpty();
    }
}
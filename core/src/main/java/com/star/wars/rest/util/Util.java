package com.star.wars.rest.util;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.StringUtils;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author FALKOR-LTDA "Hugo Fernandes"
 *
 */
public final class Util {

    private static final String CPF_ZERO = "00000000000";

    private static final String CNPJ_ZERO = "00000000000000";

    /**
     * Construtor privado para garantir o singleton.
     */
    private Util() {

    }

    /**
     * Verifica se o valor informado está vazio.
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(final String value) {
        return StringUtils.isEmpty(value);
    }


    /**
     * Remove os caracteres não numéricos do 'valor' informado.
     *
     * @param valor
     * @return
     */
    public static String removerCaracteresNaoNumericos(String valor) {

        if (!Util.isEmpty(valor)) {
            valor = valor.replaceAll("[^\\d]", "");
        }
        return valor;
    }

    /**
     * Retorna a string com os dados do array de objetos concatenados conforme o
     * separador informado.
     *
     * @param separador
     * @param parametros
     * @return
     */
    public static String getValorConcatenador(final String separador, Object... parametros) {
        return Util.getValorConcatenador(separador, Arrays.asList(parametros));
    }

    /**
     * Retorna a string com os dados da {@link List} concatenados conforme o
     * separador informado.
     *
     * @param separador
     * @param parametros
     * @return
     */
    public static String getValorConcatenador(final String separador, final List<Object> parametros) {
        StringBuilder build = new StringBuilder();
        Iterator<?> iterator = parametros.iterator();

        while (iterator.hasNext()) {
            Object valor = iterator.next().toString();
            build.append(valor);

            if (iterator.hasNext()) {
                build.append(separador);
            }
        }
        return build.toString();
    }

}

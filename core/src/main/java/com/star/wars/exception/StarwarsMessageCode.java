package com.star.wars.exception;

import com.star.wars.rest.util.MessageCode;

/**
 * @author FALKOR-LTDA "Hugo Fernandes"
 *
 */
public enum StarwarsMessageCode implements MessageCode {
    ERRO_INESPERADO("ME001", 500),
    ERRO_NAO_POSSUI_REGISTROS("ME002", 404);

    private final String code;

    private final Integer status;

    /**
     * Construtor da classe.
     *
     * @param code
     * @param status
     */
    StarwarsMessageCode(final String code, final Integer status) {
        this.code = code;
        this.status = status;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return code;
    }
}
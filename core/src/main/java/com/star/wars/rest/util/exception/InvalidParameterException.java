package com.star.wars.rest.util.exception;

/**
 * @author FALKOR-LTDA "Hugo Fernandes"
 *
 */
public class InvalidParameterException extends RuntimeException {

    private static final long serialVersionUID = 6477399315270679560L;

    private final String field;

    private final String defaultMessage;

    /**
     * Construtor da classe.
     *
     * @param field
     * @param defaultMessage
     */
    public InvalidParameterException(final String field, final String defaultMessage) {
        this.field = field;
        this.defaultMessage = defaultMessage;
    }

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @return the defaultMessage
     */
    public String getDefaultMessage() {
        return defaultMessage;
    }

    /**
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return defaultMessage;
    }
}
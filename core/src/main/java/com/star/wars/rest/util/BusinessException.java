package com.star.wars.rest.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FALKOR-LTDA "Hugo Fernandes"
 *
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 7986864620634914985L;

    private boolean concat;
    private MessageCode code;
    private Object[] parameters;
    private MessageResponse response;

    /**
     * Construtor da classe.
     *
     * @param code
     * @param concat
     * @param parameters
     */
    public BusinessException(final MessageCode code, Boolean concat, final Object... parameters) {
        this.code = code;
        this.concat = concat;
        this.parameters = parameters;
    }

    /**
     * Construtor da classe.
     *
     * @param chave
     * @param parameters
     */
    public BusinessException(final MessageCode code, final Object... parameters) {
        this(code, Boolean.TRUE, parameters);
    }

    /**
     * Construtor da classe.
     *
     * @param code
     */
    public BusinessException(final MessageCode code) {
        this.code = code;
    }

    /**
     * Construtor da classe.
     *
     * @param e
     */
    public BusinessException(final Throwable e) {
        super(e);
    }

    /**
     * Construtor a classe.
     *
     * @param response
     */
    public BusinessException(MessageResponse response) {
        this.response = response;
    }

    /**
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        String message = super.getMessage();

        if (Util.isEmpty(super.getMessage())) {
            List<String> params = new ArrayList<String>();

            if (code != null) {
                params.add("code: " + code);
            }

            params.add("concat: " + concat);

            if (hasParameters()) {
                String paramsConcat = Util.getValorConcatenador(", ", parameters);
                params.add("parameters: [" + paramsConcat + "]");
            }

            message = "{";
            message += Util.getValorConcatenador(", ", params.toArray());
            message += "}";
        }

        return message;
    }

    /**
     * @return the response
     */
    public MessageResponse getResponse() {
        return response;
    }

    /**
     * @return the concat
     */
    public boolean isConcat() {
        return concat;
    }

    /**
     * @return the code
     */
    public MessageCode getCode() {
        return code;
    }

    /**
     * @return the parameters
     */
    public Object[] getParameters() {
        return parameters;
    }

    /**
     * @return the hasParameters
     */
    public boolean hasParameters() {
        return parameters != null && parameters.length > 0;
    }
}
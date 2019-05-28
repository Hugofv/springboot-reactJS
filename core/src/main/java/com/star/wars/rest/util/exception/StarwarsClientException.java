package com.star.wars.rest.util.exception;

import com.star.wars.rest.util.MessageResponse;

public class StarwarsClientException extends Exception {

    private static final long serialVersionUID = 8156670871951323575L;

    /**
     * Mensagem de resposta.
     */
    private MessageResponse response;

    /**
     * Construtor da classe.
     *
     * @param message Mensagem da exceção.
     * @param exception Exceção que será encapsulada.
     */
    public StarwarsClientException(final String message, final Throwable exception) {
        super(message, exception);
    }

    /**
     * Construtor da classe.
     *
     * @param response
     */
    public StarwarsClientException(MessageResponse response) {
        this.response = response;
    }

    /**
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (response != null) {
            message = response.getMessage();
        }
        return message;
    }

    /**
     * @return Mensagem de resposta.
     */
    public MessageResponse getResponse() {
        return response;
    }
}
package com.star.wars.rest.util.exception;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.wars.rest.util.BusinessException;
import com.star.wars.rest.util.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FALKOR-LTDA "Hugo Fernandes"
 *
 */
public class StarwarsRestTemplateExceptionHandler implements ResponseErrorHandler {

    /*
     * @see org.springframework.web.client.ResponseErrorHandler#hasError(org.springframework.http.client.ClientHttpResponse)
     */
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return !HttpStatus.OK.equals(response.getStatusCode());
    }

    /*
     * @see org.springframework.web.client.ResponseErrorHandler#handleError(org.springframework.http.client.ClientHttpResponse)
     */
    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        try(InputStream input = clientHttpResponse.getBody()) {
            final ObjectMapper mapper = createObjectMapper();
            MessageResponse response = mapper.readValue(input, new TypeReference<MessageResponse>() {});
            throw new BusinessException(response);
        }
    }

    /**
     * Retorna a instância de {@link ObjectMapper}.
     *
     * @return
     */
    private static ObjectMapper createObjectMapper() {
        return new ObjectMapper().findAndRegisterModules().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}
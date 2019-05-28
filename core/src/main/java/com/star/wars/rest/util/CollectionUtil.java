package com.star.wars.rest.util;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author FALKOR-LTDA "Hugo Fernandes"
 *
 */
public final class CollectionUtil {

    /**
     * Construtor privado para garantir o Singleton.
     */
    private CollectionUtil() {

    }

    /**
     * Verifica se a {@link Collection} informada é nula, ou vazia.
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }

    /**
     * Implementação generica para remover objetos duplicados a partir de um
     * atribudo da entidade informada.
     *
     * @param extractor
     * @return
     */
    public static <T> Predicate<T> distinctPorAtributo(Function<? super T, Object> extractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return object -> map.putIfAbsent(extractor.apply(object), Boolean.TRUE) == null;
    }
}
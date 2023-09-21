package br.com.mrocha.vendas.online.exception;

import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.stream.IntStream;
import java.util.HashMap;

public class NotFoundException extends RuntimeException{

    private static final long serialVersionUID = -5576150444545521612L;

    public NotFoundException(Class classe, String... paramsMap) {
        super(NotFoundException.createMessage(classe.getSimpleName(), map(String.class, String.class, paramsMap)));
    }

    private static String createMessage(String entity, Map<String, String> searchParams) {
        return StringUtils.capitalize(entity) +
                " was not found for parameters " +
                searchParams;
    }

    private static <K, V> Map<K, V> map(
            Class<K> keyType, Class<V> valueType, Object... entries) {
        if (entries.length % 2 == 1)
            throw new IllegalArgumentException("Invalid entries");
        return IntStream.range(0, entries.length / 2).map(i -> i * 2)
                .collect(HashMap::new,
                        (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
                        Map::putAll);
    }
}

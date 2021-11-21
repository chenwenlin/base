package com.chen.basecommon.optionals;

import org.apache.logging.log4j.util.Strings;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 扩展自optional 判断字符串 集合 map
 *
 * @Author chenwenlin
 * @Date 2021/11/17 14:32
 */
public final class OptionalEx<T> {

    /**
     * If non-null, the value; if null, indicates no value is present
     */
    private final T value;
    /**
     * Common instance for empty().
     */
    private static final OptionalEx<?> EMPTY = new OptionalEx<>();

    private OptionalEx() {
        this.value = null;
    }

    private OptionalEx(T value) {
        this.value = isNonEmpty(value) ? value : orElseThrow(NullPointerException::new);
    }

    public static <T> OptionalEx<T> of(T value) {
        return new OptionalEx<>(value);
    }

    public static <T> OptionalEx<T> ofEmptyAble(T value) {
        return isNonEmpty(value) ? of(value) : empty();
    }

    /**
     * 判断value1 value2 两个值是否为空 value1为空取
     *
     * @param value1 请求参数
     * @param value2 请求参数
     * @return {@link OptionalEx<T>}
     */
    public static <T> OptionalEx<T> ofEmptyAbleTwo(T value1, T value2) {
        return isNonEmpty(value1) ? of(value1) : ofEmptyAble(value2);
    }

    public T orElse(T other) {
        return isNonEmpty(value) ? value : other;
    }

    public T orElseGet(Supplier<? extends T> other) {
        return isNonEmpty(value) ? value : other.get();
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (isNonEmpty(value)) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }

    public static <T> OptionalEx<T> empty() {
        @SuppressWarnings("unchecked")
        OptionalEx<T> t = (OptionalEx<T>) EMPTY;
        return t;
    }

    /**
     * 判断value是否为空 value类型 String Collection Map
     *
     * @param value 请求参数
     * @return {@link Boolean} 不为空
     */
    private static <T> boolean isNonEmpty(T value) {
        if (value instanceof String) {
            return Strings.isNotBlank((String) value);
        } else if (value instanceof Collection) {
            return !CollectionUtils.isEmpty((Collection<?>) value);
        } else if (value instanceof Map) {
            return !CollectionUtils.isEmpty((Map<?, ?>) value);
        } else {
            return value != null;
        }
    }
}
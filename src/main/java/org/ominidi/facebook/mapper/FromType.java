package org.ominidi.facebook.mapper;

public interface FromType<T, X> {
    X fromType(T toMap);
}

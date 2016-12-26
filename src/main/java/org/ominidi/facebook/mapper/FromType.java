package org.ominidi.facebook.mapper;

public interface FromType<T, E> {
    E fromType(T toMap);
}

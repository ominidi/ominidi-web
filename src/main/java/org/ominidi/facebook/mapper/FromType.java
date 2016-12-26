package org.ominidi.facebook.mapper;

/**
 * Created by Gabriele on 26/12/2016.
 */
public interface FromType<T, X> {
    public X fromType(T toMap);
}

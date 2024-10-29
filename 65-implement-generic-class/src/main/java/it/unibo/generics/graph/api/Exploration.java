package it.unibo.generics.graph.api;

import java.util.Map;
import java.util.List;

public interface Exploration<T> {
    List<T> explore(Map<T, List<T>> map, T source, T target);
}

package it.unibo.generics.graph.api;

import java.util.Map;
import java.util.List;

public interface Exploration<T> {
    void explore(Map<T, List<T>> map, T startNode);
}

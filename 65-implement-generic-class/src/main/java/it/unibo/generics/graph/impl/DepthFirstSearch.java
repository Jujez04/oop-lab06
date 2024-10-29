package it.unibo.generics.graph.impl;

import java.util.List;
import java.util.Map;

import it.unibo.generics.graph.api.Exploration;

public class DepthFirstSearch<T> implements Exploration<T> {

    @Override
    public List<T> explore(Map<T, List<T>> map, T source, T target) {
        return null;
    }
    
}

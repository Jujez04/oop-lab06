package it.unibo.generics.graph.impl;

import java.util.*;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N,List<N>> map = new HashMap<>();

    @Override
    public void addNode(N node) {
        this.map.put(node, new ArrayList<>());
    }

    @Override
    public void addEdge(N source, N target) {
        this.map.get(source).add(target);
    }

    @Override
    public Set<N> nodeSet() {
       return this.map.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'linkedNodes'");
    }

    @Override
    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }
    
}

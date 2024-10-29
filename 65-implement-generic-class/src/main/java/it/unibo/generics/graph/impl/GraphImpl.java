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
        if (source != null && target != null){
            this.map.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
       return this.map.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return new HashSet<>(this.map.get(node));
    }

    @Override
    public List<N> getPath(N source, N target) {   //BFS Strategy
        if (!this.nodeSet().contains(source) || !this.nodeSet().contains(target)) {
            return new ArrayList<>();
        }
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return new BreadthFirstSearch<N>().explore(this.map, source, target);
        }
        return new DepthFirstSearch<N>().explore(this.map, source, target);
    } 
    
}

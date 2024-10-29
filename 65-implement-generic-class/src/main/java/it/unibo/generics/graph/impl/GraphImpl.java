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
        Queue<N> queue = new LinkedList<>();
        HashMap<N,N> predecessors = new HashMap<>();
        HashMap<N, Boolean> visited = new HashMap<>(this.map.size());
        queue.add(source);
        predecessors.put(source, null);
        for (N n : this.nodeSet()) {
            visited.put(n, false);
            predecessors.put(n, null);
        }
        visited.put(source, true);

        while (!queue.isEmpty()) {
            N removed = queue.remove();
            for (N n : this.linkedNodes(removed)) {
                if (!visited.get(n)) {
                    visited.put(n,true);
                    predecessors.put(n, removed);
                    queue.add(n);
                }
            }
        }
        List<N> path = new ArrayList<>(); 
        for (N i = target; i != null; i = predecessors.get(i)) {        //Trova il percorso a ritroso
            path.add(i);
        }
        return path.reversed();
    } 
    
}

package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unibo.generics.graph.api.Exploration;

public class DepthFirstSearch<T> implements Exploration<T> {

    private boolean dfsVisit(Map<T, List<T>> map, T node, T target, HashMap<T,T> predecessors, HashMap<T, Boolean> visited) {
        visited.put(node, true);
        if (node.equals(target)) {
            return true;
        }
        for (T neighbor : map.get(node)) {
            if (!visited.get(neighbor)) {
                predecessors.put(neighbor, node);
                if (dfsVisit(map, neighbor, target, predecessors, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<T> explore(Map<T, List<T>> map, T source, T target) {
        HashMap<T,T> predecessors = new HashMap<>();
        HashMap<T, Boolean> visited = new HashMap<>();
        predecessors.put(source, null);
        for (T n : map.keySet()) {
            visited.put(n, false);
            predecessors.put(n, null);
        }
        dfsVisit(map, source, target, predecessors, visited);
        List<T> path = new ArrayList<>(); 
        for (T i = target; i != null; i = predecessors.get(i)) {        //Trova il percorso a ritroso
            path.add(i);
        }
        return path.reversed();
    }
    
}

package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import it.unibo.generics.graph.api.Exploration;

public class BreadthFirstSearch<T> implements Exploration<T> {

    private void bfsVisit(Map<T, List<T>> map, T source, T target, HashMap<T,T> predecessors, HashMap<T, Boolean> visited) {
        Queue<T> queue = new LinkedList<>();
        queue.add(source);
        for (T n : map.keySet()) {
            visited.put(n, false);
            predecessors.put(n, null);
        }
        visited.put(source, true);
        while (!queue.isEmpty()) {
            T removed = queue.remove();
            for (T n: new HashSet<>(map.get(removed))) {
                if (!visited.get(n)) {
                    visited.put(n,true);
                    predecessors.put(n, removed);
                    queue.add(n);
                }
            }
        }
    }

    @Override
    public List<T> explore(Map<T, List<T>> map, T source, T target) {
        HashMap<T,T> predecessors = new HashMap<>();
        HashMap<T, Boolean> visited = new HashMap<>();
        predecessors.put(source, null);
        bfsVisit(map, source, target, predecessors, visited);
        List<T> path = new ArrayList<>(); 
        for (T i = target; i != null; i = predecessors.get(i)) {        //Trova il percorso a ritroso
            path.add(i);
        }
        return path.reversed();
    }
}


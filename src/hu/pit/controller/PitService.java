package hu.pit.controller;

import java.util.List;

public class PitService {

    private final List<Integer> depths;

    public PitService(List<Integer> depths) {
        this.depths = depths;
    }

    /**
     * 1. feldadat
     */
    public int getDepthCount() {
        return depths.size();
    }

    /**
     * 2. feladat
     */
    public int getDepthAtCertainDistance(int distance) {
        return depths.get(distance);
    }
}

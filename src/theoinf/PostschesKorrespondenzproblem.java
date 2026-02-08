package theoinf;

import java.util.*;

public class PostschesKorrespondenzproblem {
    
    static class DominoTile {
        String top;
        String bottom;
        
        public DominoTile(String top, String bottom) {
            this.top = top;
            this.bottom = bottom;
        }
        
        @Override
        public String toString() {
            return "(" + top + ", " + bottom + ")";
        }
    }
    
    static class State {
        String topChain;
        String bottomChain;
        List<Integer> sequence;
        
        public State(String topChain, String bottomChain, List<Integer> sequence) {
            this.topChain = topChain;
            this.bottomChain = bottomChain;
            this.sequence = new ArrayList<>(sequence);
        }
    }
    
    public static List<Integer> solve(DominoTile[] tiles, int maxDepth) {
        Queue<State> queue = new LinkedList<>();
        
        for (int i = 0; i < tiles.length; i++) {
            List<Integer> initialSequence = new ArrayList<>();
            initialSequence.add(i);
            queue.add(new State(tiles[i].top, tiles[i].bottom, initialSequence));
        }
        
        int examinedSequences = 0;
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            examinedSequences++;
            
            if (current.topChain.equals(current.bottomChain)) {
                System.out.println("Solution found after " + examinedSequences + " attempts!");
                return current.sequence;
            }
            
            if (current.sequence.size() >= maxDepth) {
                continue;
            }
            
            for (int i = 0; i < tiles.length; i++) {
                String newTopChain = current.topChain + tiles[i].top;
                String newBottomChain = current.bottomChain + tiles[i].bottom;
                
                if (Math.abs(newTopChain.length() - newBottomChain.length()) > 100) {
                    continue;
                }
                
                if (newTopChain.length() < newBottomChain.length()) {
                    if (!newBottomChain.startsWith(newTopChain)) {
                        continue;
                    }
                } else if (newBottomChain.length() < newTopChain.length()) {
                    if (!newTopChain.startsWith(newBottomChain)) {
                        continue;
                    }
                }
                
                List<Integer> newSequence = new ArrayList<>(current.sequence);
                newSequence.add(i);
                queue.add(new State(newTopChain, newBottomChain, newSequence));
            }
        }
        
        System.out.println("No solution found up to depth " + maxDepth + ".");
        System.out.println("Total " + examinedSequences + " sequences examined.");
        return null;
    }
    
    public static void printSolution(DominoTile[] tiles, List<Integer> solution) {
        if (solution == null) {
            System.out.println("No solution found.");
            return;
        }
        
        System.out.println("\nSolution found!");
        System.out.println("Sequence: " + solution);
        System.out.println("Length: " + solution.size() + " tiles");
        
        StringBuilder top = new StringBuilder();
        StringBuilder bottom = new StringBuilder();
        
        System.out.println("\nUsed tiles:");
        for (int idx : solution) {
            System.out.println("  Tile " + idx + ": " + tiles[idx]);
            top.append(tiles[idx].top);
            bottom.append(tiles[idx].bottom);
        }
        
        System.out.println("\nResult:");
        System.out.println("Top:    " + top);
        System.out.println("Bottom: " + bottom);
        System.out.println("Equal: " + top.toString().equals(bottom.toString()));
    }
    
    public static void main(String[] args) {
        System.out.println("=== (a) K1 ===");
        DominoTile[] k1 = {
            new DominoTile("0", "52"),
            new DominoTile("2", "0"),
            new DominoTile("2505", "25"),
            new DominoTile("3", "23")
        };
        List<Integer> solution1 = solve(k1, 15);
        printSolution(k1, solution1);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("=== (b) K2 ===");
        DominoTile[] k2 = {
            new DominoTile("11", "0"),
            new DominoTile("011", "1"),
            new DominoTile("0", "011")
        };
        List<Integer> solution2 = solve(k2, 15);
        printSolution(k2, solution2);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("=== (c) K3 ===");
        DominoTile[] k3 = {
            new DominoTile("10", "101"),
            new DominoTile("011", "11"),
            new DominoTile("101", "011")
        };
        List<Integer> solution3 = solve(k3, 15);
        printSolution(k3, solution3);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("=== (d) K4 ===");
        DominoTile[] k4 = {
            new DominoTile("0", "000"),
            new DominoTile("1", "0"),
            new DominoTile("110", "1"),
            new DominoTile("00", "110")
        };
        List<Integer> solution4 = solve(k4, 15);
        printSolution(k4, solution4);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("=== (e) K5 ===");
        DominoTile[] k5 = {
            new DominoTile("001", "0"),
            new DominoTile("01", "011"),
            new DominoTile("01", "101"),
            new DominoTile("10", "001")
        };
        List<Integer> solution5 = solve(k5, 15);
        printSolution(k5, solution5);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem5collexpt;

/**
 *
 * @author Rishabh
 */

import java.util.*;




public class waterjugbfs {
    
    public static int total = 0;

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void solveBFS(int jug1, int jug2, int target) {

        int m[][] = new int[5][5];
        for (int[] i : m) {
            Arrays.fill(i, -1);
        }

        boolean isSolveable = false;
        Vector<Node> result = new Vector<>();
        Queue<Node> q = new LinkedList<>();

        // add the starting position
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {

            Node temp = q.poll();

            // Out of capacity
            if (temp.x > jug1 || temp.x < 0 || temp.y > jug2 || temp.y < 0) {
                continue;
            }
            total++;

            // already visited node
            if (m[temp.x][temp.y] > -1)
                continue;

            // add to the result
            result.add(new Node(temp.x, temp.y));
            m[temp.x][temp.y] = 1;// Mark as a visited node

            // reach to the target
            if (temp.x == target || temp.y == target) {
                isSolveable = true;

                if (temp.x == target && temp.y != 0) {
                    // add the final state node by transferring water
                    System.out.println("222( " + temp.x + "," + "0)");
                    result.add(new Node(temp.x, 0));
                    
                } else if (temp.y == target && temp.x != 0) {
                    
                    // add the final state node by transferring water
                    System.out.println("111( 0" + "," + temp.y + ")");
                    result.add(new Node(0, temp.y));
                }
                for (int i = 0; i < result.size(); i++) {
                    System.out.println("(" + result.get(i).x + "," + result.get(i).y + ")");
                }
                break;
            }

            // fill the second jug
            q.add(new Node(temp.x, jug2));

            // fill the first jug
            q.add(new Node(jug1, temp.y));

            for (int j = 0; j <= Math.max(jug1, jug2); j++) {

                int state1 = temp.x + j;
                int state2 = temp.y - j;

                if (state1 == jug1 || (state2 == 0 && state2 >= 0)) {
                    q.add(new Node(state1, state2));
                }

                state1 = temp.x - j;
                state2 = temp.y + j;

                if ((state1 == 0 && state1 >= 0) || state2 == jug2) {
                    q.add(new Node(state1, state2));
                }
            }

            // empty the second jug
            q.add(new Node(jug1, 0));

            // empty the first jug
            q.add(new Node(0, jug2));
        }

        if (!isSolveable) {
            System.out.println("No solution");
        }

    }

    
    public static void main(String[] args) {
        waterjugbfs obj = new waterjugbfs();
        obj.solveBFS(4, 3, 2);
        System.out.println("Total nodes: " + (total + 1));

    }
}

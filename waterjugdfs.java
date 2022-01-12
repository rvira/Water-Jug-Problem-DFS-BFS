/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem5collexpt;

import java.util.*;

/**
 *
 * @author Rishabh
 */
public class waterjugdfs {
    
        public static int total = 0;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static Stack<Node> result=new Stack<Node>();
    static boolean[][] m = new boolean[5][5];
    static int found=0;

    static boolean solveDFS(int curj1, int curj2, int jug1, int jug2, int tx, int ty) {

        //Got final case
        if (curj1 == tx && curj2 == ty) {
            result.add(new Node(curj1, curj2));
            return true;
        }
        
        total++;

        //If the node is already visited
        if (m[curj1][curj2]) {
            return false;
        }
        //Marks the node as a visited
        m[curj1][curj2] = true;

        //Fill the 1st jug completely
        if (curj1 < jug1 && solveDFS(jug1, curj2, jug1, jug2, tx, ty)) {
            result.add(new Node(curj1, curj2));
            return true;
        }
        
        //Fill the 2nd jug completely
        if (curj2 < jug2 && solveDFS(curj1, jug2, jug1, jug2, tx, ty)) {
            result.add(new Node(curj1, curj2));
            return true;
        }
        if (curj1 > 0 && solveDFS(0, curj2, jug1, jug2, tx, ty)) {
            result.add(new Node(curj1, curj2));
            return true;
        }
        
        //Empty the second jug
        if (curj2 > 0 && solveDFS(curj1, 0, jug1, jug2, tx, ty)) {
            result.add(new Node(curj1, curj2));
            return true;
        }
        
        if(curj1>0 && curj2<jug2) {
            boolean temp;
            if(curj2+curj1<=jug2){
                //Empty first jug into second jug
                temp=solveDFS(0,curj1+curj2,jug1,jug2,tx,ty);
            }
            else{
                //Pour the water from 1st jug to 2nd jug
                temp=solveDFS(curj1-(jug2-curj2),jug2,jug1,jug2,tx,ty);
            }
            if(temp){
                result.add(new Node(curj1, curj2));
                return true;
            }
        }
        
        if(curj2>0 && curj1<jug1 && solveDFS(Math.min(curj1+curj2,jug1),curj2-Math.min(jug1,curj2),jug1,jug2,tx,ty)){
            boolean temp;
            
            if(curj2+curj1<=jug1){
                //Empty the second jug into first jug
                temp=solveDFS(curj1+curj2,0,jug1,jug2,tx,ty);
            }
            else{
                //Pour the water from second jug to first j
                temp=solveDFS(jug1, curj2-(jug1-curj2) ,jug1,jug2,tx,ty);
            }
            if(temp){
                result.add(new Node(curj1, curj2));
                return true;
            }
        }
        m[curj1][curj2]=false;
        return false;
    }
    
    
    //function to print the stack in reverse order
    public static void printReverseStack(Stack<Node> stack) {
         //base case
        if (stack.isEmpty())
            return;

        //create temporary stack
        Stack<Node> temporaryStack = new Stack<>();

        //copy all the elements from given stack to temporary stack
        while(stack.size()>0){
            temporaryStack.push(stack.pop());
        }

        for(Node n:temporaryStack) {
            System.out.println("("+n.x+","+n.y+")");
        }
    }

    
    public static void main(String[] args) {
        
        waterjugdfs obj = new waterjugdfs();
        boolean res = solveDFS(0,0,4,3,2,0);
        printReverseStack(result);       
        System.out.println("Total Nodes: "+total);

    }
}

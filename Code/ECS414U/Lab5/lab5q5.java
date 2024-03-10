package ECS414U.Lab5;

import java.util.Stack;

class Node {
    String label;
    Node[] outgoing;

    Node(String label) {
        this.label = label;
        this.outgoing = null;
    }
    public void linkTo(Node n) {
        if(outgoing == null) {
            outgoing = new Node[1];
            outgoing[0] = n;
            return;
        }

        Node[] newOutgoing = new Node[outgoing.length+1];
        for(int i = 0; i < outgoing.length; i++) {
            newOutgoing[i] = outgoing[i];
        }
        newOutgoing[outgoing.length] = n;
        outgoing = newOutgoing;
    }
}

public class lab5q5 {

    public static boolean isReachable(Node start, Node end) {
        
        Stack <Node> stack = new Stack<Node>(); //creates new stack to store all nodes that need to be visited
        Node[] visitedNodes = new Node[1];  //creates array to store all visited nodes
        stack.push(start);       //pushes passed node to top of stack (this will be taken first since a stack is LIFO (last in first out) 
        

        while (!stack.isEmpty()) {          //while loop that runs until there are no more nodes to be searched
            
            Node current = stack.pop();     //current is set using .pop() which assigns current to the first item added to the stack

            if (current == end) { //if statement for when it is found
                
                return true;
            }

            if (current.outgoing != null) { //if statement for when there is items in the node but none of them are end
                
                for (int n = 0 ; n < current.outgoing.length; n++) {  //for loop to run every node
                    
                    Node focus = current.outgoing[n];  //variable focus stores the current node being traversed (which is from the outgoing array)
                    stack.push(focus);   //pushes focus to the bottom of the stack 
                    
                    for (int i = 0; i < visitedNodes.length; i++) {  //for loop to search through visited nodes
                        
                        if (visitedNodes[i]==focus) {
                            
                            focus = stack.pop();  //if the node has already been visited, moves back to the previous node
                            break;              //break to move back to the original for loop with the new focus Node and next element in its outgoing array
                        }
                    }
                    
                    Node[] newvisitedNodes = new Node[visitedNodes.length + 1];  //creates new array with length increased by one
                    
                    for(int j = 0; j < visitedNodes.length; j++) { // for loop that copies the original visitedNodes onto the new one
                        
                        newvisitedNodes[j] = visitedNodes[j];
                    }
                    
                    newvisitedNodes[visitedNodes.length] = focus; //adds the focus node onto the new array
                    visitedNodes = newvisitedNodes; //assigns variable visitedNodes to the new array
                }
            }
        }
        
        return false; //returns false if its not found
    }

    

    public static void main(String[] args) {
    
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
    
        a.linkTo(b);
        b.linkTo(c);
        c.linkTo(e);
        e.linkTo(f);
        e.linkTo(d);
        d.linkTo(b);
    
        System.out.println(isReachable(a, e)); // true
        System.out.println(isReachable(f, a)); // false
        System.out.println(isReachable(a, f)); // true
        System.out.println(isReachable(e, f)); //true
        System.out.println(isReachable(a, d)); //true
        System.out.println(isReachable(d,a)); //false
        System.out.println(isReachable(b,a)); //false
    
    }

}

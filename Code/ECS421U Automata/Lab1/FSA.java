package ECS421U.Lab1;


import java.util.*;

public class FSA
    {
        public int numStates;
        public String alphabet[];
        public Transition delta[];
        public int finalStates[];
        
        public FSA(int n, String[] a, Transition[] d, int[] f)
        {
            numStates = n;
            alphabet = a;
            finalStates = f;
            delta = d;
        }

        // Convert the FSA into a 5-tuple string representation
        public String toString()
        {
            String s = "("+toStringAsSet(alphabet)+", {";
            for(int i=0; i<numStates; i++)
            {
                if(i!=0) s += ", ";
                s += "q"+i;
            }
            s += "}, "+toStringAsSet(delta)+", q0, {";
            for(int i=0; i<finalStates.length; i++)
            {
                if(i!=0) s += (", ");
                s += "q"+finalStates[i];
            }
            return s+"})";
        }
            
        // Perform all kinds of checks on an FSA
        public String check()
        {
            // Check the alphabet is valid
            if(alphabet==null) return "Bad alphabet (null)";
            // Check the number of states is valid
            if(numStates<=0) return "Bad number of states ("+numStates+")";
            // Check that the transition relation is valid 
            checkTRelation(delta,"transition relation");
            // Check that final states are valid
            if(finalStates==null) return "Bad (null) final states";
            for(int s : finalStates) {
                String checkS = checkState(s);
                if(checkS != "") return ("Bad final states element: "+checkS);
            }
            return "";
        }
    
        private String checkState(int s)
        {
            if (s<0 || s>=this.numStates) return ("incorrect state number ("+s+")");
            return "";
        }
    
        private String checkTRelation(Transition[] a,String name)
        {
            if(a==null) return ("Bad (null) "+name);
            for(Transition t : a) {
                String checkT = checkTransition(t); 
                if (checkT != "") return ("Bad "+name+" element "+t+": "+checkT); 
            }
            return "";
        }
    
        private String checkLabel(String l)
        {
            for(String s : alphabet) if(s == l) return ""; 
            if(l != "") return ("label not in alphabet ("+l+")"); return "";
        }
    
        private String checkTransition(Transition t) 
        {
            String checkC = checkState(t.from); 
            if(checkC != "") return checkC;
            checkC = checkState(t.to);
            if(checkC != "") return checkC;
            return checkLabel(t.label);
        }
    
        // Convert an array that represents a set into a string 
        private String toStringAsSet(Object[] x)
        {    
            String t = Arrays.toString(x);
            return "{"+t.substring(1,t.length()-1)+"}";
        }
    }
    
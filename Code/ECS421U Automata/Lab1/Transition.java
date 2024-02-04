package ECS421U.Lab1;


public class Transition 
{
    public int from; 
    public String label;
    public int to;

    Transition(int f,String l,int t)
    {
        from = f; label = l; to = t;
    }

    public String toString()
    {
        String x = label;
        if(x == "") x = "\u03B5";
        return "(q"+from+","+x+",q"+to+")";
    }
}


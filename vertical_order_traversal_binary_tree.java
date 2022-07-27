class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        if(root==null)
        {
            return new ArrayList<Integer>();
        }
        TreeMap<Integer,ArrayList<Integer>> m=new TreeMap<>();
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(0,root));
        
      
        while(q.isEmpty()==false)
        {
            Pair p=q.poll();Node curr=p.node;int hd=p.hd;
            
            if(m.containsKey(hd))
            {
                m.get(hd).add(curr.data);
            }
            else
            {
                ArrayList<Integer> temp=new ArrayList <Integer>();
                temp.add(curr.data);
                m.put(hd,temp);
            }
            if(curr.left!=null)
            {
                q.add(new Pair(hd-1,curr.left));
                
            }
            if(curr.right!=null)
            {
                q.add(new Pair(hd+1,curr.right));
            }
            
        }
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(Map.Entry<Integer,ArrayList<Integer>> p:m.entrySet())
        {
            ArrayList<Integer> a=p.getValue();
            
            for(int x:a)
            {
                result.add(x);
            }
        }
        
        return result;
    }
}

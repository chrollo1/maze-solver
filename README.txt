METHOD OF SOLVING:

Suppose we have this "maze" example in memory,
		
			    c — f
			   / \ / \
			  a — d — n
			 /   /   
			x   b         (where c is starting node)
				      
		
		DEPTH FIRST SEARCH:
	          c
	       /  | \
	      /   |  \
	     /    |   \
	    a    >d<  >f<
     	  /  \
         x   >d< 
	/   
       b    
      /	
     d_ __
    /| \  \
   / |  \  \
 >a< >c< f  >g<
        /| \
       / |  \
     >c< >d< (g)
		             
		 * >node< marks visited nodes
		 * DFS found g
		
DFS will not go to visited nodes (stored in current path List) and will instead go to unvisited nodes (not stored in current path List) and append to list.
		
		Therefore, the path is:
		
			c -> a -> x -> b -> d -> f -> g 
		
		Space complexity: O(n)
		Time complexity: O(m + n)
		
		where n is the number of nodes in the path
		      m is the total connections between nodes

# Maze Solver with DFS (will implement Djikstra soon)

### Example Maze

![alt text](https://media.giphy.com/media/1wpO1hhXMrhqOrUwQo/giphy.gif)

Suppose we have this "maze" example in memory,
```	
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
```	             
		 * >node< marks visited nodes
		 * DFS found g
		
DFS will not go to visited nodes (stored in current path List) and will instead go to unvisited nodes (not stored in current path List) and append to list.
		
		Therefore, the path is:
		
			c -> a -> x -> b -> d -> f -> g 
		
		Space complexity: O(n)
		Time complexity: O(m + n)
		
		where n is the number of nodes in the path
		      m is the total connections between nodes
          
          
# Djikstra's Shortest Path Algorithm

Given a directed graph G = (V, E) with positive edge weights, the single-source shortest path problem can be solved using Djikstra's shortest path algorithm.

The time complexity of such is: 
O(m log n)


```
void computePaths(Vertex src):
  src.min := 0
  q.add(src)
     
  while q is not empty:
    u := q.poll();
    
    for each edge e in u.adj:
      v := e.target
      w := e.weight
      dis_to_u := u.min + weight
      if dis_to_u < v.min:
        q.remove(v)
        v.min = dis_to_u
        v.prev = u
        q.add(v)       
```

import java.util.ArrayList;

public class MazeSolve {
	
	// init global vars for chars
	public static final char EMPTY = ' ';
	public static final char VISITED = 'o';
	public static final char PATH = (char) 0x25A0;

	// init maze
	public static char[][] maze = {

			{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
			{'-','X',' ','-','-','-','-','-',' ',' ','-','-',' ',' ',' ','-',' ',' ','-',' ',' ','-',' ',' ','-',' ','-','-','-',' '},
			{'-',' ',' ','-',' ',' ',' ',' ',' ',' ',' ','-','-','-',' ','-',' ',' ','-',' ',' ','-',' ','-','-',' ','-',' ','-',' '},
			{'-',' ',' ','-','-','-',' ','-','-',' ','-','-',' ','-',' ','-','-',' ','-',' ','-','-',' ','-',' ',' ','-',' ','-','-'},
			{'-','-',' ',' ',' ','-',' ','-',' ',' ','-',' ',' ','-',' ',' ','-',' ','-','-','-',' ',' ','-','-',' ','-',' ',' ',' '},
			{'-',' ','-',' ',' ','-',' ','-','-','-','-','-',' ','-',' ',' ','-',' ',' ',' ','-','-','-',' ','-',' ','-','-','-',' '},
			{'-',' ','-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-','-',' ','-','-','-',' ',' ',' ',' ',' ','-',' ',' ',' ','-','-'},
			{'-','-','-',' ',' ',' ',' ','-','-','-','-','-','-',' ','-',' ',' ',' ','-','-','-','-','-',' ','-','-','-',' ',' ','-'},
			{' ',' ',' ','-','-','-',' ',' ',' ',' ',' ',' ',' ',' ','-','-','-','-',' ',' ',' ',' ','-',' ',' ',' ','-','-',' ','-'},
			{'-','-',' ','-',' ','-',' ',' ',' ','-','-','-','-','-',' ',' ',' ','-',' ','-','-','-','-',' ','-',' ',' ','-',' ','-'},
			{' ','-',' ','-',' ','-','-','-',' ',' ',' ','-',' ',' ',' ',' ','-','-',' ',' ',' ','-',' ',' ','-','-',' ','-',' ','-'},
			{'-','-',' ','-',' ',' ',' ',' ','-',' ',' ','-',' ','-','-','-','-',' ',' ',' ','-','-',' ',' ','-',' ',' ','-','-','-'},
			{'-',' ',' ','-',' ',' ','-','-','-',' ',' ','-','-','-',' ',' ',' ',' ','-','-','-',' ','-','-','-',' ',' ',' ','-','-'},
			{'-','-',' ','-',' ','-','-',' ',' ',' ',' ',' ',' ',' ',' ',' ','-','-','-',' ',' ',' ',' ',' ','-',' ','-','-','-','-'},
			{' ','-',' ','-',' ','-',' ','-','-','-','-','-','-','-',' ','-','-',' ','-','-',' ','-','-','-','-',' ','-',' ',' ','-'},
			{'-','-','-','-',' ','-',' ',' ',' ','-',' ',' ',' ','-',' ',' ',' ',' ',' ','-',' ',' ',' ','-',' ',' ','-',' ',' ','-'},
			{'-',' ','-',' ',' ','-','-','-',' ','-','-','-',' ','-','-','-','-','-',' ',' ',' ','-','-','-',' ','-','-',' ',' ','-'},
			{' ',' ','-','-','-',' ',' ','-','-',' ',' ','-',' ',' ',' ',' ',' ','-','-','-',' ',' ','-',' ',' ','-',' ',' ','-','-'},
			{'-','-','-',' ','-',' ',' ',' ','-','-',' ','-','-',' ','-','-',' ',' ',' ',' ','-',' ','-','-','-','-','-','-','-','-'},
			{'-',' ',' ',' ','-',' ',' ',' ',' ','-',' ',' ','-','-','-',' ',' ','-',' ',' ','-',' ',' ',' ',' ',' ',' ',' ','-','-'},
			{'-','-','-',' ',' ','-','-','-',' ','-','-','-',' ',' ','-','-',' ','-','-','-','-',' ','-','-','-','-',' ',' ',' ','-'},
			{'-',' ','-',' ',' ','-',' ','-',' ',' ',' ','-',' ','-',' ','-','-',' ',' ',' ',' ',' ','-',' ',' ','-',' ','-','-','-'},
			{'-',' ','-',' ','-','-',' ','-','-','-',' ','-',' ','-',' ',' ','-','-',' ','-','-',' ',' ',' ',' ','-',' ','-',' ','-'},
			{'-',' ','-','-','-',' ','-','-',' ',' ',' ','-',' ','-',' ',' ',' ','-','-','-',' ',' ',' ',' ','-','-',' ','-',' ','-'},
			{'-',' ',' ',' ',' ',' ','-',' ','-','-','-','-',' ','-',' ',' ',' ',' ',' ',' ',' ',' ','-',' ','-',' ',' ','-','-','-'},
			{'-',' ','-',' ','-','-','-',' ',' ',' ','-',' ',' ','-','-','-','-',' ','-','-','-',' ',' ',' ',' ',' ',' ',' ',' ','-'},
			{'-','-','-',' ','-',' ','-','-',' ','-','-',' ',' ','-',' ',' ','-','-','-',' ','-','-',' ',' ',' ','-','-',' ',' ','-'},
			{' ','-',' ',' ','-',' ',' ',' ',' ','-',' ','-','-','-','-','-',' ',' ',' ',' ',' ','-','-','-',' ','-',' ',' ',' ','-'},
			{'-','-','-',' ','-','-',' ','-','-','-',' ','-',' ',' ',' ',' ',' ','-','-','-',' ',' ',' ','-',' ',' ',' ',' ',' ','-'},
			{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}

	};

	public static void main(String[] args) throws InterruptedException {

		// init path
		ArrayList<Integer> path = new ArrayList<>();
		
		// BFS is given "starting coordinates", which means that it search for X, but it appears to start at X and find "starting coordinates"
		searchMaze(maze, 28, 28, path);
		
		// update path list
		updatePosition(maze, path);
		
	}
	
	/*
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

	 */

	public static boolean searchMaze(char[][] maze, int x, int y, ArrayList<Integer> path) {

		// start
		if (maze[y][x] == 'X') {
			path.add(x);
			path.add(y);
			return true;
		}

		// dirs
		int up = 1;
		int down = -1;
		int left = -1;
		int right = 1;

		// if non-visited, set to visited..
		if (maze[y][x] == EMPTY) {
			maze[y][x] = VISITED;

			if(searchMaze(maze, x + left,  y,        path)  || // west
			   searchMaze(maze, x + right, y,        path)  || // east
			   searchMaze(maze, x,         y + up,   path)  || // north
			   searchMaze(maze, x,         y + down, path)) {  // down

				// add to curr list
				path.add(x);
				path.add(y);
				return true;	
			} 
		}

		return false;
	}

	public static void updatePosition(char[][] maze, ArrayList<Integer> path) throws InterruptedException {

		// x coord in path are [0, 2, 4, ..., path.size() - 2]
		for(int p = 0; p < path.size(); p+=2) {
			int pathX = path.get(p);
			// y coord are [1, 3, 5, ..., path.size() - 1];
			int pathY = path.get(p+1);
			// set maze at P(pathX, pathY) to path char
			maze[pathY][pathX] = PATH;
			// print update
			printMaze(maze, path);
			// sleep for 50 milliseconds
			Thread.sleep(50);
		}

	}

	public static void printMaze(char[][] maze, ArrayList<Integer> path) {
		// print empty lines
		for(int i = 0 ; i < maze[0].length; i++) {
			System.out.println();
		}

		// draw maze
		for(char[] x : maze) {
			for(char y : x) {
				if(y == VISITED)
					System.out.print(" " + " ");
				else
					System.out.print(y + " ");
			}
			System.out.println();
		}
	}
}

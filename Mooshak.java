package amcat;

public class Mooshak {

		
		int isPath(int grid[][],int m,int n)
		{
		      return SolveMazeUtil(grid,0,0,m,n);
		}
		static int SolveMazeUtil(int grid[][],int x,int y,int m,int n)
		{
			if(x>=0 && x < m && y>=0 && y < n)
		                {                 
		                                 if(grid[x][y]==9)
		                                 {
		                                                return 1;
		                                 }

		                                // Check if maze[x][y] is valid
		                                if(grid[x][y] == 1)
		                                {
		                                				grid[x][y] = 0;
		                                				if(SolveMazeUtil(grid, x, y-1, m,n) == 1)
		                                								return 1;
		                                                /* Move forward in x direction */
		                                                if (SolveMazeUtil(grid, x+1, y, m,n) == 1)
		                                                                return 1;                                             
		                                                /* If moving in x direction doesn't give solution then
		                                                                Move down in y direction  */
			                                             if (SolveMazeUtil(grid, x, y+1, m,n) == 1)
			                                                            return 1; 
			                                             if (SolveMazeUtil(grid, x-1, y, m,n) == 1)
                                                             		    return 1; 
		                                    return 0;
		                                }    
		                                return 0;
		                }
		                return 0;

		}


	public static void main(String[] args){
		int grid[][] = {{1,1,1,1}, {1,0,0,0}, {1,0,9,0}, {1,0,0,0},{1,1,1,0}};
		int m= grid.length;
		int n = grid[0].length;
		System.out.println(SolveMazeUtil(grid,0,0,m,n));
		
}
	
}


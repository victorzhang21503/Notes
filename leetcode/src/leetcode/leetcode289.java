package leetcode;

public class leetcode289 {
	 public void gameOfLife(int[][] board) {
	        if(board == null || board.length == 0) return;
	        int m = board.length, n = board[0].length;
	        
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                int lives = liveNeighbors(board, m, n, i, j);
	                if((board[i][j] & 1) == 1 && (lives >= 2 && lives <=3)){
	                    board[i][j] = 3;
	                }
	                if((board[i][j] & 1) == 0 && lives == 3){
	                    board[i][j] = 2;
	                }
	            }
	        }
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                board[i][j] >>= 1;
	            }
	        }
	    }
	    
	    public int liveNeighbors(int[][] board, int m, int n, int i, int j){
	        int lives = 0;
	        for(int p = Math.max(i-1, 0); p <= Math.min(i+1, m-1); p++){
	            for(int q = Math.max(j-1, 0); q <= Math.min(j+1, n-1); q++){
	                lives += board[p][q] & 1;
	            }
	        }
	        lives -= board[i][j] & 1;
	        return lives;
	    }
}

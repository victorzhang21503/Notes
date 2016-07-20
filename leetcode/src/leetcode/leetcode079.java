package leetcode;

public class leetcode079 {
	public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(exist(board, i, j, w, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, int i, int j, char[] w, int pos){
        if(pos == w.length) return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length){
            return false;
        }
        if(board[i][j] != w[pos]) return false;
        board[i][j] ^= 256;
        boolean exist = exist(board, i+1, j, w, pos + 1) || exist(board, i-1, j, w, pos + 1) || exist(board, i, j+1, w, pos + 1) || exist(board, i, j-1, w, pos + 1);
        board[i][j] ^= 256;
        return exist;
    }
}

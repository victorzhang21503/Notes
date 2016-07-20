package leetcode;
import java.util.*;

public class test {
	public static void main(String args[]){
		TrieNode dictionary = new TrieNode();
		char[][] board =  char[2][2];
		board[0][0] = 'a';
		board[0][1] = 'b';
		board[1][0] = 'c';
		board[1][1] = 'd';
		dictionary.addWord(board);
		if(dictionary.searchWord("a")) System.out.println("the dictionary has this word!");
	}
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
}

class Trie{
    TrieNode root = new TrieNode();
    void addWord(char[][] board){
        if(board == null || board.length == 0) return;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                helper(board, root, i, j);
            } 
        }
    }
    
    void helper(char[][] board, TrieNode ws, int i, int j){
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '*') return;
        else{
            if(ws.children[board[i][j] - 'a'] == null){
                ws.children[board[i][j] - 'a'] = new TrieNode();
            }
            ws = ws.children[board[i][j] - 'a'];
            char temp = board[i][j];
            board[i][j] = '*';
            helper(board, ws, i++, j);
            helper(board, ws, i--, j);  
            helper(board, ws, i, j++);
            helper(board, ws, i, j--);
            board[i][j] = temp;
        }
    }
    
    boolean searchWord(String word){
        TrieNode ws = root;
        for(char c : word.toCharArray()){
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}
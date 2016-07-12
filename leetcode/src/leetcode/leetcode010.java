package leetcode;

public class leetcode010 {
	/*
	*	f[i][j]: if	s[0..i-1] matches p[0..j-1]
	*	if p[j - 1]	!= '*'
	*	f[i][j]	= f[i - 1][j - 1] && s[i - 1] == p[j - 1]
	*	if p[j - 1]	== '*',	denote p[j - 2]	with x
	*	f[i][j]	is true	if any of the following	is true
	*	1) "x*"	repeats	0 time and matches empty: f[i][j - 2]
	*	2) "x*"	repeats	>= 1 times and matches "x*x": s[i -	1] == x && f[i - 1][j]
	*	'.'	matches	any	single	character
	*/
	public boolean isMatch(String s, String p){
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for(int i = 1; i <= m; i++){
            f[i][0] = false;
        }
        
        for(int j = 1; j <= n; j++){
            f[0][j] = j > 1 && '*' == p.charAt(j-1) && f[0][j-2];
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(j-1) != '*'){
                    f[i][j] = f[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || '.' == p.charAt(j-1));
                }
                else{
                    f[i][j] = (f[i][j-2] || ((s.charAt(i-1) == p.charAt(j-2) || '.' == p.charAt(j-2)) && f[i-1][j]));
                }
            }
        }
        return f[m][n];
    }
}

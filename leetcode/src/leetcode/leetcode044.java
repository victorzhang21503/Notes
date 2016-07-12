package leetcode;

public class leetcode044 {
	public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while(s < str.length()){
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            else if(p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            else if(starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            else return false;
        }
        while(p < pattern.length() && pattern.charAt(p) == '*'){
            p++;
        }
        return p == pattern.length();
    }
	
//*****************************************************************************************************
	
	public boolean isMatch_sol2(String s, String p) {
        int count = 0;
        for(char c :p.toCharArray()){
            if (c == '*'){
                count++;
            }
        }
        if(p.length() - count > s.length()) return false;
        
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for(int j = 1; j <= p.length(); j ++){
            char pattern = p.charAt(j - 1);
            dp[j][0] = dp[j-1][0] && pattern == '*';
            for(int i = 1; i <= s.length(); i++){
                char letter = s.charAt(i - 1);
                if(pattern != '*'){
                    dp[j][i] = dp[j-1][i-1] && (pattern == '?' || pattern == letter);
                }
                else{
                    dp[j][i] = dp[j][i -1] || dp[j - 1][i];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}



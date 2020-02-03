/*
input n: 2
output : ["11","69","88","96"]
*/


private final char[][] mapping = {{'0','0'}, {'1','1'}, {'6','9'}, {'8','8'},{'9','9'}};

public List<String> findStrobogrammic(int n){
    List<String> res = new ArrayList<String>();
    if(n < 1)
        return res;
    char[] ch = new char[n];
    helper(ch, 0, n-1, res);
    return res;
}

public void helepr(char[] ch, int lo, int hi, List<String> res){
        
    if(lo > hi){
        if(ch.length == 1 || ch[0] != '0')
            res.add(String.valueOf(ch));
        return;
    }

    for(char[] map : mapping){
        if(lo == hi && map[0] != map[1]) continue;
        ch[lo] = map[0];
        ch[hi] = map[1];
        helper(ch, lo+1, hi-1, res);
    }
}
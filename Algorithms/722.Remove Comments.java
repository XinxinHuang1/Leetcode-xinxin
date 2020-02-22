//Medium

//Time O(S) Space O(S)  S: source length
class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        if(source.length == 0)
            return res;
        StringBuilder sb = null;
        Boolean inComment = false;
        for(String line : source){
            int n = line.length();
            if(!inComment)
                sb = new StringBuilder();
            int i = 0;
            while(i < n){
                if(!inComment && i+1 < n && line.charAt(i) == '/' && line.charAt(i+1) == '/')
                    break;
                else if(!inComment && i+1 < n && line.charAt(i) == '/' && line.charAt(i+1) == '*'){
                    inComment = true;
                    i++;
                }
                else if(inComment && i+1 < n && line.charAt(i) == '*' && line.charAt(i+1) == '/'){
                    inComment = false;
                    i++;
                }
                else if(!inComment){
                    sb.append(line.charAt(i));
                }
                i++;
            }
            if(!inComment && sb.length() > 0){
                res.add(sb.toString());
            }
        }
        return res;
    }
}
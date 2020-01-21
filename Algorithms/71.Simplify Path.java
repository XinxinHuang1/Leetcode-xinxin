/**
 Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.

input   "/a//b////c/d//././/.."
Output  "/a/b/c"
 */

class Solution {
    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();
        Set<String> skip = new HashSet<String>(Arrays.asList(".","..",""));
        for(String p : path.split("/")){
            if(p.equals("..") && !queue.isEmpty()){
                queue.removeLast();
            }
            else if(!skip.contains(p)){
                queue.addLast(p);
            }
        }
        StringBuilder sb = new StringBuilder("/");
        if(!queue.isEmpty()){
            while(!queue.isEmpty()){
                sb.append(queue.pop());
                sb.append("/");
            }
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
 
/**
 Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 */

//Time O(MN) M: accounts   size N: size of each list
//Space O(N)
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if(accounts == null || accounts.size() == 0)
            return res;
        
        //map each email to username
        Map<String, String> emailToName = new HashMap<>();
        //map each email to its neighbor emails
        Map<String, Set<String>> graph = new HashMap<>();
        //put all emails to set
        Set<String> emails = new HashSet<>();
        //visited
        Set<String> visited = new HashSet<>();
        
        for(List<String> list : accounts){
            String name = list.get(0);
            for(int i = 1; i < list.size(); i++){
                String email = list.get(i);
                emails.add(email);
                emailToName.put(email, name);
                //graph: link email to its neighbours
                graph.putIfAbsent(email, new HashSet<String>());
                if(i == 1) continue;
                graph.get(list.get(i-1)).add(email);
                graph.get(email).add(list.get(i-1));
            }
        }
        for(String e : emails){
            if(!visited.contains(e)){
                visited.add(e);
                List<String> tmp = new ArrayList<>();
                tmp.add(e);
                dfs(e, graph, visited, tmp);// dfs find neighbours
                Collections.sort(tmp);
                tmp.add(0, emailToName.get(e));//add user name to index 0
                res.add(tmp);
            }
        }
        return res;
    }
    private void dfs(String e, Map<String, Set<String>> graph, Set<String> visited, List<String> tmp){
        for(String nei : graph.get(e)){
            if(!visited.contains(nei)){
                visited.add(nei);
                tmp.add(nei);
                dfs(nei, graph, visited, tmp);
            }
        }
    }
}


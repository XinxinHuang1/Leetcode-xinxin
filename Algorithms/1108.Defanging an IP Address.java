


class Solution {
    public String defangIPaddr(String address) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < address.length(); i++){
            if(address.charAt(i) != '.'){
                sb.append(address.charAt(i));
            }
            else{
                sb.append('[');
                sb.append('.');
                sb.append(']');
            }
        }
    return sb.toString();
    }
}


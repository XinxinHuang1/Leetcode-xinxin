class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int a = 0, b = 0, c = 0;
        int d = arr1.length, e = arr2.length, f = arr3.length;
        ArrayList<Integer> ls = new ArrayList<Integer>();
        while(a < d && b < e && c < f){
            if(arr1[a] < arr2[b]){
                a++;
            }
            else if(arr1[a] > arr2[b]){
                b++;
            }
            else if(arr2[b] < arr3[c]){
                b++;
            }
            else if(arr2[b] > arr3[c]){
                c++;
            }
            else if(arr1[a] < arr3[c]){
                a++;
            }
            else if(arr1[a] > arr3[c]){
                c++;
            }
            else{
                ls.add(arr1[a]);
                a++; b++; c++;
            }
        }
        return ls;
    }
}
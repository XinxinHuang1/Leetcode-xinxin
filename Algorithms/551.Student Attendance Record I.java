/*
You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
 */
class Solution {
    public boolean checkRecord(String s) {
        int n = s.length();
        int a = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'A')
                a++;
            if(a > 1)
                return false;
        }
        for(int i = 0; i < n - 2; i++){
            if(s.charAt(i) == 'L' && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L')
                return false;
        }
        return true;
    }
}
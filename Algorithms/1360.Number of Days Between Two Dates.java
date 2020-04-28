/*
Write a program to count the number of days between two dates.

The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.

 

Example 1:

Input: date1 = "2019-06-29", date2 = "2019-06-30"
Output: 1
Example 2:

Input: date1 = "2020-01-15", date2 = "2019-12-31"
Output: 15
 

Constraints:

The given dates are valid dates between the years 1971 and 2100.
 */

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int days1 = calcDays(date1);
        int days2 = calcDays(date2);
        return Math.abs(days1 - days2);
    }
    
    private int calcDays(String ss){
        
        int[] monthdays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        String[] s = ss.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);
        
        for(int i = 1971; i < year; i++){
            day += isLeapYear(i) ? 366 : 365;
        }
        for(int i = 1; i < month; i++){
            if(isLeapYear(year) && i == 2)
                day += 1;
            day += monthdays[i];
        }
        return day;
    }
    
    private boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
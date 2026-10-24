// Last updated: 10/24/2026, 8:47:57 PM
1class Solution {
2    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
3        int arriveA = dateToDay(arriveAlice);
4        int leaveA = dateToDay(leaveAlice);
5        int arriveB = dateToDay(arriveBob);
6        int leaveB = dateToDay(leaveBob);
7        
8        int overlapStart = Math.max(arriveA, arriveB);
9        int overlapEnd = Math.min(leaveA, leaveB);
10        
11        return Math.max(0, overlapEnd - overlapStart + 1);
12    }
13    
14    private int dateToDay(String date) {
15        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
16        int month = Integer.parseInt(date.substring(0, 2));
17        int day = Integer.parseInt(date.substring(3, 5));
18        
19        int totalDays = 0;
20        for (int i = 0; i < month - 1; i++) {
21            totalDays += daysInMonth[i];
22        }
23        totalDays += day;
24        
25        return totalDays;
26    }
27}
// Last updated: 10/30/2026, 8:38:27 PM
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveA = dateToDay(arriveAlice);
        int leaveA = dateToDay(leaveAlice);
        int arriveB = dateToDay(arriveBob);
        int leaveB = dateToDay(leaveBob);
        
        int overlapStart = Math.max(arriveA, arriveB);
        int overlapEnd = Math.min(leaveA, leaveB);
        
        return Math.max(0, overlapEnd - overlapStart + 1);
    }
    
    private int dateToDay(String date) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int totalDays = 0;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }
        totalDays += day;
        
        return totalDays;
    }
}
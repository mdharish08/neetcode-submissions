/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0){
            return 0;
        }
        int[] val = new int[1000002];

        for(Interval i : intervals){
            val[i.start]+=1;
            val[i.end]-=1;
        }
        int cur = 0 ,ans = 1;
        for(int i = 0 ; i <1000002;i++){
           cur +=  val[i];
            ans = Math.max(ans,cur);
        }

        return ans;
    }
}

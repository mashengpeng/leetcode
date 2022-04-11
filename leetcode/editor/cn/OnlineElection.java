package editor.cn;
 
import java.util.*; 


public class OnlineElection{
    public static void main(String[] args) {
        //Solution solution = new OnlineElection().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class TopVotedCandidate {
    int n;
    int[] query;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        n = persons.length;
        query = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        //int idx = -1;
        for (int i = 0; i < n; i++) {
            int cur = map.getOrDefault(persons[i], 0) + 1;
            map.put(persons[i], cur);
            if(cur >= max){
                query[i] = persons[i];
                max = cur;
                //idx = persons[i];
            }else{
                query[i] = query[i - 1];
            }
        }

        //System.out.println(Arrays.toString(query));
    }
    
    public int q(int t) {
        int idx = Arrays.binarySearch(times, t);

        return idx >= 0 ? query[idx] : query[-idx - 2];




//        int idx = -1;
//        int left = 0, right = times.length - 1;
//        while(left < right){
//            int mid = (left + right + 1) / 2;
//            if(times[mid] == t){
//                idx = mid;
//                break;
//            }else if(times[mid] < t){
//                left = mid;
//            }else{
//                right = mid - 1;
//            }
//            idx = left;
//        }
//        return query[idx];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
//leetcode submit region end(Prohibit modification and deletion)


}
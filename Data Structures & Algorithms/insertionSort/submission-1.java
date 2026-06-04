// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        if (pairs.size() == 0){
            return new ArrayList<>();
        }
        int l = 0;
        int r = 1;
        List<List<Pair>> output = new ArrayList<List<Pair>>();
        output.add(new ArrayList<>(pairs));
        while (l < pairs.size() - 1){
            r = l + 1;
            while (r != 0){
                if (pairs.get(r).key < pairs.get(r-1).key){
                    Pair temp = pairs.get(r-1);
                    pairs.set(r-1, pairs.get(r));
                    pairs.set(r, temp);
                    r--;
                }
                else{
                    break;
                }
            }
            l++;
            output.add(new ArrayList<>(pairs));
        }
        return output;
    }
}

// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSortHelper(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> quickSortHelper(List<Pair> pairs, int l, int r){
        if ( l < r){
            int ls = l;
            int lf = l;

            while (lf < r){
                if (pairs.get(lf).key < pairs.get(r).key){
                    Pair temp = pairs.get(ls);
                    pairs.set(ls, pairs.get(lf));
                    pairs.set(lf, temp);
                    ls++;
                }
                lf++;
            }

            Pair temp = pairs.get(ls);
            pairs.set(ls, pairs.get(r));
            pairs.set(r, temp);

            quickSortHelper(pairs, l, ls - 1);
            quickSortHelper(pairs, ls + 1, r);
            return pairs;
        }
        return pairs;
    }
}

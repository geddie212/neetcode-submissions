// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortH(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> mergeSortH(List<Pair> pairs, int l, int r){
        if (l < r){
            int mid = (l + r)/2;
            mergeSortH(pairs, l, mid);
            mergeSortH(pairs, mid+1, r);
            merge(pairs, l, mid, r);
        }
        return pairs;
    }

    public void merge(List<Pair> pairs, int l, int m, int r){
        List<Pair> out = new ArrayList<Pair>();
        int ls = l;
        int rs = m+1;
        while (ls <= m && rs <= r){
            if (pairs.get(ls).key <= pairs.get(rs).key){
                out.add(pairs.get(ls));
                ls++;
            }
            else{
                out.add(pairs.get(rs));
                rs++;
            }
        }
        while(ls <= m){
            out.add(pairs.get(ls));
            ls++;
        }
        while(rs <= r){
            out.add(pairs.get(rs));
            rs++;
        }

        for (int i = 0; i < out.size(); i++){
            pairs.set(l+i, out.get(i));
        }
    }
}

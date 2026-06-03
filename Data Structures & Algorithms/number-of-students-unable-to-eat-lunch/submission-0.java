class Solution {

    class Node {
        int sandwich;
        Node next;
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Node head = null;
        Node tail = null;
        for (int stu : students){
            Node s = new Node();
            s.sandwich = stu;
            if (head == null){
                head = s;
                tail = s;
            }
            else {
                tail.next = s;
                tail = tail.next;
            }
        }
        int size = students.length;

        int sanIdx = 0;
        int hungry = 0;
        while (head != null){
            Node curr = head;
            head = head.next;
            curr.next = null;

            if (curr.sandwich == sandwiches[sanIdx]){
                size--;
                hungry = 0;
                sanIdx++;
            }
            else {
                tail.next = curr;
                tail = tail.next;
                hungry++;
            }

            if (hungry == size){
                return hungry;
            }
        }

        return 0;
    }
}
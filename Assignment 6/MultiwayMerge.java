import java.util.*;
public class MultiwayMerge {
    public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists) {
        // PriorityQueue that orders by first value of linkedlist
        PriorityQueue<LinkedList<Integer>> pq = new PriorityQueue<>(lists.length,Comparator.comparingInt(LinkedList::getFirst));
        LinkedList<Integer> ans = new LinkedList<>(); // merged list

        for (LinkedList<Integer> l : lists) {
            if (!l.isEmpty()) {
                pq.offer(l); // add every list to pq
            }
        }

        while (!pq.isEmpty()) {
            // Comparing first elements of every list and add to final merged list, smallest first
            LinkedList<Integer> head = pq.poll(); // removes first list from priorityqueue
            Integer temp = head.removeFirst(); // add smallest element of the first list to merged list
            ans.addLast(temp);
            if(!head.isEmpty()) {
                pq.offer(head); // re-order the priorityqueue
            }
        }
        return ans;

    }
}
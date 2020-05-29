import java.util.*;

public class RPal {
    // store all the known answers, so we don't have to compute them again
    private Map<Integer, List<List<Integer>>> storageAllRPals;


    // a constructor: creates the above storage and puts in answers
    // for our base cases of n = 0 and n = 1.
    public RPal() {
        storageAllRPals = new HashMap<>();
        storageAllRPals.put(0, Arrays.asList(Arrays.asList()));
        storageAllRPals.put(1, Arrays.asList(Arrays.asList(1)));
    }

    private List<List<Integer>> computeAllRPals(int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(Arrays.asList(n));
        if (storageAllRPals.get(n) != null) {
            return storageAllRPals.get(n);
        }

        for (int i = 0; i < n; i++) {
            if ((n-i)%2 == 0) {
                if (allRPals((n-i)/2) == null) {
                    storageAllRPals.put((n-i)/2,computeAllRPals((n-i)/2));
                }
                
                for (int j = 0; j<(allRPals((n-i)/2)).size(); j++) {
                    List<Integer> rest = new ArrayList<Integer>((allRPals((n-i)/2)).get(j));
                    if (i != 0) {
                        rest.add(i);
                    }
                    rest.addAll((allRPals((n-i)/2)).get(j));
                    ans.add(rest);             
                }
                
            }
        }

        return ans;
    }

    public List<List<Integer>> allRPals(int n) {
        // Challenge: if you feel like learning a new trick, how would you
        // rewrite the following using just storageAllRPals.computeIfAbsent(..)?

        List<List<Integer>> answer = storageAllRPals.get(n);
        if (answer == null) {
            answer = computeAllRPals(n);
            storageAllRPals.put(n, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        RPal rPal = new RPal();
        rPal.allRPals(224);
        final long endTime = System.currentTimeMillis();
        System.out.println("Run time : "+(endTime - startTime)/1000);
    }
}

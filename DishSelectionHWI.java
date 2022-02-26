import java.util.*;

public class DishSelectionHWI {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0;i < t;i++) {
            int n = in.nextInt();
            in.nextLine();
            String inp[] = in.nextLine().split(" ");
            HashMap<Integer,Integer> counts = new HashMap<Integer,Integer>();
            HashMap<Integer,Integer> lastInd = new HashMap<Integer,Integer>();
            int arr[] = new int[n];
            for (int j = 0; j < inp.length;j++) {
                arr[j] = Integer.parseInt(inp[j]);
            }
            for (int j = 0;j < arr.length;j++) {
                int temp = arr[j];
                if (counts.containsKey(temp)) {
                    int lain = lastInd.get(temp);
                    if (j != lain + 1) {
                        int count = counts.get(temp);
                        count += 1;
                        counts.put(temp,count);
                        lastInd.put(temp,j);
                    }
                }else {
                    counts.put(temp,1);
                    lastInd.put(temp,j);
                }
            }
            int max = -1;
            int result = 0;
            for (Map.Entry<Integer,Integer> entry : counts.entrySet()) {
                int value = entry.getValue();
                if (value > max) {
                    max = value;
                    result = entry.getKey();
                }
            }
            in.close();
            System.out.println(result);
        }
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CODEWARS {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 6, 4, 1, 2, 3, 2, 1},
                {3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3},
                {3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1},
                {2, 1, 3, 1, 2, 2, 2, 2, 1},
                {2, 1, 3, 1, 2, 2, 2, 2}
        };
        for (int[] arr : array) {
            Map<String, List<Integer>> result = getPeaks(arr);
            List<Integer> pos = result.get("pos");
            List<Integer> peakValues = result.get("peaks");
            System.out.println("pos: " + pos);
            System.out.println("peaks: " + peakValues);
            System.out.println();
        }
    }
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> positions = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();
        int position = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                position = i;
            } else if (arr[i] < arr[i - 1] && position != 0) {
                positions.add(position);
                peaks.add(arr[position]);
                position = 0;
            }
        }
        result.put("pos", positions);
        result.put("peaks", peaks);
        return result;
    }
}
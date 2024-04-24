import org.junit.jupiter.api.Test;

import java.util.*;

public class Leetcode495 {
    @Test
    public void LCtest(){
        int[] arr=new int[5];
        arr[0]=1;
        arr[1]=1;
        arr[2]=3;
        arr[3]=4;
        arr[4]=5;

        System.out.println(findPoisonedDuration(arr,5));
    }
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        List<Integer> list = Arrays.stream(timeSeries).boxed().toList();
        HashSet<Integer> set = new HashSet<>(list);
        list=set.stream().toList();
        boolean[] timeLine=new boolean[timeSeries[timeSeries.length-1]+duration+1];
        for (Integer integer : list) {
            timeLine[integer] = true;
        }
        for (int nowAt : list) {
            if (duration>0)
            {
                result++;
            }
            for (int j = 1; j < duration; j++) {
                if (timeLine[nowAt + j]) {
                    break;
                } else {
                    result++;
                }
            }
        }
        return result;
    }
}

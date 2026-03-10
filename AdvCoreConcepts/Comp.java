import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Comp{
    public static void main(String[] args) {
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if(a % 10 > b % 10) 
                    return 1;
                else   
                    return -1;
                
            }
        };

        List<Integer> nums = new ArrayList<>();

        nums.add(81);
        nums.add(73);
        nums.add(62);
        

        Collections.sort(nums, com);

        System.out.println(nums);
    }
}
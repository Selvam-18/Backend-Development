import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

class StreamEx{
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        Random ran = new Random();

        for(int i=0; i<1000; i++) {
            nums.add(ran.nextInt(25));
        }

        // System.out.println(nums);

        long startTime1 = System.currentTimeMillis();

        int result1 = nums.stream()
                        .map( i -> {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {

                            }
                            return i + 2;
                        } )
                        .reduce(0, (c, e) -> c + e);
        long endTime1 = System.currentTimeMillis();


        long startTime2 = System.currentTimeMillis();
        int result2 = nums.parallelStream()
                       .map( i -> {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e1) {
                             
                            }
                            return i + 2;
                        } )
                        .mapToInt(i -> i)
                        .sum();
        long endTime2 = System.currentTimeMillis();

        List<String> names = new ArrayList<>();
        names.add("Appe");
        names.add("Banana");
        String str = names.stream()
                                .filter(value -> value.contains("l"))
                                .findFirst()
                                .orElse("Not found");

        System.out.println(str);


        // System.out.println(result1 + " " + result2);
        // System.out.println("Stream " + (endTime1 - startTime1)+ "ms, Parallel Stream " + (endTime2-startTime2) + "ms");
        
    }
}
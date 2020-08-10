package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/1/27
 */
public class FindDuplication {

    private static boolean duplicate(int[] numbers, int length, int[] duplication){
        if (numbers == null || numbers.length != length || numbers.length < 1)
            return false;
        int[] data = new int[length];
        for (int x : numbers){
            if (data[x] == 1){
                duplication[0] = x;
                return true;
            } else {
                data[x] = 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,3,1,0,2,5,3};
        int[] duplication = new int[1];
        System.out.println(duplicate(numbers,numbers.length,duplication));
        System.out.println(duplication[0]);
    }
}

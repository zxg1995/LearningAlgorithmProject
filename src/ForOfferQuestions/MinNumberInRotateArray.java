package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/2/6
 */
public class MinNumberInRotateArray {

    private static int minNumberInRotateArray1(int[] array){
        if (array == null || array.length < 1)
            return 0;
        for (int x : array){
            if (x < array[0])
                return x;
        }
        return array[0];
    }

    //二分查找法
    private static int minNumberInRotateArray(int[] array){
        if (array == null || array.length < 1)
            return 0;
        return BSNumber(array, 0, array.length-1);
    }

    private static int BSNumber(int[] array, int l, int r) {
        if (l == r)
            return array[l];
        int mid = l + (r - l)/2;
        int min;
        if (array[mid] > array[l])
            min = BSNumber(array, mid + 1, r);
        else if (array[mid] < array[l])
            min = BSNumber(array, l, mid);
        else {
            min = Math.min(BSNumber(array, l, mid), BSNumber(array, mid + 1, r));
        }
        return Math.min(array[l], min);
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,3,3,3,3,1};
        System.out.println(minNumberInRotateArray(a));
    }
}

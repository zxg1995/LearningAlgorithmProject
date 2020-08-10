package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/2/19
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfKInSortedArray {

    private static int getNumberOfK(int[] array , int k){
        if (array == null || array.length == 0)
            return 0;
        int index = findK(array, 0, array.length - 1, k);
        if (index == -1)
            return 0;
        int count = 0;
        int tmp = index - 1;
        while (index < array.length && array[index++] == k)
            count ++;
        while (tmp >= 0 && array[tmp--] == k)
            count ++;
        return count;
    }

    private static int findK(int[] array, int i, int j, int k) {
        if (i == j){
            if (array[i] == k)
                return i;
            else
                return -1;
        }
        int mid = i + (j - i) / 2;
        if (array[mid] == k)
            return mid;
        else if (array[mid] < k)
            return findK(array, mid + 1, j, k);
        else
            return findK(array, i, mid - 1, k);
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,0,1,2,2,2,4,4,5,7,7,7,7,9,9,10};
        System.out.println(getNumberOfK(a, 1));
    }
}

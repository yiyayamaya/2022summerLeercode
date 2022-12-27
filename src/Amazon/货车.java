package Amazon;

import java.util.HashSet;
import java.util.Set;

public class 货车 {
    public static void main(String[] args) {
        int[] parcels = new int[]{2, 3, 6, 10, 11};
        int k = 9;
        int result = getShipment(parcels, k);
        long result2 = minimalKSum(new int[]{1, 4, 25, 10, 25}, 2);
        System.out.println(result);

        int a= (int) Math.floor(1.8);
        System.out.println(a);
    }


    public static int getShipment2(int[] parcels, int k) {
        Set<Integer> set = new HashSet<>();
        for (int parcel : parcels) {
            set.add(parcel);
        }
        int cost = 1;
        int sum = 0;
        while (set.size() < k) {
            if (set.contains(cost)) {
                cost++;
                continue;
            }
            sum += cost;
            set.add(cost);
            cost++;
        }
        return sum;
    }


    public static long minimalKSum(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums)
            hashSet.add(num);

        int i = 1;
        int sum = 0;
        while (hashSet.size() < (nums.length + k)) {
            if (hashSet.contains(i)) {
                i++;
            } else {
                System.out.println(i);
                sum += i;
                hashSet.add(i);
                i++;
            }
        }

        return sum;
    }

    private static int getShipment(int[] parcels, int k) {
        Set<Integer> set = new HashSet<>();
        for (int parcel : parcels) {
            set.add(parcel);
        }
        int cost = 1;
        int sum = 0;
        while (set.size() < k) {
            if (set.contains(cost)) {
                cost++;
            } else {
                sum += cost;
                set.add(cost);
                cost++;
            }
        }
        return sum;
    }
}

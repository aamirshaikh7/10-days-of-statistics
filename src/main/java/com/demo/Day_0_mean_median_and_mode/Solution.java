package com.demo.Day_0_mean_median_and_mode;

import java.text.DecimalFormat;
import java.util.*;

public class Solution {
    static ArrayList<Integer> arr = new ArrayList<>();

    static float mean() {
        float total = 0;
        int size = arr.size();

        for (Integer e : arr) {
            total += e;
        }

        return total / size;
    }

    static float median() {
        if (arr.size() % 2 == 0) {
            int mid = arr.size() / 2;

            float mid1 = arr.get(mid - 1);
            float mid2 = arr.get(mid);

            return (mid1 + mid2) / 2;
        }

        return arr.get(arr.size() / 2);
    }

    static int mode() {
        HashMap<Integer, Integer> occurrences = new LinkedHashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            int count = 1, current = arr.get(i);

            for (int j = i + 1; j < arr.size(); j++) {
                if (current == arr.get(j)) {
                    count++;
                }
            }

            // occurrences.get(count) == null
            occurrences.putIfAbsent(count, current);
        }

        return occurrences.get(Collections.max(occurrences.keySet(), null));
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        while (N-- > 0) {
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        System.out.println(decimalFormat.format(mean()));
        System.out.println(decimalFormat.format(median()));
        System.out.println(mode());


        sc.close();
    }
}
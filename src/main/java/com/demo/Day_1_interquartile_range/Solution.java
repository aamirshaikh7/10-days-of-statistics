package com.demo.Day_1_interquartile_range;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the 'interQuartile' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY values
     *  2. INTEGER_ARRAY freqs
     */

    public static void interQuartile(List<Integer> values, List<Integer> freqs) {
        // Print your answer to 1 decimal place within this function

        List<Integer> S = new ArrayList<>();

        for (int i = 0; i < values.size(); i++) {
            int freq = freqs.get(i);

            for (int j = 0; j < freq; j++) {
                S.add(values.get(i));
            }
        }

        Collections.sort(S);

        int size = S.size();
        int mid = size / 2;

        int q1;
        int q3;

        if (size % 2 == 0) {
            if (mid % 2 == 0) {
                q1 = (S.get((mid / 2) - 1) + S.get(mid / 2)) / 2;
                q3 = (S.get((mid / 2) + mid) + S.get(((mid / 2) + mid) - 1)) / 2;
            } else {
                q1 = S.get(mid / 2);
                q3 = S.get(((size - mid) / 2) + mid);
            }
        } else {
            if (mid % 2 == 0) {
                q1 = (S.get((mid / 2) - 1) + S.get(mid / 2)) / 2;
                q3 = (S.get(mid + (mid / 2)) + S.get(((mid / 2) + mid) + 1)) / 2;
            } else {
                q1 = S.get(mid / 2);
                q3 = S.get(((size - mid) / 2) + mid);
            }
        }

        System.out.printf("%.1f%n", (double) q3 - q1);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> val = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        List<Integer> freq = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        Result.interQuartile(val, freq);

        bufferedReader.close();
    }
}
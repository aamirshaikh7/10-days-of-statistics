package com.demo.Day_1_standard_deviation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'stdDev' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void stdDev(List<Integer> arr) {
        // Print your answers to 1 decimal place within this function

        float total = 0, diff = 0;

        for (Integer value : arr) {
            total += value;
        }

        float mean = total / arr.size();

        for (Integer value : arr) {
            diff += Math.pow(value - mean, 2);
        }

        System.out.printf("%.1f%n", Math.sqrt(diff / arr.size()));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> vals = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        Result.stdDev(vals);

        bufferedReader.close();
    }
}
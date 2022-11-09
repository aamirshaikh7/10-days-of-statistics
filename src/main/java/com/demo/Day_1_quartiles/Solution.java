package com.demo.Day_1_quartiles;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'quartiles' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> quartiles(List<Integer> arr) {
        // Write your code here

        Collections.sort(arr);

        List<Integer> res = new ArrayList<>();

        int mid = arr.size() / 2;
        int firstQ = mid / 2;
        int thirdQ = ((arr.size() - mid) / 2) + mid;

        int firstQAvg = (arr.get(firstQ) + arr.get(firstQ - 1)) / 2;
        int secondQAvg = (arr.get(mid) + arr.get(mid - 1)) / 2;

        if (arr.size() % 2 == 0) {
            if (mid % 2 == 0) {
                int thirdQAvg = (arr.get(thirdQ) + arr.get(thirdQ - 1)) / 2;

                res.add(firstQAvg);
                res.add(secondQAvg);
                res.add(thirdQAvg);
            } else {
                res.add(arr.get(firstQ));
                res.add(secondQAvg);
                res.add(arr.get(thirdQ));
            }
        } else {
            if (mid % 2 == 0) {
                int thirdQAvg = (arr.get(thirdQ) + arr.get(thirdQ + 1)) / 2;

                res.add(firstQAvg);
                res.add(arr.get(mid));
                res.add(thirdQAvg);
            } else {
                res.add(arr.get(firstQ));
                res.add(arr.get(mid));
                res.add(arr.get(thirdQ));
            }
        }

        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        List<Integer> res = Result.quartiles(data);

        bufferedWriter.write(res.stream().map(Object::toString).collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
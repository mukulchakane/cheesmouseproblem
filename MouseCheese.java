package com.tech2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mukul.Chakane
 */
public class MouseCheese {

    public static void main(String[] args) throws IOException {

        int tcs = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no of TC's:");
        tcs = Integer.parseInt(br.readLine());
        List<Integer> maxCheeseEaten = new ArrayList<>();
        for (int i = 0; i < tcs; i++) {
            System.out.println("Enter the No of cheese blocks:");
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            System.out.println("Enter weight of each cheese in [KG] separated by 1 space");
            String line = br.readLine(); // to read multiple integers line
            String[] strs = line.trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(strs[j]);
            }
            maxCheeseEaten.add(maxCheeseEatenByMouse(n, arr));
        }
        maxCheeseEaten.forEach(System.out::println);
    }

    private static int maxCheeseEatenByMouse(int n, int[] arr) {
        int in = arr[0];
        int out = 0;
        int newOut;

        for (int i = 1; i < n; i++) {
            newOut = Math.max(in, out);
            in = out + arr[i];
            out = newOut;
        }
        return Math.max(in, out);
    }
}
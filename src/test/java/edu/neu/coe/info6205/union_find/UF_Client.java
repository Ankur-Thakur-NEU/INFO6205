package edu.neu.coe.info6205.union_find;

import java.util.Scanner;

public class UF_Client {
    public static int count(int totalCount) {
        int connections = 0;
        int[] randomNumbers = new int[totalCount];
        UF_HWQUPC union = new UF_HWQUPC(totalCount, true);
        for (int i = 0; i <= totalCount - 1; i++) {
            randomNumbers[i] = i;
            if (i != 0) {
                boolean isConnected = union.connected(randomNumbers[i], randomNumbers[i - 1]);
                if (!isConnected) {
                    union.union(randomNumbers[i], randomNumbers[i - 1]);
                    ++connections;
                }
            }
        }
        return connections;
    }

    public static void main(String args[]) {
        int count = 15;
        Scanner in = new Scanner(System.in);
        String input =  in.nextLine();
        int totalCount = Integer.parseInt(input);
        while (count != 0)  {
            int connection = count(totalCount);
            System.out.println("Total inputs: " + totalCount + ", Total Connection(m)" + connection);
            count--;
            totalCount*=2;
        }
    }
}

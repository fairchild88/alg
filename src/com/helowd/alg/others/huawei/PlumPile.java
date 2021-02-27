package com.helowd.alg.others.huawei;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
30
186 13 322 264 328 110 120 73 20 35 240 97 150 221 284 324 46 219 239 284 128 251 298 319 304 36 144 236 163 122 
98
243 277 172 222 127 70 34 1 261 277 10 151 29 159 318 16 50 41 309 315 303 47 5 257 246 32 105 96 199 304 194 7 218 158 239 244 58 9 250 326 210 194 312 281 244 79 170 316 64 291 139 178 35 299 322 21 238 54 102 105 75 17 187 55 290 115 165 51 155 107 136 112 270 164 15 26 142 158 312 31 165 262 214 1 67 213 88 283 198 95 37 317 43 301 269 25 228 321
 */
public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        List<LinkedList<Integer>> input = new LinkedList<>();
        while(scanner.hasNext()) {
            int count = scanner.nextInt();
            LinkedList<Integer> inputList = new LinkedList<>();
            while(count > 0) {
                inputList.add(scanner.nextInt());
                count--;
            }
            input.add(inputList);
        }

        for(LinkedList<Integer> inputList : input) {
            List<Integer> dp = new ArrayList<>(inputList.size());
            for(int i = 0; i < inputList.size(); i++) {
                dp.add(1);
            }
            int maxSteps = 1;
            for(int i = 0; i < inputList.size() - 1; i++) {
                int curHeight = inputList.get(i);
                int curSteps = dp.get(i);
                for(int j = i + 1; j < inputList.size(); j++) {
                    if(inputList.get(j) > curHeight) {
                       if(dp.get(j) < curSteps + 1) {
                            dp.set(j, curSteps + 1);
                       }
                       maxSteps = Math.max(maxSteps, curSteps + 1);
                    }
                }
            }
            System.out.println(maxSteps);
        }
    }
}

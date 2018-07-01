package org.litespring.util;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author zhaogd
 * @Date 2018/7/1
 */
public class PrimesUtil {

    /**
     * 获取小于指定值的素数集合
     *
     * @param max 执行自然数
     * @return 素数集合
     */
    public static int[] getPrimes(int max) {
        if (max <= 2) {
            return new int[]{};
        }

        int[] primes = new int[max];
        int count = 0;
        for (int num = 2; num < max; num++) {
            if (isPrimes(num)) {
                primes[count++] = num;
            }
        }
        primes = Arrays.copyOf(primes, count);
        return primes;
    }

    /**
     * 判断一个数是否为素数
     *
     * @param num 数字
     * @return 是否为素数
     */
    private static boolean isPrimes(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

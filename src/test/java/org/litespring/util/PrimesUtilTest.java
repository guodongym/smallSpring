package org.litespring.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author zhaogd
 * @Date 2018/7/1
 */
public class PrimesUtilTest {

    @Test
    public void getPrimesForEmptyResult() {
        int[] expected = {};

        assertArrayEquals(expected, PrimesUtil.getPrimes(-1));
        assertArrayEquals(expected, PrimesUtil.getPrimes(0));
        assertArrayEquals(expected, PrimesUtil.getPrimes(2));
    }

    @Test
    public void getPrimes() {
        assertArrayEquals(new int[]{2, 3, 5, 7, 11}, PrimesUtil.getPrimes(12));
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13, 17, 19}, PrimesUtil.getPrimes(20));
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29}, PrimesUtil.getPrimes(30));
    }
}
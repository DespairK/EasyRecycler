package com.zjk.despairk.data;

import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * com.zjk.despairk.data
 * DespairK
 *
 * @author ZJK
 *         created at 2017/2/16 16:28
 *         功能:
 */
public class FibonacciData {
    BigInteger[][] f = new BigInteger[][]{{BigInteger.valueOf(0), BigInteger.valueOf(1)}, {BigInteger.valueOf(1), BigInteger.valueOf(1)}};

    public String getNthNumber1(int n) {
        if (n == 0)
            return "0";
        if (n == 1)
            return "1";
        f = pow(n - 1, f);

        return getData(f[1][1]);
    }

    public String getData(BigInteger bigInteger) {
        String style = "0.00E000";
        DecimalFormat df = new DecimalFormat();
        df.applyPattern(style);
        Double max = Math.pow(10, 10);
        if (bigInteger.compareTo(BigInteger.valueOf(max.intValue())) < 0) {
            return bigInteger.toString();
        } else {
            return df.format(bigInteger);
        }
    }

    private BigInteger[][] pow(int n, BigInteger[][] f) {
        if (n == 1)
            return f;

        if (n == 2) {
            return fun(f, f);
        }
        if (n % 2 == 0) {//偶数
            f = pow(n / 2, f);
            return fun(f, f);
        } else {
            return fun(pow(n / 2, f), pow(n / 2 + 1, f));
        }
    }

    private BigInteger[][] fun(BigInteger[][] f, BigInteger[][] m) {
        BigInteger[][] temp = new BigInteger[2][2];
        temp[0][0] = f[0][0].multiply(m[0][0]).add(f[0][1].multiply(m[1][0]));
        temp[0][1] = f[0][0].multiply(m[0][1]).add(f[0][1].multiply(m[1][1]));
        temp[1][0] = f[1][0].multiply(m[0][0]).add(f[1][1].multiply(m[1][0]));
        temp[1][1] = f[1][0].multiply(m[0][1]).add(f[1][1].multiply(m[1][1]));
        return temp;
    }
}

package com.zjk.despairk.bean;

import java.math.BigInteger;

/**
 * com.zjk.despairk.bean
 * DespairK
 *
 * @author ZJK
 *         created at 2017/2/13 17:36
 *         功能:
 */
public class Title {
    private String title;
    private BigInteger bigInteger;

    public BigInteger getBigInteger() {
        return bigInteger;
    }

    public Title(BigInteger bigInteger) {

        this.bigInteger = bigInteger;
    }

    public String getTitle() {
        return title;
    }

    public Title(String title) {

        this.title = title;
    }
}

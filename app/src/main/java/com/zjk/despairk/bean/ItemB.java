package com.zjk.despairk.bean;

import java.util.List;

/**
 * com.zjk.despairk.bean
 * DespairK
 *
 * @author ZJK
 *         created at 2017/2/13 17:38
 *         功能:
 */
public class ItemB {
    private List<String> listData;

    public List<String> getListData() {
        return listData;
    }

    public ItemB(List<String> listData) {

        this.listData = listData;
    }
}

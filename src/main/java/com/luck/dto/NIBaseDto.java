package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/30 0030 15:08
 */
public class NIBaseDto {
    /**
     * 插入mongodb表名后缀；例如：StayInArea_1709中的 （1709这个后缀）
     */
    private String tableSuffix;
    /**
     * 插入mongodb中数据多少
     */
    private int insertSum;

    @Override
    public String toString() {
        return "NIBaseDto{" +
                "tableSuffix='" + tableSuffix + '\'' +
                ", insertSum=" + insertSum +
                '}';
    }

    public String getTableSuffix() {
        return tableSuffix;
    }

    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

    public int getInsertSum() {
        return insertSum;
    }

    public void setInsertSum(int insertSum) {
        this.insertSum = insertSum;
    }
}

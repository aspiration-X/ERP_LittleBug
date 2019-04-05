package com.littlebug.util;

import java.util.List;

/**
 * @Author Darling
 * @Description 用于对分页数据的包裹
 * @Date Created in 2019/4/5 13:34
 * @Modified By
 */
public class PageWraper<T> {

    private int total;

    private List<T> rows;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageWraper{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}

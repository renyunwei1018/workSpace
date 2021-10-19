package cn.yunwei.domain;

import java.util.List;

public class PageBean<T> {
    //1.current page
    private int currentPage;
    //2.page rows
    private int rows;
    //3.totalPage
    private int totalPage;
    //4.page data
    private List<T> list;
    //5.total count
    private int totalCount;

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", rows=" + rows +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", totalCount=" + totalCount +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

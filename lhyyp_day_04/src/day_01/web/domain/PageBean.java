package day_01.web.domain;

import java.util.List;

public class PageBean<t> {
    private int totalCount;  // 总条数
    private int totalPage;   // 总页数
    private List<t>  list;   //当前页列表
    private int currentPage; // 当前页码
    private int row;           //条数
    public PageBean() {
    }

    public PageBean(int totalCount, int totalPage, List<t> list, int currentPage, int row) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
        this.currentPage = currentPage;
        this.row = row;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<t> getList() {
        return list;
    }

    public void setList(List<t> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", row=" + row +
                '}';
    }
}

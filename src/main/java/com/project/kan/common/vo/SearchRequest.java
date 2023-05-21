package com.project.kan.common.vo;

import java.util.List;

public class SearchRequest {
    private int start;
    private int numberOfRows;
    private List sort;
    private List filters;
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getNumberOfRows() {
        return numberOfRows;
    }
    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }
    public List getSort() {
        return sort;
    }
    public void setSort(List sort) {
        this.sort = sort;
    }
    public List getFilters() {
        return filters;
    }
    public void setFilters(List filters) {
        this.filters = filters;
    }

}

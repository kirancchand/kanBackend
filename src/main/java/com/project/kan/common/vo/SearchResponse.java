package com.project.kan.common.vo;

import java.util.List;

public class SearchResponse {
    private int totalcount;
    private List result;
    public int getTotalcount() {
        return totalcount;
    }
    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }
    public List getResult() {
        return result;
    }
    public void setResult(List result) {
        this.result = result;
    }

}

package com.jiawa.wiki.req;

public class PageReq {
    private int page;

    private int size;


    public int getPage() {
        return page;
    }


    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    //toString主要是用来打印日志
    @Override
    public String toString() {
        return "PageReq{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
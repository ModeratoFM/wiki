package com.jiawa.wiki.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

//父类
public class PageReq {

    @NotNull (message = "页码不能为空")
    private int page;

    @NotNull(message = "每条页数不能为空")
    @Max(value=1000,message = "[每页条数]不能超过1000")
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
package com.zyifly.common.data;

/**
 * Created by zhaoyifei on 16/7/12.
 */
public class PageInfo {

    private int totalpage = 0;
    private int totalsize = 0;
    private int pagesize = 10;
    private int pagenum = 0;

    public PageInfo(int pagesize) {
        if(pagesize > 0)
        this.pagesize = pagesize;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(int totalsize) {
        this.totalsize = totalsize;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getStart(){
        return this.pagesize * (this.getPagenum() - 1);
    }

    public int getEnd(){
        return this.pagesize * this.getPagenum();
    }
}

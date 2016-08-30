package com.sidemenufragment.model;

/**
 * Created by Ramesh on 8/30/16.
 */
public class ItemSideMenu {
    private int imgid;
    private String title;

    public ItemSideMenu(int imgid, String title) {
        this.imgid = imgid;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}

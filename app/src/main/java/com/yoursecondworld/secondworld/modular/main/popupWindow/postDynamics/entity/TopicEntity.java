package com.yoursecondworld.secondworld.modular.main.popupWindow.postDynamics.entity;

/**
 * Created by cxj on 2016/7/22.
 * 话题的实体对象
 */
public class TopicEntity {

    /**
     * 图片的资源地址
     */
    private int imageRsd;

    /**
     * 话题的名称
     */
    private String name;

    private int nameColor;

    public TopicEntity(int imageRsd, String name, int nameColor) {
        this.imageRsd = imageRsd;
        this.name = name;
        this.nameColor = nameColor;
    }

    public int getImageRsd() {
        return imageRsd;
    }

    public void setImageRsd(int imageRsd) {
        this.imageRsd = imageRsd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNameColor() {
        return nameColor;
    }

    public void setNameColor(int nameColor) {
        this.nameColor = nameColor;
    }
}

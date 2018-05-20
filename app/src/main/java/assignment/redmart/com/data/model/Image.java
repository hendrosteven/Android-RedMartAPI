package assignment.redmart.com.data.model;

import assignment.redmart.com.config.PathConfig;

public class Image {
    private int h;
    private int w;
    private String name;
    private int position;

    public Image(){}


    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public String getName() {
        return PathConfig.IMG_URL+name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

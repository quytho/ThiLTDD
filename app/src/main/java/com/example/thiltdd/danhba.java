package com.example.thiltdd;

public class danhba {
    int images,id;
    String namedh;

    public danhba(int images, int id, String namedh) {
        this.images = images;
        this.id = id;
        this.namedh = namedh;
    }

    public danhba() {
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamedh() {
        return namedh;
    }

    public void setNamedh(String namedh) {
        this.namedh = namedh;
    }
}

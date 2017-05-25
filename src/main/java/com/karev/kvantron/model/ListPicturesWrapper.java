package com.karev.kvantron.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Comparator;
import java.util.List;

@XmlRootElement(name = "pictures")
public class ListPicturesWrapper {
    private List<Picture> pictures;

    @XmlElement(name = "picture")
    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public void sort() {
        pictures.sort((o1, o2) -> (int)((o1.getHeight() - o2.getHeight()) * 10.0));
    }
}

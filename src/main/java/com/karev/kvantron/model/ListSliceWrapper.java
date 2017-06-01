package com.karev.kvantron.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "slices")
public class ListSliceWrapper {
    private int index = 0;
    private List<Slice> slices;

    @XmlElement(name = "slice")
    public List<Slice> getSlices() {
        return slices;
    }

    public void setSlices(List<Slice> slices) {
        this.slices = slices;
        index = 0;
    }

    public void getByteArray(int index) {
        slices.get(index).getData().toByteArray();
    }
//    public boolean hasNext() {
//        return index + 1 > slices.size();
//    }
//
//    public byte[] nextByteArray() {
//        return slices.get(index++).getData().toByteArray();
//    }
//
//    public boolean isNextEmty
}

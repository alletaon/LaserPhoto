package com.karev.kvantron.model;

import com.karev.kvantron.util.BitSetAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.BitSet;

public class Slice {
    private int size;
    private BitSet data;

    public Slice() {
        this(0);
    }

    public Slice(int nBits) {
        size = nBits;
        data = new BitSet(size);
    }

    @XmlJavaTypeAdapter(BitSetAdapter.class)
    public BitSet getData() {
        return data;
    }

    public void setData(BitSet data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        BitSet tmp = new BitSet(size);
        tmp.or(data);
        data = tmp;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Slice{" +
                "size=" + data.size() +
                " data=" + data +
                '}';
    }
}

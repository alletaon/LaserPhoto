package com.karev.kvantron.util;

import com.karev.kvantron.model.Slice;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.BitSet;

public class BitSetAdapter extends XmlAdapter<String, BitSet> {

    /**
     * Convert a value type to a bound type.
     *
     * @param v The value to be converted. Can be null.
     * @throws Exception if there's an error during the conversion. The caller is responsible for
     *                   reporting the error to the user through {@link ValidationEventHandler}.
     */
    @Override
    public BitSet unmarshal(String v) throws Exception {
        BitSet result = new BitSet();
        for (String s : v.replaceAll("[{}]", "").split(", ")) {
            result.set(Integer.parseInt(s));
        }
        return result;
    }

    /**
     * Convert a bound type to a value type.
     *
     * @param v The value to be convereted. Can be null.
     * @throws Exception if there's an error during the conversion. The caller is responsible for
     *                   reporting the error to the user through {@link ValidationEventHandler}.
     */
    @Override
    public String marshal(BitSet v) throws Exception {
        return v.toString();
    }
}

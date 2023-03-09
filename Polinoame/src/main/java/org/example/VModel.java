package org.example;

import java.math.BigInteger;

public class VModel {
    static final String INITIAL_VALUE = "-";
    private String m_total;
    VModel(){ reset(); }
    public void reset(){
        m_total = new String(INITIAL_VALUE);
    }
    public void setValue(String value) {
        m_total = new String(value);
    }
    public String getValue() {
        return m_total;
    }
}

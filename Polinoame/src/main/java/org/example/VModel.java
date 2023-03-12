package org.example;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class VModel {
    static String INITIAL_VALUE = "-";
    private String m_total;

    public HashMap<Integer, Integer> total;

    VModel() {
        reset();
    }

    public void reset() {
        m_total = new String(INITIAL_VALUE);
    }

    public String getValue() {
        return m_total.toString();
    }

    public void addTo(Polinoame p1, Polinoame p2) {
        total = new HashMap(p1.add(p1, p2));
        m_total = "";
        for (Map.Entry<Integer, Integer> entry : total.entrySet()) {
            int pow = entry.getKey();
            int coef = entry.getValue();
            if (pow > 0) {
                if (pow == 1) {
                    if(coef == 0){
                        m_total += " ";
                    }
                    else {
                        m_total += "+" + coef + "x";
                    }
                } else {
                    if(coef == 0){
                        m_total += " ";
                    }
                    else {
                        m_total += "+" + coef + "x^" + pow;
                    }
                }
            } else if (pow == 0) {
                if(coef>0) {
                    m_total += "+" + coef;
                }
                else{
                    m_total += coef;
                }

            }


        }
    }

    public void subTo(Polinoame p1, Polinoame p2) {
        total = new HashMap(p1.sub(p1, p2));
        m_total = "";
        for (Map.Entry<Integer, Integer> entry : total.entrySet()) {
            int pow = entry.getKey();
            int coef = entry.getValue();
            if (pow > 0) {
                if (pow == 1) {
                    m_total += "+" + coef + "x" ;
                } else
                    m_total += "+" + coef + "x^" + pow;
            } else if (pow == 0) {

                    m_total += "+" + coef;


            }
        }
    }
}


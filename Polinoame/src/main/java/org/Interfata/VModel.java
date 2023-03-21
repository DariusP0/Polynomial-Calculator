package org.Interfata;

import Polinom.Polinoame;

import java.util.HashMap;
import java.util.Map;

public class VModel {
    static String INITIAL_VALUE = "-";
    private String m_total;

    public HashMap<Double, Double> total;

    VModel() {
        reset();
    }

    public void reset() {
        m_total = new String(INITIAL_VALUE);
    }

    public String getValue() {
        return m_total.toString();
    }
    public String faString(HashMap<Double,Double> total) {
        m_total = "";
        for (Map.Entry<Double, Double> entry : total.entrySet()) {
            Double pow = entry.getKey();
            Double coef = entry.getValue();
            if(coef!=0){if (pow > 0) {
                if (pow == 1) {
                    if (!m_total.isEmpty()) {
                        if (coef > 0)
                            m_total += "+" + coef + "x";
                        if (coef < 0)
                            m_total += coef + "x";
                    } else m_total += coef + "x";
                } else {
                    if (!m_total.isEmpty()) {
                        if (coef > 0)
                            m_total += "+" + coef + "x^" + pow;
                        else
                            m_total += coef + "x^" + pow;
                    } else {
                        m_total += coef + "x^" + pow;
                    }
                }
            } else if (pow == 0) {
                if (!m_total.isEmpty()) {
                    if (coef > 0)
                        m_total += "+" + coef;
                    else {
                        m_total += coef;
                    }
                } else {
                    m_total += coef;
                }

            }
        }
        }
        return m_total;
    }
    public HashMap<Double, Double>  addTo(Polinoame p1, Polinoame p2) {
        total = new HashMap(p1.add(p1, p2));
        return total;
        }

    public HashMap<Double, Double> subTo(Polinoame p1, Polinoame p2) {
        total = new HashMap(p1.sub(p1, p2));
        return total;
    }
    public HashMap<Double, Double> derTo(Polinoame p1) {
        total = new HashMap(p1.derivative(p1));
        return total;
    }
    public HashMap<Double, Double>  intTo(Polinoame p1) {
        total = new HashMap(p1.integral(p1));
        return total;
    }

    public HashMap<Double, Double> mulTo(Polinoame p1, Polinoame p2) {
        total = new HashMap(p1.multiply(p1, p2));
        return total;
    }

}


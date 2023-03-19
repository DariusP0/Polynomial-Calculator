package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinoame {

    public String Rezultat;
    public Double pow;
    public Double coef;
    private String polinom;
    private HashMap<Double, Double> putereCoeficient;

    public Polinoame(String polinom2) {
        this.polinom = polinom2;
        putereCoeficient = new HashMap<>();
        Pattern p = Pattern.compile("(-?\\d+)[xX]\\^(-?\\d+)|[xX]\\^(-?\\d+)|(-?\\d+)[xX]|(-?\\d+)|(-?)[xX]\\^(-?\\d+)");
        Matcher m = p.matcher(polinom);
        while (m.find()) {

            if (m.group(1) != null && !m.group(1).isEmpty()) {
                coef = Double.parseDouble(m.group(1));
            }

            if (m.group(2) != null && !m.group(2).isEmpty()) {
                pow = Double.parseDouble(m.group(2));
            }

            if (m.group(3) != null && !m.group(3).isEmpty()) {
                pow = Double.parseDouble(m.group(3));
                coef = 1.0;
            }

            if (m.group(4) != null && !m.group(4).isEmpty()) {
                coef = Double.parseDouble(m.group(4));
                pow = 1.0;
            }
            if (m.group(5) != null && !m.group(5).isEmpty()) {
                coef = Double.parseDouble(m.group(5));
                pow = 0.0;
            }
            if (m.group(6) != null && !m.group(6).isEmpty()) {
                coef = -1.0;
                pow = Double.parseDouble(m.group(7));
            }
            putereCoeficient.put(pow, coef);
        }
    }


    public HashMap<Double, Double> getHash() {
        return putereCoeficient;
    }

    public String getString() {
        return polinom;
    }

    public HashMap add(Polinoame p, Polinoame p2) {
        HashMap<Double, Double> result = new HashMap<Double, Double>(p.getHash());
        for (Map.Entry<Double, Double> term : p2.getHash().entrySet()) {
            Double power = term.getKey();
            Double coefficient = term.getValue();
            if (result.containsKey(power)) {
                result.put(power, result.get(power) + coefficient);
            } else {
                result.put(power, coefficient);
            }
        }
        return result;
    }

    public HashMap sub(Polinoame p, Polinoame p2) {
        HashMap<Double, Double> result = new HashMap(p.getHash());
        for (Map.Entry<Double, Double> term : p2.getHash().entrySet()) {
            Double power = term.getKey();
            Double coefficient = term.getValue();
            if (result.containsKey(power)) {
                result.put(power, result.get(power) - coefficient);
            } else {
                result.put(power, -coefficient);
            }
        }
        return result;
    }

    public HashMap derivative(Polinoame p) {
        HashMap<Double, Double> result = new HashMap();
        for (Map.Entry<Double, Double> term : p.getHash().entrySet()) {
            Double power = term.getKey();
            Double coefficient = term.getValue();
            if(power-1>=0) {
                result.put(power - 1, coefficient * power);
            }
            }

            return result;
    }

    public HashMap integral(Polinoame p) {
        HashMap<Double, Double> result = new HashMap();
        for (Map.Entry<Double, Double> term : p.getHash().entrySet()) {
            Double power = term.getKey();
            Double coefficient = term.getValue();

                result.put(power + 1, coefficient /(power+1));
        }

        return result;
    }

    public HashMap multiply(Polinoame p, Polinoame p2) {
        HashMap<Double, Double> result = new HashMap<Double, Double>();
        for (Map.Entry<Double, Double> term : p.getHash().entrySet()) {
            for (Map.Entry<Double, Double> term2 : p2.getHash().entrySet()) {
                Double power = term.getKey() + term2.getKey();
                Double coefficient = term.getValue() * term2.getValue();
                if (result.containsKey(power)) {
                    result.put(power, result.get(power) + coefficient);
                } else {
                    result.put(power, coefficient);
                }
            }
        }
        return result;
    }
}

 /*   public Double getDegree() {
        return degree;
    }

    public Double[] getCoefficients() {
        return coefficients;
    }

    public Double evaluate(Double x) {
        Double result = 0;
        for (Double i = degree; i >= 0; i--) {
            result = result * x + coefficients[i];
        }
        return result;
    }

    public Polynomial add(Polynomial other) {
        Double maxDegree = Math.max(degree, other.degree);
        Double[] resultCoefficients = new Double[maxDegree + 1];
        for (Double i = 0; i <= maxDegree; i++) {
            Double coefficient1 = (i <= degree) ? coefficients[i] : 0;
            Double coefficient2 = (i <= other.degree) ? other.coefficients[i] : 0;
            resultCoefficients[i] = coefficient1 + coefficient2;
        }
        return new Polynomial(maxDegree, resultCoefficients);
    }

    public Polynomial multiply(Polynomial other) {
        Double maxDegree = degree + other.degree;
        Double[] resultCoefficients = new Double[maxDegree + 1];
        for (Double i = 0; i <= degree; i++) {
            for (Double j = 0; j <= other.degree; j++) {
                resultCoefficients[i + j] += coefficients[i] * other.coefficients[j];
            }
        }
        return new Polynomial(maxDegree, resultCoefficients);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Double i = degree; i >= 0; i--) {
            if (coefficients[i] == 0) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append(" + ");
            }
            sb.append(coefficients[i]);
            if (i > 0) {
                sb.append("x^").append(i);
            }
        }
        return sb.toString();
    }
}

    public Polynomial multiply(Polynomial other) {
        Double maxDegree = degree + other.degree;
        Double[] resultCoefficients = new Double[maxDegree + 1];
        Double i = 0;
        for (Double coefficient1 : coefficients) {
            Double j = 0;
            for (Double coefficient2 : other.coefficients) {
                resultCoefficients[i + j] += coefficient1 * coefficient2;
                j++;
            }
            i++;
        }
        return new Polynomial(maxDegree, resultCoefficients);
    }

    Regex polinoame java*/
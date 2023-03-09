package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinoame {


    public int pow;
    public int coef;
    private String polinom;
    private HashMap<Integer, Integer> putereCoeficient;

    public Polinoame(String polinom2) {
        this.polinom = polinom2;
        putereCoeficient = new HashMap<>();
        Pattern p = Pattern.compile("(-?\\d+)[xX]\\^(-?\\d+)|[xX]\\^(-?\\d+)|(-?\\d+)[xX]|(-?\\d+)");
        Matcher m = p.matcher(polinom);
        while (m.find()) {

            if (m.group(1) != null && !m.group(1).isEmpty()) {
                coef = Integer.parseInt(m.group(1));

            }

            if (m.group(2) != null && !m.group(2).isEmpty()) {
                pow = Integer.parseInt(m.group(2));
            }

            if (m.group(3) != null && !m.group(3).isEmpty()) {
                pow = Integer.parseInt(m.group(3));
                coef = 1;
            }

            if (m.group(4) != null && !m.group(4).isEmpty()) {
                coef = Integer.parseInt(m.group(4));
                pow = 1;
            }
            if (m.group(5) != null && !m.group(5).isEmpty()) {
                coef = Integer.parseInt(m.group(5));
                pow = 0;
            }
            putereCoeficient.put(pow, coef);
        }
    }




    public HashMap<Integer, Integer> getHash() {
        return putereCoeficient;
    }


    public HashMap add(Polinoame p, Polinoame p2) {
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>(p.getHash());
        for (Map.Entry<Integer, Integer> term : p2.getHash().entrySet()) {
            int power = term.getKey();
            int coefficient = term.getValue();
            if (result.containsKey(power)) {
                result.put(power, result.get(power) + coefficient);
            } else {
                result.put(power, coefficient);
            }
        }
        return result;
    }
}
 /*   public int getDegree() {
        return degree;
    }

    public int[] getCoefficients() {
        return coefficients;
    }

    public int evaluate(int x) {
        int result = 0;
        for (int i = degree; i >= 0; i--) {
            result = result * x + coefficients[i];
        }
        return result;
    }

    public Polynomial add(Polynomial other) {
        int maxDegree = Math.max(degree, other.degree);
        int[] resultCoefficients = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            int coefficient1 = (i <= degree) ? coefficients[i] : 0;
            int coefficient2 = (i <= other.degree) ? other.coefficients[i] : 0;
            resultCoefficients[i] = coefficient1 + coefficient2;
        }
        return new Polynomial(maxDegree, resultCoefficients);
    }

    public Polynomial multiply(Polynomial other) {
        int maxDegree = degree + other.degree;
        int[] resultCoefficients = new int[maxDegree + 1];
        for (int i = 0; i <= degree; i++) {
            for (int j = 0; j <= other.degree; j++) {
                resultCoefficients[i + j] += coefficients[i] * other.coefficients[j];
            }
        }
        return new Polynomial(maxDegree, resultCoefficients);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
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
        int maxDegree = degree + other.degree;
        int[] resultCoefficients = new int[maxDegree + 1];
        int i = 0;
        for (int coefficient1 : coefficients) {
            int j = 0;
            for (int coefficient2 : other.coefficients) {
                resultCoefficients[i + j] += coefficient1 * coefficient2;
                j++;
            }
            i++;
        }
        return new Polynomial(maxDegree, resultCoefficients);
    }

    Regex polinoame java*/
package Polinom;

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
            putereCoeficient.put(pow, Math.round(coef * 100) / 100.0);
        }
    }


    public HashMap<Double, Double> getHash() {
        return putereCoeficient;
    }

    public String getString() {
        return polinom;
    }

    public HashMap<Double, Double> add(Polinoame p, Polinoame p2) {
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

    public HashMap<Double, Double> sub(Polinoame p, Polinoame p2) {
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

    public HashMap<Double, Double> derivative(Polinoame p) {
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

    public HashMap<Double, Double> integral(Polinoame p) {
        HashMap<Double, Double> result = new HashMap();
        for (Map.Entry<Double, Double> term : p.getHash().entrySet()) {
            Double power = term.getKey();
            Double coefficient = term.getValue();

                result.put(power + 1, coefficient /(power+1));
        }

        return result;
    }

    public HashMap<Double, Double> multiply(Polinoame p, Polinoame p2) {
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
    public HashMap<Double, Double> divide(Polinoame p, Polinoame p2) {
        HashMap<Double, Double> result = new HashMap<>();
        HashMap<Double, Double> remainder = new HashMap<>(p.getHash());

        if (p2.getHash().isEmpty()) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        while (!remainder.isEmpty() && remainder.keySet().iterator().next() >= p2.getHash().keySet().iterator().next()) {
            Double divPower = remainder.keySet().iterator().next() - p2.getHash().keySet().iterator().next();
            Double divCoef = remainder.get(remainder.keySet().iterator().next()) / p2.getHash().get(p2.getHash().keySet().iterator().next());
            result.put(divPower, divCoef);

            for (Map.Entry<Double, Double> term : p2.getHash().entrySet()) {
                Double power = term.getKey() + divPower;
                Double coefficient = term.getValue() * divCoef;
                if (remainder.containsKey(power)) {
                    remainder.put(power, remainder.get(power) - coefficient);
                } else {
                    remainder.put(power, -coefficient);
                }
                    remainder.remove(power);
            }

        }

        return result;
    }

}
   //Regex polinoame java//
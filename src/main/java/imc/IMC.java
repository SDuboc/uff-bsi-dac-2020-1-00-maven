package imc;

public class IMC {

    public static float calculaIMC(float peso, float altura) {
        return peso / (altura * altura);
    }

    public static String classificaIMC(float imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 24.9) {
            return "Peso normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else if (imc < 34.99) {
            return "Obesidade grau I";
        } else if (imc > 39.99) {
            return "Onesicade grau II (severa)";
        } else {
            return "Obesidade grau III (mórbida)";
        }
    }

}

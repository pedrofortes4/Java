    public static void main(String[] args) {

        double c = 299792458.0, pctc, ms, kmh, kms, gama;
        String opcao;
        System.out.println("CALCULADORA LORENTZ (γ)\n");
        System.out.println("Escolha uma unidade de velocidade para o cálculo do Fator de Lorentz e digite o número correspondente:\n");
        System.out.println("1. Metros por segundo (m/s);\n2. Quilômetros por hora (km/h);\n3. Quilômetros por segundo (km/s);\n4. Percentual da velocidade da luz no vácuo (x%*c);");
        Scanner sc = new Scanner(System.in);
        opcao = sc.next();

        switch (opcao) {

            case "1": {
                System.out.println("Digite a velocidade em metros por segundo (m/s) - APENAS NÚMERO\nLembre-se: A velocidade da luz (c) é de 299792458 m/s");
                ms = sc.nextDouble();
                gama = 1 / (Math.sqrt(1 - (Math.pow((ms / c), 2.0))));
                System.out.println("γ = " + gama);
                break;
            }

            case "2": {
                System.out.println("Digite a velocidade em quilômetros por hora (km/h)) - APENAS NÚMERO\nLembre-se: A velocidade da luz (c) é de 1079252848,7999 km/h");
                kmh = sc.nextDouble();
                gama = 1 / (Math.sqrt(1 - (Math.pow((kmh / 1079252848.7999), 2.0))));
                System.out.println("γ = " + gama);
                break;
            }

            case "3": {
                System.out.println("Digite a velocidade em quilômetros por hora (km/h)) - APENAS NÚMERO\nLembre-se: A velocidade da luz (c) é de 299792.458 km/s");
                kms = sc.nextDouble();
                gama = 1 / (Math.sqrt(1 - (Math.pow(((kms * 1000) / c), 2.0))));
                System.out.println("γ = " + gama);
                break;
            }

            case "4": {
                System.out.println("Digite a a porcentagem em relação à velocidade da luz - APENAS NÚMERO");
                pctc = sc.nextDouble();
                gama = 1 / (Math.sqrt(1 - (Math.pow((pctc / 100), 2.0))));
                System.out.println("γ = " + gama);
                break;
            }            
        }

    }
}

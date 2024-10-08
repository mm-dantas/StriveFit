package musculacao;

import musculacao.treinos.GrupoMuscular;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InserirTreino {
    Map<String, GrupoMuscular> gruposMusculares = new HashMap<>();

    String[] nomesMusculos = {"peitoral", "biceps", "perna", "antebraco", "triceps", "ombro", "costas"};

    public void inserirTreino(){
        Scanner leitor = new Scanner(System.in);

        for (String nomeMusculo : nomesMusculos) {
            GrupoMuscular grupoMuscular = new GrupoMuscular();
            gruposMusculares.put(nomeMusculo, grupoMuscular);
            inserirDadosTreino(leitor, grupoMuscular, nomeMusculo);
        }

        leitor.close();


    }

    public void inserirDadosTreino(Scanner leitor, GrupoMuscular grupoMuscular, String nomeMusculo){
        System.out.println("Digite seu treino de cada musculo pedido (digite 'fim' para terminar): ");
        System.out.println("Treino de " + nomeMusculo + ":");
        grupoMuscular.setNomeMusculo(nomeMusculo);

        while (true) {
            String exercicio = leitor.nextLine();

            if (exercicio.equalsIgnoreCase("fim")) {
                break;
            }

            grupoMuscular.addExercicios(exercicio);
            System.out.println("Quantas series você realiza nesse exercício?");
            grupoMuscular.setNumeroSeries(leitor.nextInt());

            for (int i = 1; i <= grupoMuscular.getNumeroSeries(); i++){
                System.out.println("Digite quantos quilos você pega na " + i + "ª série");
                grupoMuscular.addPeso(leitor.nextDouble());
                leitor.nextLine();
                System.out.println("Digite o número de repetições da " + i + "ª série: ");
                grupoMuscular.addNumeroRepeticoes(leitor.nextInt());
                leitor.nextLine();
            }

            System.out.println("Digite o próximo exercício: ");
        }



    }
}

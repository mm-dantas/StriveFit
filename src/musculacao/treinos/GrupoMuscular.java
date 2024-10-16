package musculacao.treinos;

import java.util.ArrayList;

public class GrupoMuscular {
    private String nomeMusculo;
    private ArrayList<String> exercicios = new ArrayList<>();
    private int numeroSeries;
    private ArrayList<Integer> numeroRepeticoes = new ArrayList<>();
    private ArrayList<Double> peso = new ArrayList<>();

    public void setNomeMusculo(String nomeMusculo) {
        this.nomeMusculo = nomeMusculo;
    }

    public void addExercicios(String exercicio) {
        this.exercicios.add(exercicio);
    }

    public void setNumeroSeries(int numeroSeries) {
        this.numeroSeries = numeroSeries;
    }

    public int getNumeroSeries() {
        return numeroSeries;
    }

    public void addNumeroRepeticoes(int numeroRepeticoes) {
        this.numeroRepeticoes.add(numeroRepeticoes);
    }

    public void addPeso(double peso) {
        this.peso.add(peso);
    }

    public String dadosExercicio() {
        int cont = 0;
        String dado = "Nome do MÚsculo: "+nomeMusculo;
        for (String exercicio : exercicios) {
            dado += "Exercício: "+ exercicio+"" +
                    "Número de Séries: "+ numeroSeries;
            for (int repeticao : numeroRepeticoes){
                dado += "" +
                        "Número de Repetições: "+repeticao+"" +
                        "Carga: "+peso.get(cont);
                cont ++;
            }
        }
        return dado;
    }


}

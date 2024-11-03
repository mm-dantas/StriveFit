package musculacao.treinos;

import java.util.ArrayList;

public class Treino {
    private String nomeExercicio;
    private String nomeMusculo; //Para saber qual grupo muscular será afetado
    private int numeroSeries;
    private ArrayList<Integer> numeroRepeticoes = new ArrayList<>();
    private ArrayList<Double> peso = new ArrayList<>();

    public void setNomeMusculo(String nomeMusculo) {
        this.nomeMusculo = nomeMusculo;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public String getNomeMusculo() {
        return nomeMusculo;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
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



    public String MostrarDadosExercicio() {
        int cont = 0;
        String dado = "Nome do Exercício: "+nomeExercicio+"\n";
        dado += "\nNúmero de Séries: "+ numeroSeries;
        for (int repeticao : numeroRepeticoes){
            dado += "\n" +
                    "\nNúmero de Repetições: "+ repeticao +
                    "\nCarga: "+peso.get(cont);
            cont ++;
        }

        return dado;
    }


}

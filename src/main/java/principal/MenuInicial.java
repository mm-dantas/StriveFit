package principal;

import musculacao.InserirTreino;

import java.util.Scanner;

public class MenuInicial {
    private int opcao;

    private static Scanner leitor = new Scanner(System.in);

    public void menuInicial(){
        System.out.println("Digite a opção desejada: \n" +
                "1. Inserir Treino no Sistema;\n" +
                "2. Ver meu desempenho;");
        opcao = leitor.nextInt();

        if (opcao == 1){
            InserirTreino inserirTreino = new InserirTreino();
            inserirTreino.inserirTreino();
        }
//        else if (menu.getOpcao() == 2){
//            Desempenho meuDesempenho = new Desempenho();
//            meuDesempenho.();
//        }
    }

}

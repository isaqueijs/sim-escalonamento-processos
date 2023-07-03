package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ArrayList<Processo> processos = new ArrayList<Processo>();
        int qtdProcessos;

        System.out.println("--------------------------------------------------------------\n" +
                "Escalonamento de Processos" +
                "\n--------------------------------------------------------------");
        System.out.print("Digite o número de processos que deseja criar: ");
        qtdProcessos = ler.nextInt();

        for (int i = 1; i <= qtdProcessos; i++) {
            System.out.print("Digite o ID do processo: ");
            int id = ler.nextInt();
            System.out.print("Digite o NOME do processo: ");
            String nome = ler.next();
            System.out.print("Digite a PRIORIDADE do processo (1-10): ");
            int prioridade = ler.nextInt();
            System.out.println("Informe o TIPO do processo (1 para: I/O bound ou 2 para: CPU/bound): ");
            int nTipo = ler.nextInt();
            while (nTipo != 1 && nTipo != 2) {
                System.out.print("Digite 1 para I/O bound ou 2 para CPU/bound: ");
                nTipo = ler.nextInt();
            }
            String tipo;
            if (nTipo == 1) {
                tipo = "I/O bound";
            } else {
                tipo = "CPU/bound";
            }
            System.out.print("Digite o TEMPO do processo (ms) - Digitar somente número: ");
            int tempo = ler.nextInt();

            processos.add(new Processo(id, nome, prioridade, tipo, tempo));
            System.out.println(processos.get(i-1).toString());
        }
        System.out.println("Pronto\n"+ qtdProcessos +" processos criados com sucesso!");
        System.out.print("--------------------------------------------------------------\n" +
                "Digite o tempo de quantum da preempção dos processos (ms): ");
        int quantum = ler.nextInt();
        ler.close();
        System.out.println("\nAlgoritmo de Escalonamento de Processos: Round-Robin");
        RoundRobin rr = new RoundRobin(processos, quantum);
        rr.executaProcessos();

        float media = 0;
        int tempoTotal = 0;
        int tempoCPU = 0;

        System.out.println("RESULTADOS\nNome -- Tempo de turnaround");
        for (Processo pt: rr.getProcessosTerminados()) {
            System.out.println(pt.getNome() + " -- " + pt.getTempoTotal());
            tempoCPU += pt.getTempoCpuInicial();
            tempoTotal += pt.getTempoTotal();
        }
        media = (tempoTotal - tempoCPU) / qtdProcessos;
        System.out.printf("--------------------------------------------------------------\nTempo médio de espera dos processos: %.2f", media);
    }

    public static void delay(int tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
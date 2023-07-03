package src;

import java.util.ArrayList;

public class RoundRobin {
    private ArrayList<Processo> processos;
    private int quantum;
    private ArrayList<Processo> processosTerminados = new ArrayList<Processo>();

    public RoundRobin(ArrayList<Processo> processos, int quantum) {
        this.processos = processos;
        this.quantum = quantum;
    }

    public void executaProcessos() {

        Processo processo;

        while (this.processos.size() > 0) {
            Main.delay(10);
            processo = this.processos.get(0);
            System.out.println("--------------------------------------------------------------");
            System.out.println("▶️ - Executando: " + processo.toString());
            processo.setTempoCPU(this.quantum);

            for (int i = 1; i < this.processos.size(); i++) {
                System.out.println("⌛ - Aguardando: " + this.processos.get(i));
                if (processo.getTempoCpu() < 0) {
                    this.processos.get(i).setTempoTotal(this.quantum + processo.getTempoCpu());
                } else {
                    this.processos.get(i).setTempoTotal(this.quantum);
                }
            }

            if (processo.getTempoCpu() <= 0) {
                this.processosTerminados.add(processo);
                this.processos.remove(0);
            } else {
                this.processos.remove(0);
                this.processos.add(processo);
            }

        }

        System.out.println("--------------------------------------------------------------\n✅ - Processos Terminados: " +
                "\n--------------------------------------------------------------");
        for (Processo pt : this.processosTerminados) {
            System.out.println(pt.toString());
        }
        System.out.println("--------------------------------------------------------------");
    }

    public ArrayList<Processo> getProcessos() {
        return processos;
    }

    public ArrayList<Processo> getProcessosTerminados() {
        return processosTerminados;
    }
}

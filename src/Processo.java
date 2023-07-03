package src;

public class Processo {

    private int id;
    private String nome;
    private int prioridade;
    private String tipo;
    private int tempoCpu;
    private int tempoCpuInicial;
    private int tempoTotal;

    public Processo(int id, String nome, int prioridade, String tipo, int tempoCpu) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.tipo = tipo;
        this.tempoCpu = tempoCpu;
        this.tempoCpuInicial = tempoCpu;
        this.tempoTotal = 0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTempoCpu() {
        return tempoCpu;
    }

    public int getTempoCpuInicial() {
        return tempoCpuInicial;
    }

    public void setTempoCPU(int quantum) {
        this.tempoCpu -= quantum;
        if (this.tempoCpu < 0) {
            quantum += this.tempoCpu;
        }
        setTempoTotal(quantum);
    }

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(int tempo) {
        this.tempoTotal += tempo;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prioridade=" + prioridade +
                ", tipo='" + tipo + '\'' +
                ", tempoCpu=" + tempoCpu +
                ", tempoTotal=" + tempoTotal +
                '}';
    }
}
import java.time.LocalDateTime;

public class Consulta {
    private LocalDateTime dataHora;
    private Usuario paciente;

    public Consulta(LocalDateTime dataHora, Usuario paciente) {
        this.dataHora = dataHora;
        this.paciente = paciente;
    }

    // Getters e Setters

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public Usuario getPaciente() { return paciente; }
    public void setPaciente(Usuario paciente) { this.paciente = paciente; }

    @Override
    public String toString() {
        return "Consulta{" +
                "dataHora=" + dataHora +
                ", paciente=" + paciente +
                '}';
    }
}

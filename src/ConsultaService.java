import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConsultaService {
    private List<Consulta> consultas;
    private UsuarioService usuarioService;

    public ConsultaService(UsuarioService usuarioService) {
        this.consultas = new ArrayList<>();
        this.usuarioService = usuarioService;
    }

    public void inserirConsulta(String cpf, LocalDateTime dataHora) {
        usuarioService.buscarUsuarioPorCpf(cpf).ifPresent(paciente -> consultas.add(new Consulta(dataHora, paciente)));
    }

    public List<Consulta> listarConsultas() {
        return consultas;
    }

    public Optional<Consulta> buscarConsulta(String cpf, LocalDateTime dataHora) {
        return consultas.stream().filter(c -> c.getPaciente().getCpf().equals(cpf) && c.getDataHora().equals(dataHora)).findFirst();
    }

    public void editarConsulta(String cpf, LocalDateTime dataHoraAntiga, LocalDateTime dataHoraNova) {
        buscarConsulta(cpf, dataHoraAntiga).ifPresent(consulta -> consulta.setDataHora(dataHoraNova));
    }

    public void deletarConsulta(String cpf, LocalDateTime dataHora) {
        buscarConsulta(cpf, dataHora).ifPresent(consultas::remove);
    }
}

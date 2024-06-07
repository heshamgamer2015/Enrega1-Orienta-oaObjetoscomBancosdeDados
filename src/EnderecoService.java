public class EnderecoService {
    private UsuarioService usuarioService;

    public EnderecoService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void inserirEndereco(String cpf, Endereco endereco) {
        usuarioService.buscarUsuarioPorCpf(cpf).ifPresent(usuario -> usuario.addEndereco(endereco));
    }

    public void editarEndereco(String cpf, Endereco enderecoAntigo, Endereco enderecoNovo) {
        usuarioService.buscarUsuarioPorCpf(cpf).ifPresent(usuario -> {
            usuario.removeEndereco(enderecoAntigo);
            usuario.addEndereco(enderecoNovo);
        });
    }

    public void deletarEndereco(String cpf, Endereco endereco) {
        usuarioService.buscarUsuarioPorCpf(cpf).ifPresent(usuario -> usuario.removeEndereco(endereco));
    }
}

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private static UsuarioService usuarioService = new UsuarioService();
    private static EnderecoService enderecoService = new EnderecoService(usuarioService);
    private static ConsultaService consultaService = new ConsultaService(usuarioService);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. CRUD Pacientes");
            System.out.println("2. CRUD Endereços");
            System.out.println("3. CRUD Consultas");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    crudPacientes(scanner);
                    break;
                case 2:
                    crudEnderecos(scanner);
                    break;
                case 3:
                    crudConsultas(scanner);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void crudPacientes(Scanner scanner) {
        System.out.println("1. Inserir Paciente");
        System.out.println("2. Editar Paciente");
        System.out.println("3. Listar Pacientes");
        System.out.println("4. Deletar Paciente");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        switch (opcao) {
            case 1:
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Telefone: ");
                String telefone = scanner.nextLine();
                Usuario novoUsuario = new Usuario(nome, cpf, email, telefone);
                usuarioService.inserirUsuario(novoUsuario);
                break;
            case 2:
                System.out.print("CPF do Paciente: ");
                String cpfEditar = scanner.nextLine();
                System.out.print("Novo Nome: ");
                String novoNome = scanner.nextLine();
                System.out.print("Novo Email: ");
                String novoEmail = scanner.nextLine();
                System.out.print("Novo Telefone: ");
                String novoTelefone = scanner.nextLine();
                Usuario usuarioAtualizado = new Usuario(novoNome, cpfEditar, novoEmail, novoTelefone);
                usuarioService.editarUsuario(cpfEditar, usuarioAtualizado);
                break;
            case 3:
                usuarioService.listarUsuarios().forEach(System.out::println);
                break;
            case 4:
                System.out.print("CPF do Paciente: ");
                String cpfDeletar = scanner.nextLine();
                usuarioService.deletarUsuario(cpfDeletar);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void crudEnderecos(Scanner scanner) {
        System.out.println("1. Inserir Endereço");
        System.out.println("2. Editar Endereço");
        System.out.println("3. Deletar Endereço");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        switch (opcao) {
            case 1:
                System.out.print("CPF do Paciente: ");
                String cpf = scanner.nextLine();
                System.out.print("Estado: ");
                String estado = scanner.nextLine();
                System.out.print("Cidade: ");
                String cidade = scanner.nextLine();
                System.out.print("Rua: ");
                String rua = scanner.nextLine();
                System.out.print("Número: ");
                int numero = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha
                System.out.print("CEP: ");
                String cep = scanner.nextLine();
                Endereco novoEndereco = new Endereco(estado, cidade, rua, numero, cep);
                enderecoService.inserirEndereco(cpf, novoEndereco);
                break;
            case 2:
                System.out.print("CPF do Paciente: ");
                String cpfEditar = scanner.nextLine();
                System.out.print("Estado Atual: ");
                String estadoAtual = scanner.nextLine();
                System.out.print("Cidade Atual: ");
                String cidadeAtual = scanner.nextLine();
                System.out.print("Rua Atual: ");
                String ruaAtual = scanner.nextLine();
                System.out.print("Número Atual: ");
                int numeroAtual = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha
                System.out.print("CEP Atual: ");
                String cepAtual = scanner.nextLine();
                Endereco enderecoAntigo = new Endereco(estadoAtual, cidadeAtual, ruaAtual, numeroAtual, cepAtual);

                System.out.print("Novo Estado: ");
                String novoEstado = scanner.nextLine();
                System.out.print("Nova Cidade: ");
                String novaCidade = scanner.nextLine();
                System.out.print("Nova Rua: ");
                String novaRua = scanner.nextLine();
                System.out.print("Novo Número: ");
                int novoNumero = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha
                System.out.print("Novo CEP: ");
                String novoCep = scanner.nextLine();
                Endereco enderecoNovo = new Endereco(novoEstado, novaCidade, novaRua, novoNumero, novoCep);
                enderecoService.editarEndereco(cpfEditar, enderecoAntigo, enderecoNovo);
                break;
            case 3:
                System.out.print("CPF do Paciente: ");
                String cpfDeletar = scanner.nextLine();
                System.out.print("Estado: ");
                String estadoDeletar = scanner.nextLine();
                System.out.print("Cidade: ");
                String cidadeDeletar = scanner.nextLine();
                System.out.print("Rua: ");
                String ruaDeletar = scanner.nextLine();
                System.out.print("Número: ");
                int numeroDeletar = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha
                System.out.print("CEP: ");
                String cepDeletar = scanner.nextLine();
                Endereco enderecoDeletar = new Endereco(estadoDeletar, cidadeDeletar, ruaDeletar, numeroDeletar, cepDeletar);
                enderecoService.deletarEndereco(cpfDeletar, enderecoDeletar);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void crudConsultas(Scanner scanner) {
        System.out.println("1. Inserir Consulta");
        System.out.println("2. Editar Consulta");
        System.out.println("3. Listar Consultas");
        System.out.println("4. Deletar Consulta");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        switch (opcao) {
            case 1:
                System.out.print("CPF do Paciente: ");
                String cpf = scanner.nextLine();
                System.out.print("Data e Hora (yyyy-MM-ddTHH:mm): ");
                String dataHoraString = scanner.nextLine();
                LocalDateTime dataHora = LocalDateTime.parse(dataHoraString);
                consultaService.inserirConsulta(cpf, dataHora);
                break;
            case 2:
                System.out.print("CPF do Paciente: ");
                String cpfEditar = scanner.nextLine();
                System.out.print("Data e Hora Atual (yyyy-MM-ddTHH:mm): ");
                String dataHoraAtualString = scanner.nextLine();
                LocalDateTime dataHoraAtual = LocalDateTime.parse(dataHoraAtualString);
                System.out.print("Nova Data e Hora (yyyy-MM-ddTHH:mm): ");
                String novaDataHoraString = scanner.nextLine();
                LocalDateTime novaDataHora = LocalDateTime.parse(novaDataHoraString);
                consultaService.editarConsulta(cpfEditar, dataHoraAtual, novaDataHora);
                break;
            case 3:
                consultaService.listarConsultas().forEach(System.out::println);
                break;
            case 4:
                System.out.print("CPF do Paciente: ");
                String cpfDeletar = scanner.nextLine();
                System.out.print("Data e Hora (yyyy-MM-ddTHH:mm): ");
                String dataHoraDeletarString = scanner.nextLine();
                LocalDateTime dataHoraDeletar = LocalDateTime.parse(dataHoraDeletarString);
                consultaService.deletarConsulta(cpfDeletar, dataHoraDeletar);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}

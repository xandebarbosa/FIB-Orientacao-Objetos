import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        // Criando um vetor de pessoas
        Pessoa[] pessoas = new Pessoa[10];

        int opcao;

        do {
            String menu = "Menu:\n" +
                    "1. Inserir Pessoa\n" +
                    "2. Mostrar Pessoa com Maior Salário\n" +
                    "3. Mostrar Pessoa com Menor Salário\n" +
                    "4. Pesquisar Pessoa por ID\n" +
                    "5. Sair\n" +
                    "Escolha a opção desejada:";

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    inserirPessoa(pessoas);
                    break;
                case 2:
                    mostrarPessoaComSalarioExtremo(pessoas, true);
                    break;
                case 3:
                    mostrarPessoaComSalarioExtremo(pessoas, false);
                    break;
                case 4:
                    pesquisarPessoaPorId(pessoas);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa. Até mais!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }

        } while (opcao != 5);
    }

    private static void inserirPessoa(Pessoa[] pessoas) {
        // Encontrando o primeiro espaço vazio no vetor
        int posicaoVazia = -1;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                posicaoVazia = i;
                break;
            }
        }

        if (posicaoVazia != -1) {
            // Pedindo ao usuário para inserir os detalhes da pessoa
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa:"));
            String nome = JOptionPane.showInputDialog("Digite o nome da pessoa:");
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário da pessoa:"));

            // Criando a pessoa e adicionando ao vetor
            pessoas[posicaoVazia] = new Pessoa(id, nome, salario);
            JOptionPane.showMessageDialog(null, "Pessoa inserida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "O vetor está cheio. Não é possível adicionar mais pessoas.");
        }
    }

    private static void mostrarPessoaComSalarioExtremo(Pessoa[] pessoas, boolean buscarMaior) {
        if (pessoas == null || pessoas.length == 0) {
            // Tratamento para vetor vazio ou nulo
            JOptionPane.showMessageDialog(null, "Não há pessoas para buscar.");
            return;
        }

        Pessoa pessoaExtrema = null;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                if (pessoaExtrema == null || (buscarMaior && pessoas[i].getSalario() > pessoaExtrema.getSalario()) ||
                        (!buscarMaior && pessoas[i].getSalario() < pessoaExtrema.getSalario())) {
                    pessoaExtrema = pessoas[i];
                }
            }
        }

        if (pessoaExtrema != null) {
            String mensagem = buscarMaior ? "Pessoa com Maior Salário:\n" : "Pessoa com Menor Salário:\n";
            mensagem += pessoaExtrema.toString();
            JOptionPane.showMessageDialog(null, mensagem);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar uma pessoa com salário extremo.");
        }
    }

    private static void pesquisarPessoaPorId(Pessoa[] pessoas) {
        int idProcurado = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa a ser pesquisada:"));

        Pessoa pessoaEncontrada = encontrarPessoaPorId(pessoas, idProcurado);

        if (pessoaEncontrada != null) {
            JOptionPane.showMessageDialog(null, "Pessoa encontrada:\n" + pessoaEncontrada.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma pessoa encontrada com o ID " + idProcurado);
        }
    }

    private static Pessoa encontrarPessoaPorId(Pessoa[] pessoas, int id) {
        if (pessoas == null || pessoas.length == 0) {
            // Tratamento para vetor vazio ou nulo
            return null;
        }

        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa.getId() == id) {
                return pessoa;
            }
        }

        return null; // Retorna null se nenhuma pessoa com o ID for encontrada
    }
}


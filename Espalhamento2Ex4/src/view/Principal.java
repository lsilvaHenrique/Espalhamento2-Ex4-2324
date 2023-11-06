package view;

import sp.fateczl.lucas.listaObj.Lista;
import javax.swing.JOptionPane;

import model.Departamento;

public class Principal {
    private Lista[] tabelaEspalhamento;

    public Principal() {
        tabelaEspalhamento = new Lista[5];
        for (int i = 0; i < tabelaEspalhamento.length; i++) {
            tabelaEspalhamento[i] = new Lista();
        }
    }

    public void inserirDepartamento(int andar, String nomeDepartamento, String descricao) throws Exception {
        int posicao = hash(andar);
        Departamento departamento = new Departamento(andar, nomeDepartamento, descricao);
        tabelaEspalhamento[posicao].add(departamento, tabelaEspalhamento[posicao].size());
    }

    public String consultarDepartamento(int andar) throws Exception {
        int posicao = hash(andar);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tabelaEspalhamento[posicao].size(); i++) {
            Departamento departamento = (Departamento) tabelaEspalhamento[posicao].get(i);
            if (departamento.getAndar() == andar) {
                result.append(departamento.toString()).append("\n");
            }
        }
        return result.toString();
    }

    public void removerDepartamento(int andar, String nomeDepartamento) throws Exception {
        int posicao = hash(andar);
        for (int i = 0; i < tabelaEspalhamento[posicao].size(); i++) {
            Departamento departamento = (Departamento) tabelaEspalhamento[posicao].get(i);
            if (departamento.getAndar() == andar && departamento.getNomeDepartamento().equalsIgnoreCase(nomeDepartamento)) {
                tabelaEspalhamento[posicao].remove(i);
                break;
            }
        }
    }

    private int hash(int andar) {
        return andar % 5; // Função hash de divisão
    }

    public static void main(String[] args) throws Exception {
    	Principal loja = new Principal();
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:"
                    + "\n1 - Inserir departamento"
                    + "\n2 - Consultar departamento"
                    + "\n3 - Remover departamento"
                    + "\n4 - Sair"));
            switch (opcao) {
                case 1:
                    int andar = Integer.parseInt(JOptionPane.showInputDialog("Informe o andar do departamento:"));
                    String nomeDepartamento = JOptionPane.showInputDialog("Informe o nome do departamento:");
                    String descricao = JOptionPane.showInputDialog("Informe a descrição do departamento:");
                    loja.inserirDepartamento(andar, nomeDepartamento, descricao);
                    break;
                case 2:
                    int andarConsulta = Integer.parseInt(JOptionPane.showInputDialog("Informe o andar para consultar os departamentos:"));
                    String resultadoConsulta = loja.consultarDepartamento(andarConsulta);
                    JOptionPane.showMessageDialog(null, resultadoConsulta);
                    break;
                case 3:
                    int andarRemocao = Integer.parseInt(JOptionPane.showInputDialog("Informe o andar do departamento a ser removido:"));
                    String nomeDepartamentoRemocao = JOptionPane.showInputDialog("Informe o nome do departamento a ser removido:");
                    loja.removerDepartamento(andarRemocao, nomeDepartamentoRemocao);
                    break;
                case 4:
                JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                break;
            }
        } while (opcao != 4);
    }
}


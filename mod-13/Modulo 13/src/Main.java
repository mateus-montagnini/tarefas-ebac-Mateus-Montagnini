public class Main {
    public static void main(String[] args) {

        criaPF("Mateus", "Rua Souza, 123", 2000, "123456789", 1.70);
        criaPJ("Empresa X", "Rua Silva, 321", 2010, "987654321", 270);

    }

    public static void criaPF(String nome, String endereco, int anoDeNascimento, String cpf, double altura) {
        PessoaFisica pf = new PessoaFisica();
        pf.identificacao();
        pf.setNome(nome);
        pf.setEndereco(endereco);
        pf.setAnoDeNascimento(anoDeNascimento);
        pf.setCpf(cpf);
        pf.setAltura(altura);

        imprimir(pf);
    }

    public static void criaPJ(String nome, String endereco, int anoDeCriacao, String cnpj, int qnt) {
        PessoaJuridica pj = new PessoaJuridica();
        pj.identificacao();
        pj.setNome(nome);
        pj.setEndereco(endereco);
        pj.setAnoDeCriacao(anoDeCriacao);
        pj.setCnpj(cnpj);
        pj.setQuantidadeDeFuncionarios(qnt);

        imprimir(pj);
    }

    public static void imprimir(Pessoa pessoa) {
        if(pessoa instanceof PessoaFisica) {
            PessoaFisica pf = (PessoaFisica) pessoa;
            System.out.println("\nNome: " + pf.getNome() +
                    "\nEndereco: " + pf.getEndereco() +
                    "\nCPF: " + pf.getCpf() +
                    "\nAno de Nascimento: " + pf.getAnoDeNascimento() +
                    "\nAltura: " + pf.getAltura() + "\n");
        } else {
            PessoaJuridica pj = (PessoaJuridica) pessoa;
            System.out.println("\nNome: " + pj.getNome() +
                    "\nEndereco: " + pj.getEndereco() +
                    "\nCNPJ: " + pj.getCnpj() +
                    "\nAno de Criacao: " + pj.getAnoDeCriacao() +
                    "\nQuantidade de funcionarios: " + pj.getQuantidadeDeFuncionarios() + "\n");
        }
    }
}
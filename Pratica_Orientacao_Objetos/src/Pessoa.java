import java.util.Objects;

public class Pessoa {

	private int id;
    private String nome;
    private double salario;

    // Construtor
    public Pessoa(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    // Métodos de acesso (getters e setters)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Sobrescrevendo o método toString
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome;
    }

    // Sobrescrevendo o método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id == pessoa.id &&
                Double.compare(pessoa.salario, salario) == 0 &&
                Objects.equals(nome, pessoa.nome);
    }

    // Sobrescrevendo o método hashCode
    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa(1, "Alexandre", 5000.0);
        Pessoa pessoa2 = new Pessoa(2, "Ane", 6000.0);

        // Exibindo as informações usando o método toString
        System.out.println("Pessoa 1: " + pessoa1.toString());
        System.out.println("Pessoa 2: " + pessoa2.toString());

        // Verificando a igualdade usando o método equals
        System.out.println("As pessoas são iguais? " + pessoa1.equals(pessoa2));
    }
	

}

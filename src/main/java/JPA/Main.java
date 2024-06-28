package JPA;

import JPA.DAO.DepartamentoDAO;
import JPA.DAO.FuncionarioDAO;
import JPA.Model.Departamento;
import JPA.Model.Funcionario;

public class Main {
    public static void main(String[] args) {
        //Cria uma instancia das DAOs para as entidades Departamento e Funcionário
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        //Cria um novo Departamento
        Departamento departamento = new Departamento("Produção");

        //Cria um novo Funcionário utilizando o Builder
        Funcionario funcionario = Funcionario.builder().nome("Robert").salario(5000.0).departamento(departamento).build();
        //Grava o novo Funcionário, e seu novo respectivo Departamento no banco de dados.
        //funcionarioDAO.save(funcionario);
        System.out.println(departamentoDAO.findAll());
    }
}
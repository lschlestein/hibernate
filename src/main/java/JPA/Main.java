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

        //Grava um novo Departamento no banco de dados
        departamentoDAO.save(new Departamento("Engenharia"));
        //Busca um Departamento já existente por Id
        Departamento departamento = departamentoDAO.findById(2);
        System.out.println(departamentoDAO.findAll());

        //Cria um novo Funcionário utilizando o Builder
        Funcionario funcionario = Funcionario.builder().nome("Paula").salario(5000.0).departamento(departamento).build();
        //Grava o novo Funcionário, e seu respectivo Departamento no banco de dados.
        funcionarioDAO.save(funcionario);
        System.out.println(funcionarioDAO.findAll());
    }
}
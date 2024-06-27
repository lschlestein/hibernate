package JPA;

import JPA.DAO.DepartamentoDAO;
import JPA.DAO.FuncionarioDAO;
import JPA.Model.Departamento;
import JPA.Model.Funcionario;

public class Main {
    public static void main(String[] args) {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        //departamentoDAO.save(new Departamento("Engenharia"));
        Departamento departamento = departamentoDAO.findById(2);
        System.out.println(departamentoDAO.findAll());

        Funcionario funcionario = Funcionario.
                builder().
                nome("Paula").
                salario(5000.0).
                departamento(departamento).
                build();
        funcionarioDAO.save(funcionario);
        System.out.println(funcionarioDAO.findAll());


    }
}
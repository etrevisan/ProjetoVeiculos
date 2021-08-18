/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import model.DAO.VeiculoDAO;
import modela.Veiculo;

/**
 *
 * @author emill
 */
public class VeiculoControl {
    public void inserir (String marca, String modelo, String placa, String cor, int ano) throws SQLException
    {
      Veiculo vei = new Veiculo(marca,modelo,placa,cor,ano); 
      VeiculoDAO veiDao = new VeiculoDAO();
      veiDao.inserir(vei);
    }
    
    public void excluir (String placa) throws SQLException
    {
        VeiculoDAO veiDao = new VeiculoDAO();
        veiDao.excluir(placa);
    }
}

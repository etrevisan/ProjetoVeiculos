/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modela.Veiculo;

/**
 *
 * @author emill
 */
public class VeiculoDAO {
    Connection con = null;

    public boolean inserir(Veiculo vei) throws SQLException {
        boolean inseriu = false;
        try {
            con = new Conexao().getConnection();
            String sql = "INSERT INTO Veiculos (marca,modelo,placa,cor,ano) values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, vei.getMarca());
            stmt.setString(2, vei.getModelo());
            stmt.setString(3, vei.getPlaca());
            stmt.setString(4, vei.getCor());
            stmt.setInt(5, vei.getAno());
            stmt.execute();
            stmt.close();
            inseriu = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.close();
        }
        return inseriu;
    }
    
    public void excluir(String placa) throws SQLException {

        try {
            con = new Conexao().getConnection();
            String sql = "DELETE FROM Veiculos WHERE PLACA = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, placa);
            stmt.execute();
            stmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro: "+ex.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: "+ex.toString());
            }
        }
    }

}

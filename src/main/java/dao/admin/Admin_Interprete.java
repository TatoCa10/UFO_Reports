/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.Conexion;
import vo.Interprete;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Interprete {

    private Connection conexion;

    public Admin_Interprete() {
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }

    public boolean crearInterprete(Interprete interprete) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Interprete VALUES(?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setString(1, interprete.getNombre());
            statement.setInt(2, interprete.getEdad());
            statement.setString(3, interprete.getGenero());
            statement.setString(4, interprete.getIdioma());

            //--------------------------------------
            //3. Hacer la ejecucion
            resultado = statement.execute();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<Interprete> leerInterprete() {
        //1.Consulta
        ArrayList<Interprete> respuesta = new ArrayList<>();
        String consulta = "SELECT * FROM Interprete";
        try {
            //----------------------------
            //Statement
            Statement statement
                    = this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado
                    = statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            while (resultado.next()) {
                Interprete interprete = new Interprete();

                interprete.setNombre(resultado.getString(1));
                interprete.setEdad(resultado.getInt(2));
                interprete.setGenero(resultado.getString(3));
                interprete.setIdioma(resultado.getString(4));
                respuesta.add(interprete);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public boolean borrarInterprete(Interprete interprete) {
        boolean result = false;
        String query = "delete from Interprete where Nombre = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setString(1, interprete.getNombre());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

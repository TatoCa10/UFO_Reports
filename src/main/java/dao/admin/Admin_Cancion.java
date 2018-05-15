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
import vo.Cancion;
import vo.Interprete;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Cancion {

    private Connection conexion;

    public Admin_Cancion() {
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }

    public boolean crearCancion(Cancion cancion) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Cancion VALUES(?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            for (int i = 0; i < cancion.getInterprete().size(); i++) {

                statement.setString(1, cancion.getNombre());
                statement.setString(2, cancion.getInterprete().get(i).getNombre());
                statement.setString(3, cancion.getId());
                statement.setInt(4, cancion.getVentas());

                //--------------------------------------
                //3. Hacer la ejecucion
                resultado = statement.execute();
            }
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<Cancion> leerCancion() {
        //1.Consulta
        ArrayList<Cancion> respuesta = new ArrayList<>();
        String consulta = "SELECT * FROM Cancion";
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
            String idViejo = "";
            int i=0;
            while (resultado.next()) {

                if (resultado.getString(4).equals(idViejo)) {
                    Interprete interpretes = new Interprete();
                    interpretes.setNombre(resultado.getString(2));
                    respuesta.get(i-1).getInterprete().add(interpretes);
                } else {
                    
                    ArrayList<Interprete> arregloInterprete = new ArrayList<>();
                    Cancion cancion = new Cancion();
                    Interprete interprete = new Interprete();
                    idViejo = resultado.getString(3);

                    cancion.setNombre(resultado.getString(1));
                    interprete.setNombre(resultado.getString(2));
                    arregloInterprete.add(interprete);
                    cancion.setInterprete(arregloInterprete);
                    cancion.setId(resultado.getString(3));
                    cancion.setVentas(resultado.getInt(4));

                    respuesta.add(cancion);
                    i++;
                }
                

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }
    
    public boolean modificarCancion(Cancion cancion) {
        boolean result = false;
        String query = "update Cancion set ventas = ? where id= ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setInt(1, cancion.getVentas());

            
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    

    public boolean borrarCancion(Interprete interprete) {
        boolean result = false;
        String query = "delete from Interprete where id = ?";
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

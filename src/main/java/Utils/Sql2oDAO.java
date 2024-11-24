/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author Tomas
 */
import org.sql2o.Sql2o;

import Service.Isql2oDAO;

public class Sql2oDAO implements Isql2oDAO {
    private static volatile Sql2o sql2o;

    @Override
    public Sql2o getSql2o() {
        if (sql2o == null) {
            synchronized (Sql2oDAO.class) {
                if (sql2o == null) {
                    try {
                        sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "root", "");
                    } catch (Exception e) {
                        System.err.println("Error al inicializar Sql2o: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
        return sql2o;
    }
}

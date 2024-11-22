package Utils;

import java.sql.SQLException;

import MVC.Models.Pedido;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Util {
    
public static <T> void updateEntity(Connection connection, Pedido entity, String tableName, String idColumnName, int idValue) throws SQLException, IllegalAccessException {
        Class<?> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields(); // Obtiene los campos de la clase

        StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");

        // Construir las columnas y placeholders para el UPDATE
        for (Field field : fields) {
            field.setAccessible(true); // Permite acceso a campos privados
            sql.append(field.getName()).append(" = ?, ");
        }

        // Remover la última coma y espacio
        sql.setLength(sql.length() - 2);
        sql.append(" WHERE ").append(idColumnName).append(" = ?");

        System.out.println("Generated SQL: " + sql);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
            int index = 1;

            // Asignar los valores a los placeholders
            for (Field field : fields) {
                Object value = field.get(entity);
                preparedStatement.setObject(index++, value);
            }

            // Asigna el valor del ID
            preparedStatement.setObject(index, idValue);

            // Ejecutar el UPDATE
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);
        }
    }




}

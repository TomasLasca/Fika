package Utils;

import java.sql.SQLException;
import java.util.List;

import MVC.Models.Pedido;

import java.lang.reflect.Field;
import org.sql2o.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Util {
    
   public static <T> void updateEntity(
        org.sql2o.Connection connection,
        Pedido entity,
        String tableName,
        String idColumnName,
        int idValue,
        List<String> fieldsToUpdate) throws SQLException, IllegalAccessException {
    
    Class<?> clazz = entity.getClass();
    Field[] fields = clazz.getDeclaredFields(); // Obtiene los campos de la clase

    StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");

    // Construir las columnas y placeholders para el UPDATE basado en fieldsToUpdate
    for (Field field : fields) {
        if (fieldsToUpdate.contains(field.getName())) {
            sql.append(field.getName()).append(" = ?, ");
        }
    }

    // Validar que haya campos para actualizar
    if (sql.lastIndexOf(",") == -1) {
        throw new IllegalArgumentException("No fields to update. Ensure fieldsToUpdate is not empty.");
    }
       
    sql.setLength(sql.length() - 2);
    sql.append(" WHERE ").append(idColumnName).append(" = ?");

    System.out.println("Generated SQL: " + sql);

    try (java.sql.Connection jdbcConnection = connection.getJdbcConnection();
         PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sql.toString())) {

        int index = 1;

        // Asignar los valores a los placeholders
        for (Field field : fields) {
            if (fieldsToUpdate.contains(field.getName())) {
                field.setAccessible(true);
                Object value = field.get(entity);
                preparedStatement.setObject(index++, value);
            }
        }

        // Asigna el valor del ID
        preparedStatement.setObject(index, idValue);

        // Ejecutar el UPDATE
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows updated: " + rowsAffected);
    }
}

    


}

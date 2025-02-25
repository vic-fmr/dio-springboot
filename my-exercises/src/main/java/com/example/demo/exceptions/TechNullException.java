package com.example.demo.exceptions;

import java.io.Serial;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TechNullException extends NullPointerException {
    @Serial
    private static final long serialVersionUID = 1L;

    public TechNullException(List<String> campos) {
        super("Os seguintes campos não podem ser nulos: " + String.join(", ", campos));
    }

    public static List<String> getCamposNulos(Object body){
        List<String> camposNulos = new ArrayList<>();

        Field[] fields = body.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try{
                if (field.get(body) == null && !field.getName().equals("id")) {
                    camposNulos.add(field.getName());
                }
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
        return camposNulos;
    }
}

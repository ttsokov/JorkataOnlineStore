package org.georgi.shop.util;

import java.lang.reflect.Field;
import java.util.Arrays;

public interface ServiceUtil {
    public static <T> T updateEntityProperties(T base, T other) {
        Field[] baseFields = base.getClass().getDeclaredFields();

        Arrays.stream(baseFields).forEach(field -> {
            try {
                Object fieldValue = base.getClass().getDeclaredField(field.getName()).get(base);
                other.getClass().getDeclaredField(field.getName()).set(other, fieldValue);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        });

        return other;
    }
}

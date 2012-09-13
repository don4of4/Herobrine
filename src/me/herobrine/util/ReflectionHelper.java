package me.herobrine.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionHelper {

	public static <T> boolean setField(Class<T> clazz, T instance, String fieldName, Object value) {
		try {
			Field field = clazz.getField(fieldName);
			field.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

			field.set(instance, value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

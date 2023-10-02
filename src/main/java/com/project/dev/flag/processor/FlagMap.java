/*
 * @fileoverview    {FlagMap}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementación realizada.
 * @version 2.0     Documentación agregada.
 */
package com.project.dev.flag.processor;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Definición de {@code FlagMap}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class FlagMap {

    /**
     * TODO: Definición de {@code convertFlagsArrayToMap}.
     *
     * @param flags TODO: Description of tag.
     * @return TODO: Description of tag.
     */
    public static Map<String, String> convertFlagsArrayToMap(Flag[] flags) {
        Map<String, String> flagsMap = new HashMap<>();
        for (Flag aux : flags)
            flagsMap.put(aux.getName(), aux.getValue() == null ? "" : aux.getValue());
        return flagsMap;
    }

    /**
     * TODO: Definición de {@code validateFlagInMap}.
     *
     * @param <T>          TODO: Description of tag.
     * @param flagsMap     TODO: Description of tag.
     * @param flagName     TODO: Description of tag.
     * @param defaultValue TODO: Description of tag.
     * @param classType    TODO: Description of tag.
     * @return TODO: Description of tag.
     */
    public static <T> T validateFlagInMap(Map<String, String> flagsMap,
            String flagName, T defaultValue, Class<T> classType) {
        boolean validFlag = false;
        T resultValue = null;
        String flagValue = flagsMap.get(flagName);
        if (flagValue != null) {
            try {
                resultValue = classType.getConstructor(String.class).newInstance(flagValue);
                validFlag = true;
            } catch (Exception e) {
                System.out.printf("Invalid value '%s' for flag '%s'.\n", flagValue, flagName);
                //e.printStackTrace(System.out);
            }
        }
        if (!validFlag) {
            try {
                resultValue = defaultValue;
                String defaultFlag = String.valueOf(defaultValue);
                System.out.printf("Using default value '%s' in flag '%s'.\n", defaultFlag, flagName);
                flagsMap.put(flagName, defaultFlag);
            } catch (Exception e) {
                //e.printStackTrace(System.out);
            }
        }
        return resultValue;
    }
}

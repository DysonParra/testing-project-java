/*
 * @fileoverview    {Flag}
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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Definición de {@code Flag}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Flag {

    /* Nombre de la flag */
    private String name;
    /* Valor de la flag */
    private String value;
    /* Si es una flag requerida */
    private boolean required;

    /**
     * Obtiene el valor en {String} del objeto actual.
     *
     * @return un {String} con la representación del objeto.
     */
    @Override
    public String toString() {
        String result = "";
        if (required)
            result += "*";
        else
            result += " ";

        if (value == null)
            result += name;
        else
            result += name + " = " + value;

        return result;
    }

}

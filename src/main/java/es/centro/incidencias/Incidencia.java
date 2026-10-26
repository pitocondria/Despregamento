package es.centro.incidencias;

import java.util.Locale;

/**
 * Representa una incidencia de soporte con identificador, título, prioridad y
 * estado de resolución.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Incidencia {

    private final String id;
    private final String titulo;
    private final String prioridad;
    private final boolean abierta;

    /**
     * Crea una incidencia con los datos proporcionados.
     *
     * @param id identificador único de la incidencia
     * @param titulo resumen de la incidencia
     * @param prioridad nivel de prioridad, por ejemplo {@code alta},
     *        {@code media} o {@code baja}
     * @param abierta {@code true} si la incidencia continúa abierta
     */
    public Incidencia(String id, String titulo, String prioridad, boolean abierta) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.abierta = abierta;
    }

    /**
     * Devuelve el identificador de la incidencia.
     *
     * @return identificador de la incidencia
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve el título de la incidencia.
     *
     * @return título de la incidencia
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve el nivel de prioridad de la incidencia.
     *
     * @return prioridad de la incidencia
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Indica si la incidencia continúa abierta.
     *
     * @return {@code true} si está abierta; {@code false} si está cerrada
     */
    public boolean isAbierta() {
        return abierta;
    }

    /**
     * Comprueba si el identificador o el título contiene el texto indicado,
     * ignorando diferencias entre mayúsculas y minúsculas.
     *
     * @param texto texto que se desea localizar
     * @return {@code true} si el identificador o el título contiene el texto
     */
    public boolean coincideCon(String texto) {
        String criterio = texto.toLowerCase(Locale.ROOT);
        return id.toLowerCase(Locale.ROOT).contains(criterio)
                || titulo.toLowerCase(Locale.ROOT).contains(criterio);
    }

}

package es.centro.incidencias;

/**
 * Excepción comprobada que indica que no se encontró una incidencia solicitada.
 *
 * @version 1.0.0
 * @since 1.0.0
 * @see GestorIncidencias#buscarPorId(String)
 */
public class IncidenciaNoEncontradaException extends Exception {

    /**
     * Crea la excepción para el identificador que no se encontró.
     *
     * @param id identificador de la incidencia solicitada
     */
    public IncidenciaNoEncontradaException(String id) {
        super("No existe ninguna incidencia con el identificador " + id + ".");
    }
}

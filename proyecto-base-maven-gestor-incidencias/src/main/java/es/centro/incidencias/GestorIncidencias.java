package es.centro.incidencias;

import java.util.List;

/**
 * Proporciona operaciones de consulta sobre las incidencias del centro.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public final class GestorIncidencias {

    private final List<Incidencia> incidencias;

    /** Crea un gestor con el conjunto inicial de incidencias de ejemplo. */
    public GestorIncidencias() {
        incidencias = List.of(
                new Incidencia("INC-001", "No se puede iniciar sesión", "alta", true),
                new Incidencia("INC-002", "Actualizar el navegador", "media", false),
                new Incidencia("INC-003", "Impresora sin conexión", "baja", true),
                new Incidencia("INC-004", "Fallo de red en el aula", "alta", true)
        );
    }

    /**
     * Devuelve todas las incidencias registradas.
     *
     * @return lista inmutable con todas las incidencias
     */
    public List<Incidencia> listar() {
        return incidencias;
    }

    /**
     * Devuelve únicamente las incidencias que siguen abiertas.
     *
     * @return lista de incidencias abiertas
     */
    public List<Incidencia> listarAbiertas() {
        return incidencias.stream()
                .filter(Incidencia::isAbierta)
                .toList();
    }

    /**
     * Busca incidencias cuyo identificador o título contenga el texto indicado,
     * ignorando diferencias entre mayúsculas y minúsculas.
     *
     * @param texto criterio de búsqueda
     * @return lista de incidencias coincidentes
     * @see Incidencia#coincideCon(String)
     */
    public List<Incidencia> buscar(String texto) {
        return incidencias.stream()
                .filter(incidencia -> incidencia.coincideCon(texto))
                .toList();
    }

    /**
     * Busca una incidencia por su identificador, sin distinguir mayúsculas y
     * minúsculas.
     *
     * @param id identificador de la incidencia
     * @return incidencia encontrada
     * @throws IncidenciaNoEncontradaException si no existe una incidencia con
     *         ese identificador
     */
    public Incidencia buscarPorId(String id) throws IncidenciaNoEncontradaException {
        return incidencias.stream()
                .filter(incidencia -> incidencia.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new IncidenciaNoEncontradaException(id));
    }

    /**
     * Busca una incidencia por su identificador.
     *
     * @param id identificador de la incidencia
     * @return incidencia encontrada, o {@code null} si no existe
     * @deprecated Este método oculta el caso de incidencia inexistente
     *             devolviendo {@code null}. Utiliza
     *             {@link #buscarPorId(String)}, que informa del caso mediante
     *             {@link IncidenciaNoEncontradaException}.
     * @see #buscarPorId(String)
     */
    @Deprecated(since = "1.0.0", forRemoval = false)
    public Incidencia obtenerIncidencia(String id) {
        try {
            return buscarPorId(id);
        } catch (IncidenciaNoEncontradaException excepcion) {
            return null;
        }
    }
}

package co.edu.uptc.nomina.modelo;

import co.edu.uptc.nomina.modelo.enums.TipoDocEnum;

public class Persona {
    protected long id;
    protected String otrosApellidos;
    protected String otrosNombres;
    protected String primerApellido;
    protected String primerNombre;
    protected TipoDocEnum tipoDoc;

    public Persona() {
    }

    public Persona(long id, String primerNombre, String primerApellido, TipoDocEnum tipoDoc) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.tipoDoc = tipoDoc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOtrosApellidos() {
        return otrosApellidos;
    }

    public void setOtrosApellidos(String otrosApellidos) {
        this.otrosApellidos = otrosApellidos;
    }

    public String getOtrosNombres() {
        return otrosNombres;
    }

    public void setOtrosNombres(String otrosNombres) {
        this.otrosNombres = otrosNombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public TipoDocEnum getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDocEnum tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    @Override
    public String toString() {
        return primerNombre + " " + primerApellido;
    }
}
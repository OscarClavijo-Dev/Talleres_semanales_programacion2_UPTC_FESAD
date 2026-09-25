package co.edu.uptc.negocio.dto;

public class CredencialDto {
    private byte[] password;
    private String usuario;

    public CredencialDto() {
    }

    public CredencialDto(byte[] password, String usuario) {
        this.password = password;
        this.usuario = usuario;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "CredencialDto{" + "usuario=" + usuario + '}';
    }
}
package model;

public class Departamento {
    private int andar;
    private String nomeDepartamento;
    private String descricao;

    public Departamento(int andar, String nomeDepartamento, String descricao) {
        this.andar = andar;
        this.nomeDepartamento = nomeDepartamento;
        this.descricao = descricao;
    }

    public int getAndar() {
        return andar;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void setAndar(int andar) {
		this.andar = andar;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Departamento [andar=" + andar + ", nomeDepartamento=" + nomeDepartamento + ", descricao=" + descricao
				+ "]";
	}
}

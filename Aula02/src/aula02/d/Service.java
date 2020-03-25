package aula02.d;

public class Service {
	Dao daoo;
	public void Dao() {
		daoo = new Dao();
	}
	public void criar(Dao to) {
		daoo.incluir(to);
	}
	public void atualizar(Dao to) {
		daoo.atualizar(to);
	}
	public void excluir(Dao to) {
		daoo.excluir(to);
	}
	public Dao carregar(int id) {
		Dao to = daoo.carregar(id);
		return to;
	}
	@Override
	public String toString() {
		long populacao = 0;
		String pais = null;
		double area = 0;
		int id = 0;
		return"Dao [id=" + id + ", pais=" + pais + ", populacao=" + populacao + ",area="+area+ "]";
	}
}


package aula02.b;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PatternTeste {
	PatternDao patternDao, copia;
	static int id = 0;


	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		patternDao = new PatternDao ();
		copia = new PatternDao ( );
		System.out.println(patternDao);
		System.out.println(copia);
		System.out.println(id);
	}
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		PatternDao fixture = new PatternDao( );
		PatternDao novo = new PatternDao();
		novo.carregar(0);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		patternDao.criar();
		id = patternDao.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", patternDao, copia);
	}
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		patternDao.setNome("");
		patternDao.setPopulacao("");
		patternDao.setArea("");
		copia.setNome("");
		copia.setPopulacao("");
		copia.setArea("");
		patternDao.atualizar(0, null, 0, 0);
		patternDao.carregar(0);
		assertEquals("testa atualizacao", patternDao, copia);
	}
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao("");
		copia.setArea("");
		patternDao.excluir(0);
		patternDao.carregar(0);
		assertEquals("testa exclusao", patternDao, copia);
	}
}


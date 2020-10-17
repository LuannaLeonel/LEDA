package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.CountingSort;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		CountingSort cs = new CountingSort();
		ExtendedCountingSort ecs = new ExtendedCountingSort();
		this.implementation = ecs;
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
	@Test
	public void testSort06() {
		AbstractSorting<Integer> sorting = new CountingSort();
		Integer[] vetor = new Integer[]{3, 1, 4, 1};
		sorting.sort(vetor);
		Assert.assertEquals(1, vetor[0], 0);
		Assert.assertEquals(4, vetor[3], 0);
	}


	@Test
	public void testNegativeNumber() {
		AbstractSorting<Integer> sorting = new ExtendedCountingSort();
		Integer[] vetor = new Integer[]{-3, -1, 4, -8};
		sorting.sort(vetor);
		Assert.assertEquals(-8, vetor[0], 0);
		Assert.assertEquals(4, vetor[3], 0);
	}

	@Test
	public void testNegativeNumberSubArray() {
		AbstractSorting<Integer> sorting = new ExtendedCountingSort();
		Integer[] vetor = new Integer[]{-3, -1, 4, -8, 10, 1, 0, 8, 14};
		sorting.sort(vetor, 2, 7);
		// [-3, -1, -8, 0, 1, 4, 8, 10, 14]
		Assert.assertEquals(-8, vetor[2], 0);
		Assert.assertEquals(10, vetor[7], 0);
	}

	@Test
	public void testSubArray() {
		AbstractSorting<Integer> sorting = new CountingSort();
		Integer[] vetor = new Integer[]{3, 1, 4, 8, 10, 1, 0, 8, 14};
		sorting.sort(vetor, 2, 7);
		// [3, 1, 0, 1, 4, 8, 8, 10, 14]
		Assert.assertEquals(0, vetor[2], 0);
		Assert.assertEquals(10, vetor[7], 0);
	}

}

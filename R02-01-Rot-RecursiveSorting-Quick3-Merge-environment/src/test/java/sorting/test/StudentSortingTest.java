package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.hybridMergesort.HybridMergeSort;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorUmElemento;


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

	private void populaVetorUmElemento(Integer[] integers) {
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		MergeSort ms = new MergeSort();
		QuickSort qs = new QuickSort();
		QuickSortMedianOfThree qs3 = new QuickSortMedianOfThree();
		HybridMergeSort hms = new HybridMergeSort();

		this.implementation = hms;

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
		this.vetorValoresIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
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

	public void testPortion(Integer[] array, int start, int end ) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
			Arrays.sort(copy1,start,end+1);
		}
		System.out.println(Arrays.toString(array));
		implementation.sort(array,start,end);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(copy1));
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testPortionVetorTamPar01() {
		testPortion(vetorTamPar, 0, 3);
	}
	@Test
	public void testPortionVetorTamPar02() {
		testPortion(vetorTamPar,4,7);
	}

	@Test
	public void testPortionVetorTamPar03() {
		testPortion(vetorTamPar,vetorTamPar.length-3,vetorTamPar.length-1);
	}
	@Test
	public void testPortionVetorTamPar04() {
		testPortion(vetorTamPar,0,1);
	}

	@Test
	public void testPortionVetorTamPar05() {
		testPortion(vetorTamPar,5,6);
	}

	@Test
	public void testPortionVetorTamPar06() {
		testPortion(vetorTamPar,vetorTamPar.length-2,vetorTamPar.length-1);

	}

	@Test
	public void testPortionVetorTamImpar01() {
		testPortion(vetorTamImpar, 0, 3);
	}

	@Test
	public void testPortionVetorTamImpar02() {
		testPortion(vetorTamImpar,4,7);
	}

	@Test
	public void testPortionVetorTamImpar03() {
		testPortion(vetorTamImpar,vetorTamImpar.length-3,vetorTamImpar.length-1);
	}

	@Test
	public void testPortionVetorTamImpar04() {
		testPortion(vetorTamImpar,0,1);
	}

	@Test
	public void testPortionVetorTamImpar05() {
		testPortion(vetorTamImpar,5,6);
	}
	@Test
	public void testPortionVetorTamImpar06() {
		testPortion(vetorTamImpar,vetorTamImpar.length-2,vetorTamImpar.length-1);
	}

	@Test
	public void testPortionVetorVazio() {
		testPortion(vetorVazio,0,2);
	}

	@Test
	public void testPortionVetorValoresIguais01() {
		testPortion(vetorValoresIguais, 0, 3);
	}

	@Test
	public void testPortionVetorValoresIguais02() {
		testPortion(vetorValoresIguais,3,5);
	}

	@Test
	public void testPortionVetorValoresIguais03() {
		testPortion(vetorValoresIguais,vetorValoresIguais.length-3,vetorValoresIguais.length-1);
	}

	@Test
	public void testPortionVetorValoresRepetidos01() {
		testPortion(vetorValoresRepetidos,0,2);
	}

	@Test
	public void testPortionVetorValoresRepetidos02() {
		testPortion(vetorValoresRepetidos,3,5);
	}

	@Test
	public void testPortionVetorValoresRepetidos03() {
		testPortion(vetorValoresRepetidos,vetorValoresRepetidos.length-3,vetorValoresRepetidos.length-1);
	}

	@Test
	public void testPortionVetorValoresRepetidos04() {
		testPortion(vetorValoresRepetidos,0,1);
	}

	@Test
	public void testPortionVetorValoresRepetidos05() {
		testPortion(vetorValoresRepetidos,5,6);
	}

	@Test
	public void testPortionVetorValoresRepetidos06() {
		testPortion(vetorValoresRepetidos,vetorValoresRepetidos.length-2,vetorValoresRepetidos.length-1);
	}

	public void testIndexs(Integer[] array, int start, int end ) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array,start,end);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testOutIndexsvetorTamPar01(){
		testIndexs(vetorTamPar,-3,-1);
	}

	@Test
	public void testOutIndexsvetorTamPar02(){
		testIndexs(vetorTamPar,-2,2);
	}

	@Test
	public void testOutIndexsvetorTamPar03(){
		testIndexs(vetorTamPar,7,15);
	}

	@Test
	public void testOutIndexsvetorTamPar04(){
		testIndexs(vetorTamPar,14,20);
	}

	@Test
	public void testOutIndexsvetorTamPar05(){
		testIndexs(vetorTamPar,4,0);
	}

	@Test
	public void testOutIndexsvetorTamImpar01(){
		testIndexs(vetorTamImpar,-3,-1);
	}

	@Test
	public void testOutIndexsvetorTamImpar02(){
		testIndexs(vetorTamImpar,-2,2);
	}

	@Test
	public void testOutIndexsvetorTamImpar03(){
		testIndexs(vetorTamImpar,7,15);
	}

	@Test
	public void testOutIndexsvetorTamImpar04(){
		testIndexs(vetorTamImpar,14,20);
	}

	@Test
	public void testOutIndexsvetorTamImpar05(){
		testIndexs(vetorTamImpar,4,0);
	}


}
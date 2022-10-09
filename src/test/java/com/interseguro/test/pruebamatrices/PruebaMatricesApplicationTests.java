package com.interseguro.test.pruebamatrices;

import com.interseguro.test.pruebamatrices.exception.MatrizValidationException;
import com.interseguro.test.pruebamatrices.services.Impl.MatrizServiceImpl;
import com.interseguro.test.pruebamatrices.services.MatrizService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PruebaMatricesApplicationTests {

	private MatrizService matrizService;

	@BeforeEach
	void setUp(){
		matrizService = new MatrizServiceImpl();
	}

	@Test
	public void testArrayNxNValidationSameSizeItems(){
		List<List<Integer>> arr = new ArrayList<>();
		arr.add(Arrays.asList(1,2,3));
		arr.add(Arrays.asList(4,5,6,7));
		assertThrows(MatrizValidationException.class, () -> matrizService.rotarMatriz90Grados(arr));
	}

	@Test
	public void testArrayNxNValidationSameSizeLists(){
		List<List<Integer>> arr = new ArrayList<>();
		arr.add(Arrays.asList(1,2,3));
		arr.add(Arrays.asList(4,5,6));
		assertThrows(MatrizValidationException.class, () -> matrizService.rotarMatriz90Grados(arr));
	}

	@Test
	public void testReturnArrayRotatedExample1() throws MatrizValidationException {
		List<List<Integer>> arrOrigin = new ArrayList<>();
		arrOrigin.add(Arrays.asList(1,2));
		arrOrigin.add(Arrays.asList(3,4));
		List<List<Integer>> arrResponse = new ArrayList<>();
		arrResponse.add(Arrays.asList(2,4));
		arrResponse.add(Arrays.asList(1,3));
		assertEquals(arrResponse,matrizService.rotarMatriz90Grados(arrOrigin));
	}

	@Test
	public void testReturnArrayRotatedExample2() throws MatrizValidationException {
		List<List<Integer>> arrOrigin = new ArrayList<>();
		arrOrigin.add(Arrays.asList(1,2,3));
		arrOrigin.add(Arrays.asList(4,5,6));
		arrOrigin.add(Arrays.asList(7,8,9));
		List<List<Integer>> arrResponse = new ArrayList<>();
		arrResponse.add(Arrays.asList(3,6,9));
		arrResponse.add(Arrays.asList(2,5,8));
		arrResponse.add(Arrays.asList(1,4,7));
		assertEquals(arrResponse,matrizService.rotarMatriz90Grados(arrOrigin));
	}

}

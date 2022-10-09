package com.interseguro.test.pruebamatrices.services;

import com.interseguro.test.pruebamatrices.exception.MatrizValidationException;

import java.util.List;

public interface MatrizService {
    List<List<Integer>> rotarMatriz90Grados(List<List<Integer>> originalArr) throws MatrizValidationException;
}

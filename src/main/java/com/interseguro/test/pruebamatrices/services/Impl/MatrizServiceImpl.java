package com.interseguro.test.pruebamatrices.services.Impl;

import com.interseguro.test.pruebamatrices.exception.MatrizValidationException;
import com.interseguro.test.pruebamatrices.services.MatrizService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MatrizServiceImpl implements MatrizService {
    @Override
    public List<List<Integer>> rotarMatriz90Grados(List<List<Integer>> originalArr) throws MatrizValidationException{
        List<List<Integer>> response = new ArrayList<>();

        Set<Integer> itemsArraySet = originalArr.stream().map(List::size).collect(Collectors.toSet());

        if(itemsArraySet.size() > 1 || !itemsArraySet.contains(originalArr.size()) ){
            throw new MatrizValidationException("Matriz no es del tipo NxN");
        }

        originalArr.forEach( lista -> {
            response.add(originalArr.stream().map(l -> l.get(l.size() - originalArr.indexOf(lista) - 1)).collect(Collectors.toList()));
        });

        return response;
    }
}

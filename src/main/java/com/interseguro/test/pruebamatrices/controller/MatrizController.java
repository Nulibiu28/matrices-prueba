package com.interseguro.test.pruebamatrices.controller;

import com.interseguro.test.pruebamatrices.exception.MatrizValidationException;
import com.interseguro.test.pruebamatrices.services.MatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MatrizController {

    @Autowired
    private MatrizService matrizService;

    @PostMapping("/rotarMatriz")
    public List<List<Integer>> rotarMatriz(@RequestBody List<List<Integer>> arrInicial) throws MatrizValidationException {
        return matrizService.rotarMatriz90Grados(arrInicial);
    }

}

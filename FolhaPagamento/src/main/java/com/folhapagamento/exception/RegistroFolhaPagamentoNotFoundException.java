package com.folhapagamento.exception;

public class RegistroFolhaPagamentoNotFoundException extends RuntimeException {
    public RegistroFolhaPagamentoNotFoundException(Long id) {
        super("Employee with ID " + id + " not found");
    }
}

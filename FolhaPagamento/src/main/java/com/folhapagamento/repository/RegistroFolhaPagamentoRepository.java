package com.folhapagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folhapagamento.model.RegistroFolhaPagamento;

import java.util.List;

@Repository
public interface RegistroFolhaPagamentoRepository extends JpaRepository<RegistroFolhaPagamento, Long> {
    List<RegistroFolhaPagamento> findByCargo(String cargo);
    List<RegistroFolhaPagamento> findByAno(int ano);
    List<RegistroFolhaPagamento> findByEmpresa(String empresa);
}


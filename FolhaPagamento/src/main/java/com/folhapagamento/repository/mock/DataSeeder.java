package com.folhapagamento.repository.mock;


import com.folhapagamento.model.RegistroFolhaPagamento;
import com.folhapagamento.repository.RegistroFolhaPagamentoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RegistroFolhaPagamentoRepository registroRepository;
    private final Faker faker;

    public DataSeeder(RegistroFolhaPagamentoRepository registroRepository) {
        this.registroRepository = registroRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            RegistroFolhaPagamento registro = RegistroFolhaPagamento.builder()
                    .empresa(faker.company().name())
                    .mes(faker.number().numberBetween(1, 12))
                    .ano(faker.number().numberBetween(2000, 2023))
                    .nome(faker.name().fullName())
                    .cargo(faker.job().title())
                    .lotacao(faker.address().city())
                    .admissao(faker.date().toString())
                    .nascimento(faker.date().birthday().toString())
                    .vencimentos(faker.number().randomDouble(2, 1000, 5000))
                    .encargos(faker.number().randomDouble(2, 100, 500))
                    .beneficios(faker.number().randomDouble(2, 100, 500))
                    .outrasRemuneracoes(faker.number().randomDouble(2, 0, 200))
                    .vinculo(faker.job().title())
                    .detalheVinculo(faker.lorem().sentence())
                    .liminar(faker.lorem().sentence())
                    .arquivoId(faker.number().numberBetween(1, 100))
                    .build();

            registroRepository.save(registro);
        }
    }
}
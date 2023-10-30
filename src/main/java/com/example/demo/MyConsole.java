package com.example.demo;

import com.opencsv.CSVReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.util.List;

@SpringBootApplication
public class MyConsole implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("****************************************");
        System.out.println("**      MINHA PRIMEIRA APLICACAO     **");
        System.out.println("****************************************");

        LerCsv();
    }

    private void LerCsv() {

        try {
            // Especifique o caminho do arquivo CSV que você deseja ler
            String arquivoCsv = "C:\\Repos\\poc-csv-java\\planilha.csv";

            // Inicialize um leitor CSV
            CSVReader csvReader = new CSVReader(new FileReader(arquivoCsv));

            // Leia as linhas do arquivo CSV em uma lista de arrays de strings
            List<String[]> linhas = csvReader.readAll();

            // Itere pelas linhas e exiba o conteúdo
            for (String[] linha : linhas) {
                for (String valor : linha) {
                    System.out.print(valor + "\t");
                }
                System.out.println(); // Quebra de linha entre as linhas
            }

            // Feche o leitor CSV
            csvReader.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }

    }
}

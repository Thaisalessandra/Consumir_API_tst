package com.LiterAlura.LiterAlura;

import com.LiterAlura.LiterAlura.model.DadosEpisodio;
import com.LiterAlura.LiterAlura.model.DadosSerie;
import com.LiterAlura.LiterAlura.model.DadosTemporadas;
import com.LiterAlura.LiterAlura.principal.ExibeMenu;
import com.LiterAlura.LiterAlura.service.ConsumoApi;
import com.LiterAlura.LiterAlura.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("spring sem web");

		ConsumoApi consumo = new ConsumoApi();
		ExibeMenu exibeMenu = new ExibeMenu();

		var json =  consumo.obterDados(exibeMenu.ExibirMenu());
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados);
		//dados episodio
		json=consumo.obterDados("http://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=8e07ac38");
		DadosEpisodio dadosEpisodio= conversor.obterDados(json,DadosEpisodio.class);
		System.out.println(dadosEpisodio);

		//dados temporadas

		List<DadosTemporadas> temporadas = new ArrayList<>();

		for(int i = 1; i<=dados.totalTemporadas(); i++) {
			json = consumo.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
			DadosTemporadas dadosTemporada = conversor.obterDados(json, DadosTemporadas.class);
			temporadas.add(dadosTemporada);

		}
		temporadas.forEach(System.out::println);
	}
}

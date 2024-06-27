package com.LiterAlura.LiterAlura.model;



import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporadas(@JsonAlias("Season") Integer Temporada,
                             @JsonAlias("Episodes") List<DadosEpisodio> episodios) {
}
package it.nextre.academy.realspring.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name="attore")
public class Attore {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private String sesso;


    @JsonManagedReference
    @ManyToMany
    //tabella di mezzo
    //joinColumns identifica le colonne di questa entità che parteciperanno alla relazione, in questo caso solo l'id
    //inverseJoinColumns identifica le colonne della controparte che parteciperanno alla relazione.
    //@Joincolumn permette di ridefinere il nome della colonna sulla tabella di join
    @JoinTable(
            name="rel_attore_film",
            uniqueConstraints = @UniqueConstraint(columnNames = {"idattore","idfilm"}),
            joinColumns = @JoinColumn(name="idattore"),
            inverseJoinColumns = @JoinColumn(name="idfilm")
    )
    private List<Film> films;
    {
        films = new ArrayList<>();
    }

    private void setFilms(List<Film> films){}

    public boolean addFilm(Film f) {
        if (films.stream().filter(item->item.getId()==f.getId()).count() == 0) {
            return films.add(f);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Attore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", sesso='" + sesso + '\'' +
                ", films=" + films.stream().map(f->f.getId()).collect(Collectors.toList()) +
                '}';
    }
}//end class

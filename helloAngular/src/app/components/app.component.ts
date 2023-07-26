import { Component } from '@angular/core';

import { PokedexService } from '../services/pokedex.service';

import { Pokemon } from '../models/pokemon';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  // Titolo dell'applicazione
  title = 'newApp';

  pokemon: Pokemon[] = [];

  isLoading: boolean = false;

  error: boolean = false;

  constructor(private pokedexService: PokedexService) {}


  ngOnInit() {
    this.loadMore();
  }

  loadMore() {
    this.isLoading = true;

    this.pokedexService
      .getPokemon(this.pokemon.length, 9)
      .then((pokemon: Pokemon[]) => { 
        
        pokemon = pokemon.map((p: Pokemon) => { 
          p.imageLoaded = false;
          return p;
        });

        this.pokemon = this.pokemon.concat(pokemon);
        
        this.isLoading = false;
        this.error = false;
      })
      .catch(() => {
        //gestione dell'errore
        this.error = true;
        this.isLoading = false;
      });
  }
}
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PokedexService {

  // URL di base per le chiamate all'API dei PK
  private baseUrl: string = 'https://pokeapi.co/api/v2/pokemon/';

  // URL di base per ottenere le img dei PK
  private baseImgUrl: string = 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/';

  constructor(private http: HttpClient) { }


  getPokemon(offset: number, limit: number) {
    return this.http.get<any>(`${this.baseUrl}?offset=${offset}&limit=${limit}`)
      .toPromise()
      .then(response => response.results)
      .then(items => items.map((item: any, idx: number) => { // Regola i tipi

        
        const id: number = idx + offset + 1;

        return {
          name: item.name,
          imgurl: `${this.baseImgUrl}${id}.png`,
          id
        };
      }));
  }
}
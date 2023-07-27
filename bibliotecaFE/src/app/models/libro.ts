import { Autore } from "./autore";

export class Libro {
  idLibro: number;
  titolo: string;
  categoria: string;
  dataPubblicazione: string;
  listaAutori: Autore[];

  constructor(
    idLibro: number,
    titolo: string,
    categoria: string,
    dataPubblicazione: string,
    listaAutori: []
  ) {
    this.idLibro = idLibro;
    this.titolo = titolo;
    this.categoria = categoria;
    this.dataPubblicazione = dataPubblicazione;
    this.listaAutori = listaAutori;
  }
}

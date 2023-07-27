export class Autore {
    idAutore: number;
    nome: string;
    cognome: string;
    dataNascita: string;
  
    constructor(
      idAutore: number,
      nome: string,
      cognome: string,
      dataNascita: string,
    ) {
      this.idAutore = idAutore;
      this.nome = nome;
      this.cognome = cognome;
      this.dataNascita = dataNascita;
    }
  }
  
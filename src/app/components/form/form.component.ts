import { Component } from '@angular/core';
import { Libro } from 'src/app/models/libro';
import { LibroService } from 'src/app/services/libro.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {

  // variabili utilizzate per memorizzare temporaneamente i dati inseriti nei campi del form.
  a = ''; b = ''; c = ''; d = ''; e = '';

  constructor(private libroService: LibroService){}

  postLibri(libro: Libro) {
    console.log("siamo nel component form");
    console.log(libro);
    this.libroService.saveLibro(libro).subscribe((responce: any) => {
      console.log(responce);
    })
  }
}

import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Libro } from 'src/app/models/libro';
import { LibroService } from 'src/app/services/libro.service';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {

  libroForm: FormGroup;

  // variabili utilizzate per memorizzare temporaneamente i dati inseriti nei campi del form.
  // a = ''; b = ''; c = ''; d = ''; e = '';

  constructor(private fb: FormBuilder, private libroService: LibroService) {
    
    this.libroForm = this.fb.group({
      titolo: [''],
      categoria: [''],
      dataPubblicazione: ['']
    });
  }


  postLibri(libro: Libro) {
    if(this.libroForm) {
    console.log("siamo nel component form");
    console.log(libro);
    this.libroService.saveLibro(libro).subscribe((responce: any) => {
      console.log(responce);
    })
    this.libroForm.reset();
    alert(" Libro aggiunto con successo")
  }
  }
}

import { Component, OnInit } from '@angular/core';
import { LibroService } from 'src/app/services/libro.service';

@Component({
  selector: 'app-libro',
  templateUrl: './libro.component.html',
  styleUrls: ['./libro.component.css']
})
export class LibroComponent implements OnInit{

  constructor(private serviceLibro: LibroService) {}

  libri: any;
  ngOnInit(): void {
    this.serviceLibro.getAllLibri().subscribe(
      response => {
        this.libri = response;
        console.log(this.libri);
      }
    )
  }
}

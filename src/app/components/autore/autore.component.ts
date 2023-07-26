import { Component, OnInit } from '@angular/core';
import { AutoreService } from 'src/app/services/autore.service';

@Component({
  selector: 'app-autore',
  templateUrl: './autore.component.html',
  styleUrls: ['./autore.component.css']
})
export class AutoreComponent implements OnInit {

  constructor(private serviceAutore: AutoreService) {}

  autori:any;
  ngOnInit(): void {
    this.serviceAutore.getAllAutori().subscribe(
      response => {
        this.autori = response;
      }
    )
  }


}

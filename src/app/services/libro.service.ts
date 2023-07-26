import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Libro } from '../models/libro';
import { Observable } from 'rxjs';

const urlLocalHost = 'http://localhost:8080';
const requestMapping = '/libri';
const getMapping = '/getAll';
const postMapping = '/post';


@Injectable({
  providedIn: 'root',
})
export class LibroService {
  constructor(private http: HttpClient) {}

  getAllLibri(): Observable<Libro[]> {
    return this.http.get<Libro[]>(urlLocalHost + requestMapping + getMapping);
  }

  saveLibro(libro: Libro): Observable<Libro> {
    console.log("Siamo nel service saveLibro");
    console.log(libro);
    return this.http.post<any>(urlLocalHost + requestMapping + postMapping, libro)
  }
}

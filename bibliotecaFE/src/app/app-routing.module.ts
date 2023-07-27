import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AutoreComponent } from './components/autore/autore.component';
import { LibroComponent } from './components/libro/libro.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { FormComponent } from './components/form/form.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'autori', component: AutoreComponent},
  {path:'libri', component: LibroComponent},
  {path:'form', component: FormComponent},
  {path:'404', component: NotfoundComponent},
  {path:'**', redirectTo:'404', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

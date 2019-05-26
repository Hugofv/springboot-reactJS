import { Routes, ActivatedRoute } from '@angular/router'
import { CreateComponent } from './sistema/create/create.component';
import { SistemaComponent } from './sistema/sistema.component';

export const ROUTES: Routes = [
  {path: '', component: SistemaComponent},
  {path: 'sistema', component: CreateComponent}
]
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { SistemaComponent } from './sistema/sistema.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { 
  MatCardModule,
  MatFormFieldModule,
  MatInputModule,
  MatButtonModule,
  MatTableModule,
  MatDialogModule,
  MAT_SNACK_BAR_DEFAULT_OPTIONS,
  MatSnackBarModule
 } from '@angular/material';
 import { CdkTableModule } from '@angular/cdk/table';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreateComponent } from './sistema/create/create.component';
import { RouterModule } from '@angular/router';
import { ROUTES } from './app.route';

@NgModule({
  declarations: [
    AppComponent,
    SistemaComponent,
    CreateComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSnackBarModule,
    AngularFontAwesomeModule,
    MatTableModule,
    HttpClientModule,
    CdkTableModule,
    HttpClientModule,
    MatDialogModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [ {provide: MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue: {duration: 2500}} ],
  bootstrap: [AppComponent]
})
export class AppModule { }

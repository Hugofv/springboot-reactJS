import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  [x: string]: any;
  descricao = new FormControl('', [Validators.required]);
  sigla = new FormControl('', [Validators.required]);
  email = new FormControl('', [Validators.required, Validators.email]);
  url = new FormControl('', [Validators.required]);
  private serviceUrl = 'http://localhost:8080/blade';

  constructor(private http: HttpClient, public snackBar: MatSnackBar) { }

  ngOnInit() {  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  onSave() {
    var sistema = {
      descricao: this.descricao.value,
      sigla: this.sigla.value,
      email: this.email.value,
      url: this.url.value
    };

    if(!sistema.descricao) {
      this.snackBar.open(`Atenção! O campo "Descrição" tem seu preenchimento Obrigatório`, '', {
        panelClass:"custom_sneak_bar"
      })
      return
    }
    
    if(!sistema.sigla) {
      this.snackBar.open(`Atenção! O campo "Sigla" tem seu preenchimento Obrigatório`, '', {
        panelClass:"custom_sneak_bar"
      })
      return
    }

    if(!sistema.email) {
      this.snackBar.open(`Atenção! O campo "E-mail" tem seu preenchimento Obrigatório`, '', {
        panelClass:"custom_sneak_bar"
      })
      return
    }

    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var teste = re.test(String(sistema.email).toLowerCase());
    if(!teste) {
      this.snackBar.open(`E-mail inválido.`, '', {
        panelClass:"custom_sneak_bar"
      })
      return
    }

    if(!sistema.url) {
      this.snackBar.open(`Atenção! O campo "URL" tem seu preenchimento Obrigatório`, '', {
        panelClass:"custom_sneak_bar"
      })
      return
    }
    else {
      var url = this.serviceUrl + '/sistema';
      let headers = new Headers();
      headers.append('Content-Type','application/json');
      this.http.post(url , sistema, {headers: headers})
            .subscribe(
              () => {
                this.snackBar.open(`Operação realizada com sucesso.`, '', {
                  panelClass:"custom_sneak_bar"
                });
                this.clearForm();
              },
              () => {
                this.snackBar.open(`Atenção! Não foi possível cadastrar o sistema, Tente novamente mais tarde`, '', {
                  panelClass:"custom_sneak_bar"
                })
              }
            );

    }
  }

  clearForm() {
    this.descricao.reset();
    this.sigla.reset();
    this.email.reset();
    this.url.reset();
  }
}

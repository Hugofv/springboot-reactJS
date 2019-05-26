import {Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'sistema',
  templateUrl: './sistema.component.html',
  styleUrls: ['./sistema.component.css']
})


export class SistemaComponent implements OnInit {
  displayedColumns = ['descricao', 'sigla', 'email', 'url'];
  descricao = new FormControl('');
  sigla = new FormControl('');
  email = new FormControl('',[Validators.email]);
  dataSource: [];
  private serviceUrl = 'http://localhost:8080/blade';

  constructor(private http: HttpClient, public snackBar: MatSnackBar) {}

  getSistema() {
    var sistema = {
        descricao: this.descricao.value,
        sigla: this.sigla.value,
        email: this.email.value
      };
    
    if(sistema.email) {
      var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      var teste = re.test(String(sistema.email).toLowerCase());
      if(!teste) {
        this.snackBar.open(`E-mail inválido.`, '', {
          panelClass:"custom_sneak_bar"
        })
        return
      }
    }
    var url = this.serviceUrl + `/filtro?descricao=${sistema.descricao}&sigla=${sistema.sigla}&email=${sistema.email}&url=${sistema.url}`
    this.http.get<Sistema[]>(url)
            .subscribe(
              res => {
                if(res.length > 0) {
                  this.dataSource = res
                } else {
                  this.snackBar.open(`Nenhum Sistema foi encontrado. Favor revisar os critérios da sua pesquisa!`, '', {
                    panelClass:"custom_sneak_bar"
                  })
                }
              },
              () => {
                this.snackBar.open(`Nenhum Sistema foi encontrado. Favor revisar os critérios da sua pesquisa!`, '', {
                  panelClass:"custom_sneak_bar"
                })
              }
            );
  }

  clearForm() {
    this.descricao.reset();
    this.sigla.reset();
    this.email.reset();
    this.dataSource = [];
  }

  ngOnInit() {
  }
}

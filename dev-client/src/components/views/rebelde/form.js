import {
  Button,
  Fieldset,
  InputMessageError,
  RadioButton,
  TextField
} from '../../library';
import { Cnpj, Cpf, Telefone } from '../../../utils/mask';
import { Col, Row } from 'antd';

import { Formik } from 'formik';
import React from 'react';

const Form = props => {
  return (
    <div>
      <Formik
        enableReinitialize
        initialValues={{
          id: props.rebelde._id || '',
          nome: props.rebelde.nome || '',
          idade: props.rebelde.idade || '',
          genero: props.rebelde.genero || '',
          localizacao: props.rebelde.localizacao || {},
        }}
        validate={values => {
          let errors = {};
         
          if (!values.nome) {
            errors.nome = 'Campo Obrigatório';
          }

          if (!values.idade) {
            errors.idade = 'Campo Obrigatório';
          }
          return errors;
        }}
        onSubmit={values => {
          if (values._id) {
            props.updateRebelde(values).then(() => {
              props.toastManager.add('Rebelde atualizado com sucesso.', {
                appearance: 'success',
                autoDismiss: true,
                pauseOnHover: true
              });
              props.hideModal();
            });
          } else {
            props.addRebelde(values).then(() => {
              props.toastManager.add('Rebelde cadastrado com sucesso.', {
                appearance: 'success',
                autoDismiss: true,
                pauseOnHover: true
              });
              props.hideModal();
            });
          }
        }}
      >
        {({
          values,
          errors,
          touched,
          handleSubmit,
          handleChange,
          resetForm,
          setFieldValue
        }) => (
          <form>
            <Fieldset legend="Cadastrar Rebelde">
              <Row type="flex">
                <Col>
                  <RadioButton
                    checked={values.genero == 'masculino'}
                    title="Masculino"
                    name="genero"
                    onChange={e => {
                      setFieldValue('genero', e.target.value);
                    }}
                    value="masculino"
                  />
                </Col>
                <Col style={{ marginLeft: '1em' }}>
                  <RadioButton
                    checked={values.tipo == 'feminino'}
                    title="Feminino"
                    name="genero"
                    onChange={(e) => {
                      setFieldValue('genero', e.target.value);
                    }}
                    value="femino"
                  />
                </Col>
              </Row>

              <Row style={{ marginTop: '1em' }}>
                <TextField
                  title="Nome"
                  name="nome"
                  onChange={handleChange}
                  value={values.nome}
                  error={errors.nome && touched.nome && errors.nome}
                />
                <InputMessageError>
                  {errors.nome && touched.nome && errors.nome}
                </InputMessageError>
              </Row>

              <Row>
                <TextField
                  title="Idade"
                  name="idade"
                  value={values.idade}
                  onChange={handleChange}
                />
                <InputMessageError>
                  {errors.idade && touched.idade && errors.idade}
                </InputMessageError>
              </Row>

              <Row>
                <TextField
                  title="Nome Galáxia"
                  name="localizacao.nome"
                  value={values.localizacao.nome}
                  onChange={handleChange}
                />
              </Row>

              <Row>
                <Col span={7}>
                  <TextField
                    title="Latitude"
                    name="localizacao.latitude"
                    value={values.localizacao.latitude}
                    maxLength="15"
                    onChange={handleChange}
                  />
                </Col>
                <Col style={{ marginLeft: '1em' }} span={7}>
                  <TextField
                    title="Longitude"
                    name="localizacao.longitude"
                    value={values.localizacao.longitude}
                    maxLength="15"
                    onChange={handleChange}
                  />
                </Col>
              </Row>

              <Row type="flex" justify="end">
                <Button
                  type="reset"
                  onClick={() => {
                    props.hideModal();
                    resetForm();
                  }}
                >
                  Cancelar
                </Button>
                <Button
                  primary
                  type="button"
                  onClick={() => handleSubmit(values)}
                >
                  Salvar
                </Button>
              </Row>
            </Fieldset>
          </form>
        )}
      </Formik>
    </div>
  );
};

export default Form;

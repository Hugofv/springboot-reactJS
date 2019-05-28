import {
  Divider,
  Icon,
  Modal,
  Row,
  Table,
  Tag,
} from 'antd';
import React, { Component } from 'react';
import {
  addRebelde,
  deleteRebelde,
  fetchRebelde,
  updateRebelde,
} from '../../../actions/rebelde';

import { Button } from '../../library';
import Form from './form';
import Page from '../Page';
import { connect } from 'react-redux';

const { confirm } = Modal;

class Rebelde extends Component {
  constructor(props) {
    super(props);
    this.state = { visible: false, rebelde: {} };

    this.showModal = this.showModal.bind(this);
    this.hideModal = this.hideModal.bind(this);
    this.showDeleteConfirm = this.showDeleteConfirm.bind(this);

    document.title = 'Rebelde';
  }

  componentDidMount() {
    this.props.fetchRebelde();
  }

  showModal(rebelde) {
    this.setState({
      visible: true,
      rebelde: rebelde || {},
    });
  }

  hideModal() {
    this.setState({
      visible: false,
      rebelde: {},
    });
  }

  showDeleteConfirm(rebelde) {
    const { deleteRebelde, toastManager } = this.props;

    confirm({
      title: 'Voce tem certeza que deseja excluir esse rebelde?',
      content: rebelde.nome,
      okText: 'Sim',
      okType: 'danger',
      cancelText: 'Não',
      onOk() {
        deleteRebelde(rebelde._id).then(() => {
          toastManager.add('Rebelde excluído com sucesso.', {
            appearance: 'success',
            autoDismiss: true,
            pauseOnHover: true,
          });
        });
      },
      onCancel() {},
    });
  }

  render() {
    const { addRebelde, updateRebelde, rebelde } = this.props;
    const columns = [
      {
        title: 'Nome',
        dataIndex: 'nome',
        key: 'nome',
      },
      {
        title: 'Idade',
        dataIndex: 'idade',
        key: 'idade',
      },
      {
        title: 'Gênero',
        key: 'genero',
        dataIndex: 'genero',
        render: genero => (
          <span>
            {
              <Tag color={genero == 'masculino' ? 'geekblue' : 'green'} key={genero}>
                {genero.toUpperCase()}
              </Tag>
            }
          </span>
        ),
      },
      {
        title: 'Latitude',
        dataIndex: 'localizacao.latitude',
        key: 'latitude',
      },
      {
        title: 'Longitude',
        dataIndex: 'localizacao.longitude',
        key: 'longitude',
      },
      {
        title: 'Ação',
        key: 'action',
        render: (text, record) => (
          <span>
            <Icon
              type="edit"
              theme="outlined"
              onClick={() => this.showModal(record)}
              style={{ color: '#08c', fontSize: '20px', cursor: 'pointer' }}
            />
            <Divider type="vertical" />
            <Icon
              type="delete"
              theme="outlined"
              onClick={() => this.showDeleteConfirm(record)}
              style={{ color: '#FF0000', fontSize: '20px', cursor: 'pointer' }}
            />
          </span>
        ),
      },
    ];

    return (
      <Page>
        <Row type="flex" justify="end">
          <Button primary onClick={() => this.showModal()}>
            <Icon type="plus" />
            Cadastrar
          </Button>
        </Row>

        <Modal
          visible={this.state.visible}
          onCancel={e => this.hideModal(e)}
          okText="Salvar"
          width="40%"
          footer={[null, null]}
        >
          <Form
            hideModal={() => this.hideModal()}
            addRebelde={addRebelde}
            updateRebelde={updateRebelde}
            rebelde={this.state.rebelde}
            toastManager={this.props.toastManager}
          />
        </Modal>

        <Table columns={columns} dataSource={rebelde} rowKey="nome" />
      </Page>
    );
  }
}

function mapStateToProps(state) {
  return {
    rebelde: state.rebelde,
    error: state.error,
  };
}

export default connect(
  mapStateToProps,
  {
    addRebelde,
    updateRebelde,
    fetchRebelde,
    deleteRebelde,
  },
)(Rebelde);

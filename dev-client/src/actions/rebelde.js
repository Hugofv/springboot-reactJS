import {
  ADD_ERROR,
  ADD_REBELDE,
  FETCH_REBELDE,
  UPDATE_REBELDE,
} from '.';

import enviroment from '../enviroment';

export const addRebelde = rebelde => dispatch => new Promise((resolve, reject) => {
  fetch(`${enviroment.apiUrl}rebelde/`, {
    method: 'post',
    body: JSON.stringify(rebelde),
    headers: { 'Content-Type': 'application/json' },
  })
    .then((response) => {
      if (response.status == 201) {
        return response.json();
      }
      throw response.json();
    })
    .then((data) => {
      dispatch({
        type: ADD_REBELDE,
        rebelde: data,
      });
      resolve(data);
    })
    .catch((err) => {
      err.then((error) => {
        dispatch({
          type: ADD_ERROR,
          error,
        });
      });
      reject(error);
    });
});

export const updateRebelde = rebelde => dispatch => new Promise((resolve, reject) => {
  fetch(`${enviroment.apiUrl}rebelde`, {
    method: 'put',
    body: JSON.stringify(rebelde),
    headers: { 'Content-Type': 'application/json' },
  })
    .then((response) => {
      if (response.status == 200) {
        return response.json();
      }
      throw response.json();
    })
    .then(() => {
      dispatch(fetchRebelde());
      resolve();
    })
    .catch((err) => {
      err.then((error) => {
        dispatch({
          type: ADD_ERROR,
          error,
        });
      });
      reject(err);
    });
});

export const deleteRebelde = id => dispatch => new Promise((resolve, reject) => {
  fetch(`${enviroment.apiUrl}rebelde/${id}`, {
    method: 'delete',
    headers: { 'Content-Type': 'application/json' },
  })
    .then((response) => {
      if (response.status == 200) {
        resolve();
        return dispatch(fetchRebelde());
      }
      throw response.json();
    })
    .catch((err) => {
      err.then((error) => {
        dispatch({
          type: ADD_ERROR,
          error,
        });
      });

      reject();
    });
});

export const fetchRebelde = () => (dispatch) => {
  fetch(`${enviroment.apiUrl}rebelde/`, {
    method: 'get',
    headers: { 'Content-Type': 'application/json' },
  })
    .then((response) => {
      if (response.status == 200) {
        return response.json();
      }
      throw response.json();
    })
    .then(data => dispatch({
      type: FETCH_REBELDE,
      rebelde: data,
    }))
};

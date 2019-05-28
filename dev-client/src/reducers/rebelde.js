import { ADD_REBELDE, FETCH_REBELDE, REQUESTING } from '../actions';

const initialState = [];

export default (state = initialState, action) => {
  switch (action.type) {
    case ADD_REBELDE: {
      const { rebelde } = action;
      return [rebelde].concat(state);
    }

    case FETCH_REBELDE: {
      const { rebelde } = action;
      return rebelde;
    }

    default: {
      return state;
    }
  }
};

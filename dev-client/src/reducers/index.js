import { combineReducers } from 'redux';
import error from './error';
import rebelde from './rebelde';

const rootReducer = combineReducers({
  rebelde,
  error,
});

export default rootReducer;

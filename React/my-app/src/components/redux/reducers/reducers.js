import { SIGNUP } from "../actions/actions";

const initialState = {
  signup: false,

};


const rootReducer = (state = initialState, action) => {
  switch (action.type) {
    case SIGNUP:
              return {

                    ...state,
                    signup : action.payload.status,

                }; break;

    default:
      return state;
  }
};

export default rootReducer;
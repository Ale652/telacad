import { SIGNUP,  USER, LOGIN, REGISTER } from "../actions/actions";

const initialState = {
  signup: false,
    login: {},
    user: {},
    register: {},
};


const rootReducer = (state = initialState, action) => {
  switch (action.type) {
    case SIGNUP:
              return {

                    ...state,
                    signup : action.payload.status,

                }; break;

      case LOGIN:
                return {

                        ...state,
                        login:
                                    {
                                        email: action.payload.email,
                                        role: action.payload.role,
                                        token: action.payload.token,
                                    }
                                ,
                    }; break;


    case USER:
                return {

                        ...state,
                        user:
                                    {
                                        email: action.payload.email,
                                        firstName: action.payload.firstName,
                                        lastName: action.payload.lastName,
                                        id: action.payload.id,
                                    }
                                ,
                    }; break;

     case REGISTER:
          return {

                ...state,
                register:
                            {
                                email: action.payload.email,
                                role: action.payload.role,
                                password: action.payload.password,
                            }
                        ,
            }; break;

    default:
      return state;
  }
};

export default rootReducer;
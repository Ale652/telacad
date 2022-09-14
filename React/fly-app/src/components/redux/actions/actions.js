export const SIGNUP = "SIGNUP";
export const LOGIN = "LOGIN";
export const USER = "USER";
export const REGISTER = "REGISTER";

export const signupAction = (status) => {
    return {
        type: SIGNUP,
        payload: {
            status: status
        }

    };
};


export const login = (email, role, token) => {
    return {
        type: LOGIN,
        payload: {
            email: email, role: role, token: token
        }
    };
};

export const user = (email, firstName, lastName,id) => {
    return {
        type: USER,
        payload: {
            email: email, firstName: firstName, lastName: lastName, id: id
        }
    };
};

export const register = (email, role, password) => {
    return {
        type: REGISTER,
        payload: {
            email: email, role: role, password: password
        }
    };
};
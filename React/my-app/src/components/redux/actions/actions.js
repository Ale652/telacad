export const SIGNUP = "SIGNUP";

export const signupAction = (status) => {
    return {
        type: SIGNUP,
        payload: {
            status: status
        }

    };
};
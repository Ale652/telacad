import React from "react";
import TextField from "@mui/material/TextField";
import Carousel from "../components/carousel/Carousel";
import { useSelector, useDispatch } from "react-redux";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import { signupAction } from "./redux/actions/actions";
import Grid from "@mui/material/Grid";
import Login from "./../components/login/Login";
import Register from "./../components/register/Register";


const Home = (props) => {

const dispatch = useDispatch();
  const signup = useSelector((state) => state.signup);

  const signupUI = () => {
         dispatch(signupAction(true));
  };

  const signinUI = () => {
    dispatch(signupAction(false));
  };

  return (
            <div>
              <Carousel />
              <Grid container direction={"row"} spacing={1} style={{width: '300px'}}>
                      <Box>
                          <Grid container direction={"row"} spacing={1} style={{width: '200px'}}>
                               { signup===true ? <Register /> : <Login />}
                          </Grid>
                      </Box>
                      <Grid container direction={"row"} spacing={1} style={{width: '100px'}}>
                           { signup===false ?
                               <Button onClick={signupUI} variant="text">
                               {" "}
                                   SIGN UP
                               </Button>
                               :
                               <Button onClick={signinUI} variant="text">
                               {" "}
                                   SIGN IN
                               </Button>
                           }
                      </Grid>
              </Grid>
            </div>
  );
};

export default Home;

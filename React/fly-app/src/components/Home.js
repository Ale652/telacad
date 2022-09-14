import React from "react";
import TextField from "@mui/material/TextField";


const Home = (props) => {
  return (
            <TextField inputProps={{style: {fontSize: 35}}}
              disabled
              id="outlined-textarea"
              defaultValue="Reading is good for you because it improves your focus, memory, empathy, and communication skills. It can reduce stress, improve your mental health, and help you live longer. Reading also allows you to learn new things to help you succeed in your work and relationships."
              placeholder="Placeholder"
              multiline
            />
  );
};

export default Home;

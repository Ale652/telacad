import logo from './logo.svg';
import './App.css';
import Home from "./components/Home";
import Login from "./components/login/Login";

import Register from "./components/register/Register";

function App() {
  return (
    <div className="App">
      <Home/>

      <Login />
      <Register />

    </div>
  );
}

export default App;
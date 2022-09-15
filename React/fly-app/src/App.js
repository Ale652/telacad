import logo from './logo.svg';
import './App.css';
import Home from "./components/Home";
import { useSelector } from "react-redux";

function App() {
 const loginState = useSelector((state) => state.login);

  return (
    <div className="App">
      <Home/>

    </div>
  );
}

export default App;

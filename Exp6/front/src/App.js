
import { useState } from 'react';
import {addApi, subtractApi} from "./service";
import './App.css';

function App() {
    const [number1, setNumber1] = useState(0);
    const [number2, setNumber2] = useState(0);
    const [result, setResult] = useState("No result yet");
  
    const handleAddition = () => {
        addApi(number1, number2)
          .then((result) => setResult(result.result))
          .catch((error) => setResult("Error: " + error.message));
      };
    
    const handleSubtraction = () => {
        subtractApi(number1, number2)
          .then((result) => setResult(result.result))
          .catch((error) => setResult("Error: " + error.message));
    };
    
  return (
    <div className="App">
      <header className="App-header">Simple Add/Subtract</header>
      <label>Enter two numbers:</label>
      <input
        type="number"
        placeholder="Enter the first number"
        onChange={(event) => setNumber1(+event.target.value)}
      />
      <input
        type="number"
        placeholder="Enter the second number"
        onChange={(event) => setNumber2(+event.target.value)}
      />
      <button onClick={handleAddition}>Add</button>
      <button onClick={handleSubtraction}>Subtract</button>
      <p>Result: {result}</p> 
    </div>
  );
}

export default App;

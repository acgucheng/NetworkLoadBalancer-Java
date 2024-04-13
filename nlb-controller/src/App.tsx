import React from 'react';

import './App.css';
import {Navbar} from './components/Navbar';
import {Sidebar} from './components/Sidebar';
import {Content} from "./components/Content";

function App() {
  return (
    <div className="App" style={{display:"flex",flexDirection:"column", backgroundColor:"lightgrey"}}>
        <Navbar />
        <Sidebar />
        <Content />

    </div>
  );
}

export default App;

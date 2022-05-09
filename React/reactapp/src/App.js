import './App.css';
import { BrowserRouter as BrowserRouter , Route, Routes } from 'react-router-dom';
import LandingPage from './components/LandingPage';
import PageClient from './components/PageClient';
import PageEmployee from './components/PageEmployee';

function App() {
  return (
    <BrowserRouter>
    
      <div className='container'>
        <Routes>
          <Route path='/' element={<LandingPage/>} />
          <Route path='/clients' element={<PageClient/>} />
          <Route path='/employe' element={<PageEmployee/>} />
        </Routes>
        


      </div>
    </BrowserRouter>
  );
}

export default App;

// src/App.js

import React, { useState } from 'react';
import { Provider } from 'react-redux';
import LoginPage from './LoginPage';
import UserForm from './pages/LoginPage/UserForm';
import UserList from './pages/LoginPage/UserList';
import { store } from './redux/store/store';

const App = () => {
  const [userToEdit, setUserToEdit] = useState(null);

  return (
    <Provider store={store}>
      <div>
        <LoginPage/>
      </div>
    </Provider>
  );
};

export default App;

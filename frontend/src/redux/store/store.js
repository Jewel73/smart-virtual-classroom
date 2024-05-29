// src/app/store.js
import { configureStore } from '@reduxjs/toolkit';
import userReducer from '../slice/UserSlice';

export const store = configureStore({
  reducer: {
    users: userReducer,
  },
});

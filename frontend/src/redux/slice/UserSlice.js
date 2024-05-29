// src/features/user/userSlice.js
import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  users: [
    { id: 1, name: 'John Doe' },
    { id: 2, name: 'Jane Smith' },
  ],
  status: 'idle',
  error: null,
};

const userSlice = createSlice({
  name: 'users',
  initialState,
  reducers: {
    fetchUsers: (state) => {
      state.status = 'succeeded';
    },
    addUser: (state, action) => {
      const newUser = {
        id: state.users.length ? state.users[state.users.length - 1].id + 1 : 1,
        ...action.payload,
      };
      state.users.push(newUser);
    },
    updateUser: (state, action) => {
      const { id, name } = action.payload;
      const existingUser = state.users.find((user) => user.id === id);
      if (existingUser) {
        existingUser.name = name;
      }
    },
    deleteUser: (state, action) => {
      const id = action.payload;
      state.users = state.users.filter((user) => user.id !== id);
    },
  },
});

export const { fetchUsers, addUser, updateUser, deleteUser } = userSlice.actions;

export default userSlice.reducer;

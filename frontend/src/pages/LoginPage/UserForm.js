// src/features/user/UserForm.js
import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { addUser, updateUser } from '../../redux/slice/UserSlice';

const UserForm = ({ userToEdit, setUserToEdit }) => {
  const dispatch = useDispatch();
  const [name, setName] = useState(userToEdit ? userToEdit.name : '');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (userToEdit) {
      dispatch(updateUser({ id: userToEdit.id, user: { name } }));
      setUserToEdit(null);
    } else {
      dispatch(addUser({ name }));
    }
    setName('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        value={name}
        onChange={(e) => setName(e.target.value)}
        placeholder="Enter name"
      />
      <button type="submit">{userToEdit ? 'Update' : 'Add'}</button>
    </form>
  );
};

export default UserForm;

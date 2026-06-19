import React, { useEffect, useState } from "react";
import UserForm from "./components/UserForm";
import UserList from "./components/UserList";
import {
  getUsers,
  createUser,
  updateUser,
  deleteUser
} from "./services/UserService";

function App() {

  const [users, setUsers] = useState([]);
  const [selectedUser, setSelectedUser] = useState(null);

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = () => {
    getUsers().then((res) => setUsers(res.data));
  };

  const addUser = (user) => {
    createUser(user).then(loadUsers);
  };

  const editUser = (user) => {
    setSelectedUser(user);
  };

  const updateUserData = (id, user) => {
    updateUser(id, user).then(() => {
      setSelectedUser(null);
      loadUsers();
    });
  };

  const deleteUserData = (id) => {
    deleteUser(id).then(loadUsers);
  };

  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">User Management</h2>

      <UserForm
        addUser={addUser}
        selectedUser={selectedUser}
        updateUser={updateUserData}
      />

      <UserList
        users={users}
        deleteUser={deleteUserData}
        editUser={editUser}
      />
    </div>
  );
}


export default App;
import React, { useState, useEffect } from "react";

const UserForm = ({ addUser, selectedUser, updateUser }) => {

  const [user, setUser] = useState({
    email: "",
    firstName: "",
    lastName: ""
  });

  useEffect(() => {
    if (selectedUser) setUser(selectedUser);
  }, [selectedUser]);

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (user.id) {
      updateUser(user.id, user);
    } else {
      addUser(user);
    }

    setUser({ email: "", firstName: "", lastName: "" });
  };

  return (
    <div className="card p-4 shadow">
      <h4 className="mb-3">User Form</h4>

      <form onSubmit={handleSubmit}>
        <input
          className="form-control mb-2"
          name="email"
          placeholder="Email"
          value={user.email}
          onChange={handleChange}
        />
        <input
          className="form-control mb-2"
          name="firstName"
          placeholder="First Name"
          value={user.firstName}
          onChange={handleChange}
        />
        <input
          className="form-control mb-2"
          name="lastName"
          placeholder="Last Name"
          value={user.lastName}
          onChange={handleChange}
        />

        <button className="btn btn-primary w-100">
          {user.id ? "Update User" : "Add User"}
        </button>
      </form>
    </div>
  );
};

export default UserForm;
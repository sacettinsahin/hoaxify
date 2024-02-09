import React, { useState } from "react";
import axios from "axios";

const SignUp = () => {
  const [username, setUsername] = useState();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [passwordRepait, setPasswordRepait] = useState();

  const onSubmit = (event) => {
    event.preventDefault();

    axios.post("/api/v1/users", {
      username: username,
      email: email,
      password: password,
    });
  };

  return (
    <>
      <form onSubmit={onSubmit}> 
        <h1>Sign UP</h1>

        <div className="">
          <label htmlFor="username">Username</label>
          <input
            id="username"
            type="text"
            onChange={(event) => setUsername(event.target.value)}
          />
        </div>

        <div className="">
          <label htmlFor="email">E-mail</label>
          <input
            id="email"
            type="text"
            onChange={(event) => setEmail(event.target.value)}
          />
        </div>

        <div className="">
          <label htmlFor="password">Password</label>
          <input
            id="password"
            type="password"
            onChange={(event) => setPassword(event.target.value)}
          />
        </div>

        <div className="">
          <label htmlFor="repeatPassword">Repeat Password</label>
          <input
            id="repeatPassword"
            type="password"
            onChange={(event) => setPasswordRepait(event.target.value)}
          />
        </div>

        <button
          disabled={!password || !passwordRepait || password !== passwordRepait}
        >
          Sign Up
        </button>
      </form>
    </>
  );
};

export default SignUp;

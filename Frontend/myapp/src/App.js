import { useState } from "react";
import Login from "./pages/Login";
import Sweets from "./Sweets";

export default function App() {
  const [loggedIn, setLoggedIn] = useState(!!localStorage.getItem("token"));

  return (
    <div className="container">
      {loggedIn ? (
        <>
          <button onClick={() => { localStorage.clear(); setLoggedIn(false); }}>
            Logout
          </button>
          <Sweets />
        </>
      ) : (
        <Login onLogin={() => setLoggedIn(true)} />
      )}
    </div>
  );
}

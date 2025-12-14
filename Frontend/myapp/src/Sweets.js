import { useEffect, useState } from "react";
import { getSweets, searchSweets, addSweet, deleteSweet, buySweet } from "./api";

export default function Sweets() {
  const token = localStorage.getItem("token");
  const role = localStorage.getItem("role");

  const [sweets, setSweets] = useState([]);
  const [q, setQ] = useState("");
  const [newSweet, setNewSweet] = useState({ name: "", price: "", quantity: "" });

  const load = async () => setSweets(await getSweets(token));
  useEffect(() => { load(); }, []);

  return (
    <div>
      <h2>Sweets</h2>

      <input placeholder="Search" value={q} onChange={e => setQ(e.target.value)} />
      <button onClick={async () => setSweets(await searchSweets(token, q))}>Search</button>

      {role === "ADMIN" && (
        <div className="card">
          <h3>Add Sweet</h3>
          <input placeholder="Name" onChange={e => setNewSweet({ ...newSweet, name: e.target.value })} />
          <input placeholder="Price" onChange={e => setNewSweet({ ...newSweet, price: e.target.value })} />
          <input placeholder="Quantity" onChange={e => setNewSweet({ ...newSweet, quantity: e.target.value })} />
          <button onClick={async () => { await addSweet(token, newSweet); load(); }}>Add</button>
        </div>
      )}

      {sweets.map(s => (
        <div key={s.id} className="card">
          <b>{s.name}</b> ₹{s.price} (Qty: {s.quantity})
          <button onClick={() => buySweet(token, s.id)}>Buy</button>
          {role === "ADMIN" && <button onClick={() => deleteSweet(token, s.id)}>Delete</button>}
        </div>
      ))}
    </div>
  );
}

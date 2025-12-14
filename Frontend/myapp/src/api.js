const API = "http://localhost:8080";

export const loginApi = async (data) => {
  const res = await fetch(`${API}/api/auth/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  return res.json();
};

export const getSweets = async (token) => {
  const res = await fetch(`${API}/api/sweets`, {
    headers: { Authorization: `Bearer ${token}` },
  });
  return res.json();
};

export const searchSweets = async (token, q) => {
  const res = await fetch(`${API}/api/sweets/search?q=${q}`, {
    headers: { Authorization: `Bearer ${token}` },
  });
  return res.json();
};

export const addSweet = async (token, sweet) => {
  const res = await fetch(`${API}/api/sweets`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify(sweet),
  });
  return res.json();
};

export const deleteSweet = async (token, id) => {
  await fetch(`${API}/api/sweets/${id}`, {
    method: "DELETE",
    headers: { Authorization: `Bearer ${token}` },
  });
};

export const buySweet = async (token, id) => {
  await fetch(`${API}/api/sweets/${id}/buy`, {
    method: "POST",
    headers: { Authorization: `Bearer ${token}` },
  });
};

export async function loginApi(username, password) {
  const response = await fetch("http://localhost:8080/api/auth/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ username, password }),
  });

  // ❌ handle forbidden / unauthorized
  if (!response.ok) {
    const text = await response.text();
    throw new Error(text || "Login failed");
  }

  // ✅ safely read response
  const text = await response.text();

  if (!text) {
    throw new Error("Empty response from server");
  }

  return JSON.parse(text);
}

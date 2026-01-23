const API_BASE_URL = "http://localhost:2001/api";

export async function getCourses() {
  const response = await fetch(`${API_BASE_URL}/courses`);
  return response.json();
}

export async function registerUser(data) {
  const response = await fetch(`${API_BASE_URL}/auth/register`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
  return response.json();
}

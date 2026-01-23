import { Routes, Route, Link } from "react-router-dom";
import Courses from "./pages/Courses";
import Register from "./pages/Register";
import Login from "./pages/Login";

function App() {
  return (
    <div>
      <nav>
        <Link to="/courses">Courses</Link> |{" "}
        <Link to="/register">Register</Link> |{" "}
        <Link to="/login">Login</Link>
      </nav>

      <Routes>
        <Route path="/courses" element={<Courses />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </div>
  );
}

export default App;

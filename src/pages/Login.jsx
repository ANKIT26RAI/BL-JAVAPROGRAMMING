import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

function Login() {
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        email: "",
        password: "",
    });

    const [message, setMessage] = useState("");
    const [loading, setLoading] = useState(false);

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };

    const handleLogin = async (e) => {
        e.preventDefault();
        setMessage("");
        setLoading(true);

        try {
            const response = await api.post("/api/auth/login", formData);

            localStorage.setItem("token", response.data.token);
            localStorage.setItem("message", response.data.message);

            setMessage("Login successful");

            navigate("/dashboard");
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message || "Login failed. Please check your email and password."
            );
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="page-center">
            <div className="auth-card">
                <h1>Fundoo Notes</h1>
                <p className="auth-subtitle">Login to continue</p>

                {message && <div className="message">{message}</div>}

                <form onSubmit={handleLogin}>
                    <div className="form-group">
                        <label>Email</label>
                        <input
                            type="email"
                            name="email"
                            placeholder="Enter your email"
                            value={formData.email}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="form-group">
                        <label>Password</label>
                        <input
                            type="password"
                            name="password"
                            placeholder="Enter your password"
                            value={formData.password}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <button className="primary-btn" type="submit" disabled={loading}>
                        {loading ? "Logging in..." : "Login"}
                    </button>
                </form>

                <div className="auth-links">
                    <Link to="/forgot-password">Forgot Password?</Link>
                    <span> | </span>
                    <Link to="/register">Create Account</Link>
                </div>
            </div>
        </div>
    );
}

export default Login;
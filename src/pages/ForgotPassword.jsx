import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

function ForgotPassword() {
    const [email, setEmail] = useState("");
    const [message, setMessage] = useState("");
    const [loading, setLoading] = useState(false);

    const navigate = useNavigate();

    const handleForgotPassword = async (e) => {
        e.preventDefault();
        setMessage("");
        setLoading(true);

        try {
            const response = await api.post("/api/auth/forgot-password", {
                email: email.trim(),
            });

            setMessage(response.data || "Password reset token sent to your email.");

            setTimeout(() => {
                navigate("/reset-password");
            }, 1500);

        } catch (error) {
            console.log(error);
            setMessage(
                error.message ||
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to send reset email."
            );
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="page-center">
            <div className="auth-card">
                <h1>Fundoo Notes</h1>
                <p className="auth-subtitle">Reset your password</p>

                {message && <div className="message">{message}</div>}

                <form onSubmit={handleForgotPassword}>
                    <div className="form-group">
                        <label>Registered Email</label>
                        <input
                            type="email"
                            placeholder="Enter your registered email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                    </div>

                    <button className="primary-btn" type="submit" disabled={loading}>
                        {loading ? "Sending..." : "Send Reset Token"}
                    </button>
                </form>

                <div className="auth-links">
                    <Link to="/login">Back to Login</Link>
                    <span> | </span>
                    <Link to="/reset-password">Already have token?</Link>
                </div>
            </div>
        </div>
    );
}

export default ForgotPassword;
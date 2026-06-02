import { useState, useEffect } from "react";
import { Link, useNavigate, useSearchParams } from "react-router-dom";
import api from "../api/axiosConfig";

function ResetPassword() {
    const navigate = useNavigate();
    const [searchParams] = useSearchParams();

    const [formData, setFormData] = useState({
        token: "",
        newPassword: "",
    });

    const [message, setMessage] = useState("");
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        const tokenFromUrl = searchParams.get("token");

        if (tokenFromUrl) {
            setFormData((prev) => ({
                ...prev,
                token: tokenFromUrl,
            }));
        }
    }, [searchParams]);

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };

    const handleResetPassword = async (e) => {
        e.preventDefault();
        setMessage("");

        if (!formData.token.trim()) {
            setMessage("Reset token is required.");
            return;
        }

        if (!formData.newPassword.trim()) {
            setMessage("New password is required.");
            return;
        }

        if (formData.newPassword.trim().length < 6) {
            setMessage("Password must be at least 6 characters.");
            return;
        }

        setLoading(true);

        try {
            const payload = {
                token: formData.token.trim(),
                newPassword: formData.newPassword.trim(),
            };

            const response = await api.post("/api/auth/reset-password", payload);

            setMessage(response.data || "Password reset successful.");

            setTimeout(() => {
                navigate("/login");
            }, 1200);
        } catch (error) {
            console.log(error);
            setMessage(
                error.message ||
                error.response?.data?.message ||
                error.response?.data ||
                "Password reset failed."
            );
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="page-center">
            <div className="auth-card">
                <h1>Fundoo Notes</h1>
                <p className="auth-subtitle">Enter reset token</p>

                {message && <div className="message">{message}</div>}

                <form onSubmit={handleResetPassword}>
                    <div className="form-group">
                        <label>Reset Token</label>
                        <input
                            type="text"
                            name="token"
                            placeholder="Paste token from email"
                            value={formData.token}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="form-group">
                        <label>New Password</label>
                        <input
                            type="password"
                            name="newPassword"
                            placeholder="Enter new password"
                            value={formData.newPassword}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <button className="primary-btn" type="submit" disabled={loading}>
                        {loading ? "Resetting..." : "Reset Password"}
                    </button>
                </form>

                <div className="auth-links">
                    <Link to="/login">Back to Login</Link>
                </div>
            </div>
        </div>
    );
}

export default ResetPassword;
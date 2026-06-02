import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

function Register() {
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        fullName: "",
        email: "",
        password: "",
    });

    const [errors, setErrors] = useState({});       // field-level errors
    const [message, setMessage] = useState("");
    const [loading, setLoading] = useState(false);

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
        // Clear field error as user types
        setErrors((prev) => ({ ...prev, [e.target.name]: "" }));
    };

    // ─── VALIDATION ───────────────────────────────────────────────────────────
    const validate = () => {
        const newErrors = {};
        const { fullName, email, password } = formData;

        // ── Full Name ──
        if (!fullName.trim()) {
            newErrors.fullName = "Full name is required.";
        } else if (fullName.trim().length < 2) {
            newErrors.fullName = "Name must be at least 2 characters.";
        } else if (fullName.trim().length > 50) {
            newErrors.fullName = "Name cannot exceed 50 characters.";
        } else if (!/^[a-zA-Z\s'-]+$/.test(fullName.trim())) {
            newErrors.fullName = "Name can only contain letters, spaces, hyphens, and apostrophes.";
        }

        // ── Email ──
        if (!email.trim()) {
            newErrors.email = "Email is required.";
        } else if (email.trim().length > 100) {
            newErrors.email = "Email cannot exceed 100 characters.";
        } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email.trim())) {
            newErrors.email = "Enter a valid email address.";
        }

        // ── Password ──
        if (!password) {
            newErrors.password = "Password is required.";
        } else if (password.length < 8) {
            newErrors.password = "Password must be at least 8 characters.";
        } else if (password.length > 64) {
            newErrors.password = "Password cannot exceed 64 characters.";
        } else if (!/[A-Z]/.test(password)) {
            newErrors.password = "Password must contain at least one uppercase letter.";
        } else if (!/[0-9]/.test(password)) {
            newErrors.password = "Password must contain at least one number.";
        }

        return newErrors;
    };

    // ─── SUBMIT ───────────────────────────────────────────────────────────────
    const handleRegister = async (e) => {
        e.preventDefault();
        setMessage("");

        // Run validation first — don't hit API if invalid
        const validationErrors = validate();
        if (Object.keys(validationErrors).length > 0) {
            setErrors(validationErrors);
            return;
        }

        setLoading(true);

        try {
            const registerPayload = {
                fullName: formData.fullName.trim(),
                email: formData.email.trim().toLowerCase(),
                password: formData.password,
            };

            const response = await api.post("/api/auth/register", registerPayload);

            if (response.data.token) {
                localStorage.setItem("token", response.data.token);
            }

            setMessage(response.data.message || "Registration successful");
            navigate("/dashboard");

        } catch (error) {
            // email already registered — show under email field
            const msg = error.message || error.response?.data?.message || "";
            if (msg.toLowerCase().includes("email already")) {
                setErrors({ email: "This email is already registered. Try logging in." });
            } else {
                setMessage(msg || "Registration failed. Please try again.");
            }
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="page-center">
            <div className="auth-card">
                <h1>Fundoo Notes</h1>
                <p className="auth-subtitle">Create your account</p>

                {message && <div className="message">{message}</div>}

                <form onSubmit={handleRegister} noValidate>

                    {/* Full Name */}
                    <div className="form-group">
                        <label>Full Name</label>
                        <input
                            type="text"
                            name="fullName"
                            placeholder="Enter your full name"
                            value={formData.fullName}
                            onChange={handleChange}
                            maxLength={50}
                        />
                        {errors.fullName && (
                            <span className="field-error">{errors.fullName}</span>
                        )}
                    </div>

                    {/* Email */}
                    <div className="form-group">
                        <label>Email</label>
                        <input
                            type="email"
                            name="email"
                            placeholder="Enter your email"
                            value={formData.email}
                            onChange={handleChange}
                            maxLength={100}
                        />
                        {errors.email && (
                            <span className="field-error">{errors.email}</span>
                        )}
                    </div>

                    {/* Password */}
                    <div className="form-group">
                        <label>Password</label>
                        <input
                            type="password"
                            name="password"
                            placeholder="Min 8 chars, 1 uppercase, 1 number"
                            value={formData.password}
                            onChange={handleChange}
                            maxLength={64}
                        />
                        {errors.password && (
                            <span className="field-error">{errors.password}</span>
                        )}
                    </div>

                    <button className="primary-btn" type="submit" disabled={loading}>
                        {loading ? "Creating account..." : "Register"}
                    </button>
                </form>

                <div className="auth-links">
                    <Link to="/login">Already have an account? Login</Link>
                </div>
            </div>
        </div>
    );
}

export default Register;

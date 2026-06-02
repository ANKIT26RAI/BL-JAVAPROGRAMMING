import "./index.css";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import ForgotPassword from "./pages/ForgotPassword";
import ProtectedRoute, { PublicRoute } from "./components/ProtectedRoute";  // ← added PublicRoute
import ResetPassword from "./pages/ResetPassword";
import Archive from "./pages/Archive";
import Trash from "./pages/Trash";
import Labels from "./pages/Labels";
import Export from "./pages/Export";
import Payments from "./pages/Payments";
import Attachments from "./pages/Attachments";

function App() {
    return (
        <BrowserRouter>
            <Routes>

                {/* Root — redirect to login */}
                <Route path="/" element={<Navigate to="/login" replace />} />

                {/* ── PUBLIC ROUTES ────────────────────────────────────────────
                    Wrapped in PublicRoute — if already logged in, redirects to /dashboard
                    Prevents logged-in users from seeing login/register page again
                ─────────────────────────────────────────────────────────────── */}
                <Route
                    path="/login"
                    element={
                        <PublicRoute>
                            <Login />
                        </PublicRoute>
                    }
                />
                <Route
                    path="/register"
                    element={
                        <PublicRoute>
                            <Register />
                        </PublicRoute>
                    }
                />
                <Route
                    path="/forgot-password"
                    element={
                        <PublicRoute>
                            <ForgotPassword />
                        </PublicRoute>
                    }
                />

                {/* Reset password is semi-public — token in URL, not JWT
                    Don't wrap in PublicRoute — user might be logged in and still reset */}
                <Route path="/reset-password" element={<ResetPassword />} />

                {/* ── PROTECTED ROUTES ──────────────────────────────────────────
                    Wrapped in ProtectedRoute — if no token, redirects to /login
                    401 from any API call is handled by axiosConfig interceptor
                ─────────────────────────────────────────────────────────────── */}
                <Route
                    path="/dashboard"
                    element={
                        <ProtectedRoute>
                            <Dashboard />
                        </ProtectedRoute>
                    }
                />
                <Route
                    path="/archive"
                    element={
                        <ProtectedRoute>
                            <Archive />
                        </ProtectedRoute>
                    }
                />
                <Route
                    path="/trash"
                    element={
                        <ProtectedRoute>
                            <Trash />
                        </ProtectedRoute>
                    }
                />
                <Route
                    path="/labels"
                    element={
                        <ProtectedRoute>
                            <Labels />
                        </ProtectedRoute>
                    }
                />
                <Route
                    path="/export"
                    element={
                        <ProtectedRoute>
                            <Export />
                        </ProtectedRoute>
                    }
                />
                <Route
                    path="/payments"
                    element={
                        <ProtectedRoute>
                            <Payments />
                        </ProtectedRoute>
                    }
                />
                <Route
                    path="/attachments"
                    element={
                        <ProtectedRoute>
                            <Attachments />
                        </ProtectedRoute>
                    }
                />

                {/* ── 404 — unknown route ───────────────────────────────────────
                    Catches any URL that doesn't match above routes
                    Redirects to login (or you can make a dedicated 404 page)
                ─────────────────────────────────────────────────────────────── */}
                <Route path="*" element={<Navigate to="/login" replace />} />

            </Routes>
        </BrowserRouter>
    );
}

export default App;

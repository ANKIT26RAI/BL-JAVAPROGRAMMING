import { Navigate } from "react-router-dom";

// ProtectedRoute — two jobs:
// 1. Block unauthenticated users from protected pages → redirect to /login
// 2. Block already-logged-in users from public pages → redirect to /dashboard

// Use this for PROTECTED pages (dashboard, notes, etc.)
export function ProtectedRoute({ children }) {
    const token = localStorage.getItem("token");

    if (!token) {
        // No token — send to login
        return <Navigate to="/login" replace />;
    }

    return children;
}

// Use this for PUBLIC pages (login, register) to redirect already-logged-in users
export function PublicRoute({ children }) {
    const token = localStorage.getItem("token");

    if (token) {
        // Already logged in — send to dashboard
        return <Navigate to="/dashboard" replace />;
    }

    return children;
}

// Keep default export for backward compatibility with your existing imports
export default ProtectedRoute;

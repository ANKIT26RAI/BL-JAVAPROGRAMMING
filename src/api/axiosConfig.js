import axios from "axios";

const api = axios.create({
    baseURL: import.meta.env.VITE_API_BASE_URL,
});

// ─── REQUEST INTERCEPTOR ──────────────────────────────────────────────────────
// Attaches JWT token to every non-public request
api.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem("token");

        const publicUrls = [
            "/api/auth/login",
            "/api/auth/register",
            "/api/auth/forgot-password",
            "/api/auth/reset-password",
        ];

        const isPublicUrl = publicUrls.some((url) => config.url === url);

        if (token && !isPublicUrl) {
            config.headers.Authorization = `Bearer ${token}`;
        }

        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

// ─── RESPONSE INTERCEPTOR ─────────────────────────────────────────────────────
// Handles all API errors globally — you don't need try/catch for these in pages
api.interceptors.response.use(
    // Success — just return the response as-is
    (response) => response,

    // Error — handle based on status code
    (error) => {

        // ── No response at all — network down or server unreachable ──
        if (!error.response) {
            // You can show a global toast here if you have a toast library
            // toast.error("No internet connection. Please check and retry.")
            console.error("Network error — no response received.");
            return Promise.reject({
                message: "No internet connection. Please check and retry.",
                isNetworkError: true,
            });
        }

        const status = error.response.status;

        // ── 401 — token expired, blacklisted, or missing ──
        // This handles: expired JWT, logged-out token, invalid token
        if (status === 401) {
            localStorage.removeItem("token");       // clear invalid token
            window.location.href = "/login";        // force redirect to login
            return Promise.reject(error);
        }

        // ── 403 — forbidden (valid token but no permission) ──
        if (status === 403) {
            console.error("Access forbidden.");
            return Promise.reject({
                message: "You don't have permission to perform this action.",
                status: 403,
            });
        }

        // ── 404 — resource not found ──
        if (status === 404) {
            // Don't redirect — let the page handle this
            // e.g. note deleted from another device
            return Promise.reject({
                message: error.response.data?.message || "Resource not found.",
                status: 404,
            });
        }

        // ── 400 — bad request / validation error / business rule violation ──
        if (status === 400) {
            // Pass the backend error message to the page
            return Promise.reject({
                message: error.response.data?.message || "Invalid request.",
                validationErrors: error.response.data?.messages || null, // field-level errors
                status: 400,
            });
        }

        // ── 500 — server error ──
        if (status === 500) {
            console.error("Server error:", error.response.data);
            return Promise.reject({
                message: "Something went wrong on our end. Please try again later.",
                status: 500,
            });
        }

        // ── Any other error — pass through ──
        return Promise.reject(error);
    }
);

export default api;

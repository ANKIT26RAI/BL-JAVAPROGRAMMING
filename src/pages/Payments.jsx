import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

function Payments() {
    const navigate = useNavigate();

    const [paymentStatus, setPaymentStatus] = useState(null);
    const [orderDetails, setOrderDetails] = useState(null);
    const [message, setMessage] = useState("");
    const [loadingStatus, setLoadingStatus] = useState(false);
    const [creatingOrder, setCreatingOrder] = useState(false);

    const fetchPaymentStatus = async () => {
        setLoadingStatus(true);
        setMessage("");

        try {
            const response = await api.get("/api/payments/status");
            setPaymentStatus(response.data);
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to load payment status."
            );
        } finally {
            setLoadingStatus(false);
        }
    };

    useEffect(() => {
        fetchPaymentStatus();
    }, []);

    const handleLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("message");
        navigate("/login");
    };

    const handleCreateOrder = async () => {
        setMessage("");
        setOrderDetails(null);
        setCreatingOrder(true);

        try {
            const payload = {
                amount: 19900,
                planName: "PREMIUM_MONTHLY",
            };

            const response = await api.post("/api/payments/create-order", payload);

            setOrderDetails(response.data);
            setMessage("Razorpay order created successfully.");
        } catch (error) {
            console.log(error);
            setMessage(
                error.response?.data?.message ||
                error.response?.data ||
                "Failed to create Razorpay order."
            );
        } finally {
            setCreatingOrder(false);
        }
    };

    return (
        <div className="app-layout">
            <aside className="sidebar">
                <h2>Fundoo</h2>

                <nav>
                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/dashboard")}
                    >
                        Notes
                    </button>

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/archive")}
                    >
                        Archive
                    </button>

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/trash")}
                    >
                        Trash
                    </button>

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/labels")}
                    >
                        Labels
                    </button>

                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/export")}
                    >
                        Export
                    </button>

                    <button type="button" className="sidebar-link active">
                        Payments
                    </button>
                    <button
                        type="button"
                        className="sidebar-link"
                        onClick={() => navigate("/attachments")}
                    >
                        Attachments
                    </button>
                </nav>
            </aside>

            <main className="main-content">
                <header className="topbar">
                    <div>
                        <h1>Payments</h1>
                        <p>Manage your subscription and premium access</p>
                    </div>

                    <button type="button" className="logout-btn" onClick={handleLogout}>
                        Logout
                    </button>
                </header>

                {message && <div className="dashboard-message">{message}</div>}

                <section className="payment-layout">
                    <div className="payment-card">
                        <h2>Current Plan</h2>

                        {loadingStatus ? (
                            <p>Loading payment status...</p>
                        ) : paymentStatus ? (
                            <>
                                <div
                                    className={`plan-badge ${
                                        paymentStatus.premium ? "premium-plan" : "free-plan"
                                    }`}
                                >
                                    {paymentStatus.premium ? "PREMIUM" : "FREE"}
                                </div>

                                <div className="payment-info">
                                    <p>
                                        <strong>Premium:</strong>{" "}
                                        {paymentStatus.premium ? "Yes" : "No"}
                                    </p>

                                    <p>
                                        <strong>Subscription Plan:</strong>{" "}
                                        {paymentStatus.subscriptionPlan || "FREE"}
                                    </p>

                                    <p>
                                        <strong>Start Date:</strong>{" "}
                                        {paymentStatus.subscriptionStartDate || "Not started"}
                                    </p>

                                    <p>
                                        <strong>End Date:</strong>{" "}
                                        {paymentStatus.subscriptionEndDate || "Not available"}
                                    </p>
                                </div>

                                <button
                                    type="button"
                                    className="refresh-btn"
                                    onClick={fetchPaymentStatus}
                                >
                                    Refresh Status
                                </button>
                            </>
                        ) : (
                            <p>No payment status found.</p>
                        )}
                    </div>

                    <div className="payment-card">
                        <h2>Premium Plan</h2>

                        <p className="plan-price">₹199 / month</p>

                        <ul className="premium-features">
                            <li>Unlimited notes</li>
                            <li>Excel export access</li>
                            <li>Advanced reminders</li>
                            <li>Premium badge</li>
                        </ul>

                        <button
                            type="button"
                            className="primary-small-btn payment-btn"
                            onClick={handleCreateOrder}
                            disabled={creatingOrder}
                        >
                            {creatingOrder ? "Creating Order..." : "Create Razorpay Order"}
                        </button>

                        <p className="payment-note">
                            This creates a Razorpay test order from backend. Real payment
                            verification requires Razorpay Checkout frontend response.
                        </p>
                    </div>
                </section>

                {orderDetails && (
                    <section className="order-details-card">
                        <h2>Created Order Details</h2>

                        <div className="order-grid">
                            <p>
                                <strong>Order ID:</strong> {orderDetails.orderId}
                            </p>

                            <p>
                                <strong>Amount:</strong> ₹{orderDetails.amount / 100}
                            </p>

                            <p>
                                <strong>Currency:</strong> {orderDetails.currency}
                            </p>

                            <p>
                                <strong>Plan:</strong> {orderDetails.planName}
                            </p>

                            <p>
                                <strong>Key ID:</strong> {orderDetails.keyId}
                            </p>

                            <p>
                                <strong>Message:</strong> {orderDetails.message}
                            </p>
                        </div>
                    </section>
                )}
            </main>
        </div>
    );
}

export default Payments;